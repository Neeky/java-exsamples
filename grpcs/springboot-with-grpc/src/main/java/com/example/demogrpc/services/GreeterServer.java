package com.example.demogrpc.services;

import com.example.demogrpc.rpcs.GreeterGrpc;
import com.example.demogrpc.rpcs.HelloReply;
import com.example.demogrpc.rpcs.HelloRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class GreeterServer {

    private static final Logger logger = Logger.getLogger(GreeterServer.class.getName());

    // 第一步：通过一个静态的内部类来实现真正的业务逻辑
    static class GreeterServerImpl extends GreeterGrpc.GreeterImplBase {

        @Override
        public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
            //super.sayHello(request, responseObserver);
            String name = request.getName();
            HelloReply relay = HelloReply.newBuilder().setMessage("Hello " + name + "[this is reply from MyGreeterServer]").build();
            responseObserver.onNext(relay);
            responseObserver.onCompleted();
        }
    }


    // 第二步：为我们的服务提供启动和关闭的方法
    Server server = null;

    // 第二步.1 添加启动函数
    public void start() throws IOException {
        //
        int port = 10352;
        this.server = ServerBuilder.forPort(port)
                .addService(new GreeterServerImpl())
                .build()
                .start();

        logger.info("The greatiest Server GreeterServer has been started.");

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("prepare shutdown server.");
                try {
                    // TODO
                    GreeterServer.this.stop();
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println("GreeterServer stoped.");
            }
        });
    }

    // 第二步.2 添加关闭函数
    public void stop() throws InterruptedException {
        if(this.server != null) {
            this.server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

}

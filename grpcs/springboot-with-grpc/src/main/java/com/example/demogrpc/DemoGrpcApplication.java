package com.example.demogrpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demogrpc.services.GreeterServer;

@SpringBootApplication
public class DemoGrpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGrpcApplication.class, args);

        GreeterServer server = new GreeterServer();
        try {
            server.start();
        }
        catch (Exception ex) { ex.printStackTrace();
        }

    }

}

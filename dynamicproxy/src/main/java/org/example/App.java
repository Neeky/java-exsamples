package org.example;

public class App {
    public static void main(String[] args) {
        Coder coder = new Coder();
        DynamicProxy dp = new DynamicProxy();
        dp.setWorker(coder);

        //Worker proxy = (Worker) dp.getProxy();
        Object object = dp.getProxy();
        System.out.println("getProxy 返回对象的类型 " + object.getClass().getName());
        System.out.println("getProxy 返回对象的类型 " + object.getClass().getInterfaces()[0].getName());

        Worker proxy = (Worker) object;
        String result = proxy.doWork();

        // 打到 coder.doWork() 执行后的结果
        System.out.println(result);
    }

}

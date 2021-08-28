package org.example;


import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;

public class DynamicProxy implements InvocationHandler{

    private Worker worker;

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Object getProxy() {
        System.out.println("进入动态代码的 getProxy 方法.");
        Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(),
            worker.getClass().getInterfaces(),this);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // check
        checks();

        System.out.println("通过代理调用 " + method.getName() + " 方法.");
        Object result = method.invoke(this.worker,args);

        // clean
        clean();
        return result;
    }


    void checks() {
        System.out.println("功能执行前的检查操作 -- 由代理实现");
    }

    void clean() {
        System.out.println("功能执行后的清理操作 -- 由代理实现");
    }
}

package com.apress.prospring4.ch5;


import com.apress.prospring4.ch5.Advices.ProfilingInterceptor;
import com.apress.prospring4.ch5.classes.WorkerBean;
import org.springframework.aop.framework.ProxyFactory;

public class ProfilingExample {
    public static void main(String[] args) {

        WorkerBean workerBean = getWorkBean();
        workerBean.doSomeWork(200);

    }
    private static WorkerBean getWorkBean(){
        WorkerBean target = new WorkerBean();

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(new ProfilingInterceptor());
        factory.setTarget(target);

        return (WorkerBean)factory.getProxy();
    }
}

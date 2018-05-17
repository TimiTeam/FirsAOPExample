package com.apress.prospring4.ch5.Advices;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

public class ProfilingInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        StopWatch watch = new StopWatch();
//        Started object stopWatch
        watch.start(methodInvocation.getMethod().getName());

        Object returnValue = methodInvocation.proceed();
//       Let the method call continue with proceed()
        watch.stop();
        conclusionInfo(methodInvocation,watch.getTotalTimeMillis());
        return returnValue;
    }

//    This method just show info
    private void conclusionInfo(MethodInvocation invocation, long ms){

        Method method = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();

        System.out.println("Executed method: "+method.getName());
        System.out.println("On object of type: "+target.getClass().getName());
        System.out.println("With arguments: ");
        for(int i=0;i<args.length;i++){
            System.out.print(args[i]+" - "+args[i].getClass().getSimpleName());
        }
        System.out.println("");
        System.out.println("Took: "+ms+"ms");
    }
}

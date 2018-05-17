package com.apress.prospring4.ch5.Advices;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor{

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(">> Invoking "+methodInvocation.getMethod().getName());
        Object returnValue = methodInvocation.proceed();
        System.out.println(">> Done");
        return returnValue;
    }
}

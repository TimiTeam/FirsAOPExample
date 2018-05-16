package com.apress.prospring4.ch5.Advices;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MessageDecorator implements MethodInterceptor{
//This interface for implementing a "around" board for method call connection points.

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("Hello ");
        Object retVal = methodInvocation.proceed();
        System.out.println("!");
        return retVal;
    }
}

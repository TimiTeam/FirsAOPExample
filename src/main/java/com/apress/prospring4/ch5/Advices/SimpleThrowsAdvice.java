package com.apress.prospring4.ch5.Advices;


import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class SimpleThrowsAdvice implements ThrowsAdvice {
//        The 'Interception' advice is only initiated if the method throws an exception.

    public void afterThrowing(Exception e) throws Throwable {
//        If the Method throws generic Exception this method will be called
        System.out.println("****\n Generic Exception capture!" +
                " - Caught: " + e.getClass().getName() + "\n*****");
    }

    public void afterThrowing(Method method, Object[] args, Object target,
                              IllegalArgumentException e) throws Throwable {
//        If exception is IllegalArgumentException this method will be called
        System.out.println("****\n IllegalArgumentException capture!" +
                " - Caught: " + e.getClass().getName() + "\nMethod: " +
                method.getName() + "\n*****");
    }
}

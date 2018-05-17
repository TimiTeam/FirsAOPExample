package com.apress.prospring4.ch5.Advices;


import com.apress.prospring4.ch5.classes.KeyGenerator;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {

    public void afterReturning(Object returnValue, Method method,
                               Object[] objects, Object o1) throws Throwable {
//        Check a target(o1) is a KeyGenerator?
// and the method name is 'getKey'?
        if ((o1 instanceof KeyGenerator) &&
                ("getKey".equals(method.getName()))) {
            long key = ((Long) returnValue).longValue();
            if (key == KeyGenerator.WEAK_KEY) {
                throw new SecurityException(
                        "Key Generator generated a weak ket. Try again."
                );
            }
        }
    }
}

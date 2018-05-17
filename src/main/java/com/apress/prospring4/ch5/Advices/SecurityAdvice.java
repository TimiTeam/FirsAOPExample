package com.apress.prospring4.ch5.Advices;


import com.apress.prospring4.ch5.classes.SecurityManager;
import com.apress.prospring4.ch5.classes.UserInfo;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecurityAdvice implements MethodBeforeAdvice {
    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        //Getting current user
        UserInfo user = securityManager.getLoggedOnUser();

        //Here we check whether the user is logged in
        if (user == null) {
            System.out.println("No user authenticated");
            throw new SecurityException("You must login before attempting to invoke the method: " +
                    method.getName());
        } else if ("Timur".equals(user.getUserName()) && user.getPassword().equals("123")) {
            System.out.println("Hello Timur");
        } else {
            System.out.println("Logged in user is " + user.getUserName()
                    + "NOT GOOD :(");
            throw new SecurityException("User" + user.getUserName()
                    + " is not allowed access to method " + method.getName());
        }
    }
}

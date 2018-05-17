package com.apress.prospring4.ch5;


import com.apress.prospring4.ch5.Advices.SecurityAdvice;
import com.apress.prospring4.ch5.classes.SecureBean;
import com.apress.prospring4.ch5.classes.SecurityManager;
import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {

    public static void main(String[] args) {

        SecurityManager securityManager = new SecurityManager();
        SecureBean bean = getSecureBean();

        securityManager.login("Timur", "123");
//          Here we are logging in with correct data of user
        bean.printSecureMessage();
        securityManager.logout();


        try {
            securityManager.login("invalidUser", "123");
//          Here as you see invalid users data, and we are denied access to the message
            bean.printSecureMessage();
        } catch (SecurityException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } finally {
            securityManager.logout();
        }
        try {
//          Now we are trying to get a message to non-logged user.
//          And again Denied access!
            bean.printSecureMessage();
        } catch (SecurityException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

    }

    private static SecureBean getSecureBean() {
        SecureBean target = new SecureBean();
        SecurityAdvice advice = new SecurityAdvice();

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(advice);// Registered the advice
        factory.setTarget(target);// Registered the target

        SecureBean proxy = (SecureBean) factory.getProxy();

        return proxy;
    }
}

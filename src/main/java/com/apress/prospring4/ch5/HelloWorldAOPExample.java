package com.apress.prospring4.ch5;


import com.apress.prospring4.ch5.Advices.MessageDecorator;
import com.apress.prospring4.ch5.Advices.SimpleBeforeAdvice;
import com.apress.prospring4.ch5.classes.MessageWriter;
import org.springframework.aop.framework.ProxyFactory;

public class HelloWorldAOPExample {
    public static void main(String[] args) {

        MessageWriter writer = new MessageWriter();

        ProxyFactory factory = new ProxyFactory(); //Use the ProxyFactory class
        // to create a proxy target object and simultaneously link it to the board.

        factory.addAdvice(new MessageDecorator());//This method passes advice MessageDecorator to Proxy
        factory.setTarget(writer);//And this method indicates the purpose for binding

        ProxyFactory proxyBefore = new ProxyFactory();
        proxyBefore.addAdvice(new SimpleBeforeAdvice());//Passes advice BeforeAdvice
        proxyBefore.setTarget(writer);

        MessageWriter proxy = (MessageWriter)factory.getProxy();//Generate the Proxy
        MessageWriter before = (MessageWriter)proxyBefore.getProxy();

        proxy.writeMessage();
        System.out.println("");
        before.writeMessage();

    }
}

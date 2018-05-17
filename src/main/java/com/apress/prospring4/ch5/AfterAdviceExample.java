package com.apress.prospring4.ch5;


import com.apress.prospring4.ch5.Advices.WeakKeyCheckAdvice;
import com.apress.prospring4.ch5.classes.KeyGenerator;
import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceExample {
    public static void main(String[] args) {

        KeyGenerator generator = getKeyGenerator();
        for(int i=0;i<10;i++){
            try {
                System.out.println("key :"+generator.getKey());
            }catch (SecurityException e){
                System.out.println(e.getMessage());
            }
        }

    }
    private static KeyGenerator getKeyGenerator(){
        KeyGenerator target = new KeyGenerator();

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(new WeakKeyCheckAdvice());
        factory.setTarget(target);

        return (KeyGenerator)factory.getProxy();
    }
}

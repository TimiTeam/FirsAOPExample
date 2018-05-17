package com.apress.prospring4.ch5;


import com.apress.prospring4.ch5.Advices.SimpleAdvice;
import com.apress.prospring4.ch5.classes.BeanOne;
import com.apress.prospring4.ch5.classes.BeanTwo;
import com.apress.prospring4.ch5.classes.MyBean;
import com.apress.prospring4.ch5.sections.SimpleStaticPoincut;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutExample {
    public static void main(String[] args) {

        BeanOne one = new BeanOne();
        BeanTwo two = new BeanTwo();
        one = (BeanOne) getBean(one);
        two = (BeanTwo) getBean(two);

        one.foo();
        two.foo();

        one.bar();
        two.bar();

    }

    private static MyBean getBean(MyBean bean) {

        Pointcut pointcut = new SimpleStaticPoincut();
        Advice advice = new SimpleAdvice();

        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory factory = new ProxyFactory();

        factory.addAdvisor(advisor);
        factory.setTarget(bean);

        return (MyBean) factory.getProxy();
    }
}

package com.apress.prospring4.ch5;


import com.apress.prospring4.ch5.Advices.SimpleThrowsAdvice;
import com.apress.prospring4.ch5.classes.ErrorBean;
import org.springframework.aop.framework.ProxyFactory;

public class ThrowsAdviceExample {

    public static void main(String[] args) {
        ErrorBean errorBean = getErrorBean();

        try {
            errorBean.errorProneMethod();
        } catch (Exception ignore) {
        }

        try {
            errorBean.otherErrorProneMethod();
        } catch (Exception ignore) {
        }
    }

    private static ErrorBean getErrorBean() {
        ErrorBean target = new ErrorBean();

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(new SimpleThrowsAdvice());
        factory.setTarget(target);

        return (ErrorBean) factory.getProxy();
    }
}

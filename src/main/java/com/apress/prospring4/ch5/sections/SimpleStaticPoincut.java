package com.apress.prospring4.ch5.sections;


import com.apress.prospring4.ch5.classes.BeanOne;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticPoincut extends StaticMethodMatcherPointcut{

    public boolean matches(Method method, Class<?> aClass) {
        return ("foo".equals(method.getName()));
    }


    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> aClass) {
                return (aClass == BeanOne.class);
            }
        };
    }
}

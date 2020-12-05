package com.dzc.test;

import com.dzc.bean.*;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class Main {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanFactory factory = (BeanFactory) bindViaCode(defaultListableBeanFactory);
        NewsProvider provider1 = (XhsNewsProvider)factory.getBean("xhsNewsProvider");
        provider1.showNewsListerAndNewsRegister();

        NewsProvider provider2 = (DowJonesNewsProvider)factory.getBean("djNewsProvider");
        provider2.showNewsListerAndNewsRegister();
    }

    private static Object bindViaCode(BeanDefinitionRegistry factory) {
        AbstractBeanDefinition listerner = new RootBeanDefinition(XhsNewsListennerImpl.class);
        AbstractBeanDefinition provider = new RootBeanDefinition(XhsNewsProvider.class);
        AbstractBeanDefinition register = new RootBeanDefinition(XhsNewsRegisterImpl.class);

        AbstractBeanDefinition Djlisterner = new RootBeanDefinition(DowJonesNewsListennerImpl.class);
        AbstractBeanDefinition Djprovider = new RootBeanDefinition(DowJonesNewsProvider.class);
        AbstractBeanDefinition Djregister = new RootBeanDefinition(DowJonesNewsRegisterImpl.class);
        //将bean定义注册到容器中
        factory.registerBeanDefinition("xhsNewsProvider",provider);
        factory.registerBeanDefinition("xhsNewsListerner",listerner);
        factory.registerBeanDefinition("xhsNewsRegister",register);

        factory.registerBeanDefinition("djNewsProvider",Djprovider);
        factory.registerBeanDefinition("djNewsListerner",Djlisterner);
        factory.registerBeanDefinition("djNewsRegister",Djregister);
        //指定依赖关系
        //构造方法指定
        ConstructorArgumentValues cv = new ConstructorArgumentValues();
        cv.addIndexedArgumentValue(0,listerner);
        cv.addIndexedArgumentValue(1,register);
        provider.setConstructorArgumentValues(cv);
        //setter方法指定
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("newsListenner",Djlisterner));
        propertyValues.addPropertyValue(new PropertyValue("newsRegister",Djregister));
        Djprovider.setPropertyValues(propertyValues);
        return (BeanFactory)factory;
    }
}

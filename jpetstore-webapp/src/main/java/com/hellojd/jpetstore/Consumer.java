package com.hellojd.jpetstore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Consumer
{
    public static void main( String[] args ) throws Exception
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/spring-jpetstore-domain.xml"});
        context.start();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name:beanDefinitionNames){
            System.out.println("beanName:"+name+">>>>"+context.getBean(name));
        }
    }
}

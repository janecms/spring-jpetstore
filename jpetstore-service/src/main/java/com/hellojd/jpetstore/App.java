package com.hellojd.jpetstore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/spring-context.xml"});
        context.start();
        System.out.println("dubbo server start!!!");
        System.in.read(); // 按任意键退出
    }
}

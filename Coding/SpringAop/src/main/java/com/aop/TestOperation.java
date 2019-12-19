package com.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestOperation{
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Operation.xml");
        Operation e = (Operation) context.getBean("opBean");
//        System.out.println("calling method1...");
//        e.method1();
//        System.out.println("calling method2...");
//        e.method1();
//        System.out.println("calling method3...");
//        e.method2();
        e.a1();



    }
}
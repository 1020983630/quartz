package com.sundoctor.quartz.cluster.example.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext springContext = new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml","classpath:bean-quartz.xml"});
    }

}
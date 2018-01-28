package com.sundoctor.quartz.cluster.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service("quartzTest")
public class QuartzTest implements Serializable {
    private static final long serialVersionUID = 122323233244334344L;
    private static final Logger logger = LoggerFactory.getLogger(SimpleService.class);

    public void testMethod3(){
        //这里执行定时调度业务
        logger.info("testMethod3.......3");
        System.out.println("3--testMethod3......."+System.currentTimeMillis()/1000);
    }

    public void testMethod4(){
        logger.info("testMethod4.......4");
        System.out.println("4--testMethod4......."+System.currentTimeMillis()/1000);
    }

    public void execute(){
        hello();
    }

    public String hello(){
        System.out.println(222);
        return "hello";
    }
}

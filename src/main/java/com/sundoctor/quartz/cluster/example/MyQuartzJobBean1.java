package com.sundoctor.quartz.cluster.example;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;

//@PersistJobDataAfterExecution
//@DisallowConcurrentExecution// 不允许并发执行
public class MyQuartzJobBean1 extends QuartzJobBean {

    private String targetObject;
    private String targetMethod;
    private ApplicationContext ctx;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            //LogUtils.Log("execute [" + targetObject + "] at once>>>>>>");
            Object otargetObject = ctx.getBean(targetObject);
            Method m = null;
            try {
                m = otargetObject.getClass().getMethod(targetMethod, new Class[] {JobExecutionContext.class}); //方法中的参数是JobExecutionContext类型
                m.invoke(otargetObject, new Object[] {context});
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new JobExecutionException(e);
        }
    }
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.ctx = applicationContext;
    }

    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }

}
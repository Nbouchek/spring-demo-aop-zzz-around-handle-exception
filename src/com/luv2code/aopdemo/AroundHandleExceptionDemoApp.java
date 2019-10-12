package com.luv2code.aopdemo;

import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {
    private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain Program: AroundDemoApp");
        myLogger.info("\nCalling getFortune");
        boolean tripWire = true;
        String data = theTrafficFortuneService.getFortune(true);
        myLogger.info("\nMy fortune is: " + data);
        myLogger.info("\nFinished");
        // close the context
        context.close();
    }
}

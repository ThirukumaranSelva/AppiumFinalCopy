package com.qa.stepdef;

import com.qa.utils.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.lv.Un;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;

import java.io.IOException;

public class Hooks {

    @Before
    public void initialize() throws Exception {
        new VideoManager().startRecording();
       /* GlobalParams globalParams=new GlobalParams();
        globalParams.initializeGlobalParams();
        *//* Creating Logs for this method *//*
        ThreadContext.put("ROUTINGKEY",globalParams.getPlatformName()+"_"+globalParams.getDeviceName());
        *//* Start server *//*
        ServerManager serverManager=new ServerManager();
        serverManager.startServer();
        new DriverManager().initializeDriver();*/
    }

    @After
    public void quit(Scenario scenario) throws IOException {

        new VideoManager().stopRecording(scenario.getName());
        if (scenario.isFailed()){
           byte[] screenshot= new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }

       /* DriverManager driverManager=new DriverManager();
        if(driverManager.getDriver()!=null) {
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
            Utils.logger().info("Driver Quit!");
        }
        ServerManager serverManager=new ServerManager();
        if(serverManager.getServer()!=null){
            serverManager.getServer().stop();
            Utils.logger().info("Appium Server Stopped!");
        }


  */
}}

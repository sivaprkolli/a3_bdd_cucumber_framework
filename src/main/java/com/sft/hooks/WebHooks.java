package com.sft.hooks;

import com.sft.automation.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebHooks {

    /*public  DriverFactory driverFactory;
    public WebHooks(){
        driverFactory = new DriverFactory();
    }*/

    @BeforeAll
    public static void initialize(){
        DriverFactory.initializeDrivers();
    }

    @Before
    public static void beforeScenario(){
        DriverFactory.launchApplication();
    }

    @BeforeStep
    public static void beforeStep(){

    }

    @AfterAll
    public static void killSession(){


    }

    @After
    public static void afterEveryScenario(){
        DriverFactory.killDriver();
    }

    @AfterStep
    public static void afterEveryStep(){

    }
}

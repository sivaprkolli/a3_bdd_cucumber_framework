package com.sft.hooks;

import com.sft.automation.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.sft.automation.DriverFactory.initializeWebDriver;
import static com.sft.automation.DriverFactory.launchApplication;

public class WebHooks {

   // @BeforeAll
    public static void initialize(){
        initializeWebDriver();
    }

   // @Before
    public static void beforeScenario(){
        initializeWebDriver();
        launchApplication();
    }

    @BeforeStep
    public static void beforeStep(){

    }

    @AfterAll
    public static void killSession(){


    }

    @After
    public static void afterEveryScenario(){
        DriverFactory.killDrivers();
    }

    @AfterStep
    public static void afterEveryStep(){

    }
}

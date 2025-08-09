package com.sft.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {

    protected static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void initializeDrivers(){
        driverThreadLocal.set(new ChromeDriver());
    }

    public static void launchApplication(){
        getDriver().get("https://www.saucedemo.com/");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public static void killDriver(){
        getDriver().quit();
    }
}

package com.sft.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver driver;

    public static void initializeDrivers(){
        driver = new ChromeDriver();
    }

    public static void launchApplication(){
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public static void killDriver(){
        driver.quit();
    }
}

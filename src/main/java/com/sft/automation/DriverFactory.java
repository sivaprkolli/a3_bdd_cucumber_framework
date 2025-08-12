package com.sft.automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;
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

    public static void launchMobileApplication(String environment) throws MalformedURLException {
        switch (environment){
            case "android":
                UiAutomator2Options automator2Options = new UiAutomator2Options();
                automator2Options.setPlatformName("Android");
                automator2Options.setPlatformVersion("16.0");
                automator2Options.setAutomationName("UiAutomator2");
                automator2Options.setDeviceName("Samsung");
                automator2Options.setAppPackage("com.stonecircle.community");
                automator2Options.setAppWaitActivity("com.stonecircle.community.MainActivity");
                driverThreadLocal.set(new AndroidDriver(new URL("http://127.0.0.1:4723"), automator2Options));
                getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                break;
            case "ios":
                XCUITestOptions xcuiTestOptions = new XCUITestOptions();
                xcuiTestOptions.setAutomationName("XCUITest");
                xcuiTestOptions.setPlatformVersion("26.0");
                xcuiTestOptions.setPlatformName("iOS");
                xcuiTestOptions.setDeviceName("iPhone 13");
                xcuiTestOptions.setUdid("00008110-000834382623A01E");
                xcuiTestOptions.autoAcceptAlerts();
                xcuiTestOptions.setBundleId("com.stonecircle.community");
                driverThreadLocal.set(new IOSDriver(new URL("http://127.0.0.1:4723"), xcuiTestOptions));
                getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                break;
            default:
                throw new IllegalArgumentException("Unsupported environment: " + environment);
        }
    }
}

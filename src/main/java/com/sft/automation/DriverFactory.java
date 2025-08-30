package com.sft.automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    protected static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<AppiumDriver> mobileDriverThreadLocal = new ThreadLocal<>();


    public static WebDriver getWebDriver() {
        return webDriverThreadLocal.get();
    }

    public static void initializeWebDriver() {
        webDriverThreadLocal.set(new ChromeDriver());
    }

    public static AppiumDriver getMobileDriver() {
        return mobileDriverThreadLocal.get();
    }

    public static void killDrivers() {
        if (webDriverThreadLocal != null) {
            getWebDriver().quit();
        }
        if (mobileDriverThreadLocal != null) {
            getMobileDriver().quit();
        }
    }

    public static void getScreenShotOnFailure(WebDriver driver, Scenario scenario) {
        if (driver instanceof ChromeDriver) {
            try {
               byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        } else if (driver instanceof AppiumDriver) {
            try {
                byte[] screenshot = ((TakesScreenshot) getMobileDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
    }


    public static AppiumDriver launchMobileApplication(String environment) throws MalformedURLException {
        switch (environment) {
            case "android":
                UiAutomator2Options automator2Options = new UiAutomator2Options();
                automator2Options.setPlatformName("Android");
                automator2Options.setPlatformVersion("16.0");
                automator2Options.setAutomationName("UiAutomator2");
                automator2Options.setDeviceName("Samsung");
                automator2Options.setAppPackage("com.stonecircle.community");
                automator2Options.setAppWaitActivity("com.stonecircle.community.MainActivity");
                mobileDriverThreadLocal.set(new AndroidDriver(new URL("http://127.0.0.1:4723"), automator2Options));
                getMobileDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                return mobileDriverThreadLocal.get();
            case "ios":
                XCUITestOptions xcuiTestOptions = new XCUITestOptions();
                xcuiTestOptions.setAutomationName("XCUITest");
                xcuiTestOptions.setPlatformVersion("26.0");
                xcuiTestOptions.setPlatformName("iOS");
                xcuiTestOptions.setDeviceName("iPhone 13");
                xcuiTestOptions.setUdid("00008110-000834382623A01E");
                xcuiTestOptions.autoAcceptAlerts();
                xcuiTestOptions.setBundleId("com.stonecircle.community");
                mobileDriverThreadLocal.set(new IOSDriver(new URL("http://127.0.0.1:4723"), xcuiTestOptions));
                getMobileDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                return mobileDriverThreadLocal.get();

            default:
                throw new IllegalArgumentException("Unsupported environment: " + environment);
        }
    }


    public static void launchApplication() {
        getWebDriver().get("https://www.saucedemo.com/");
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
}

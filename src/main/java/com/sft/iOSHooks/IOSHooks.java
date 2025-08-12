package com.sft.iOSHooks;

import com.sft.automation.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.net.MalformedURLException;

import static com.sft.automation.DriverFactory.getDriver;
import static com.sft.automation.DriverFactory.launchMobileApplication;

public class IOSHooks {

    @Before
    public static void beforeScenario() throws MalformedURLException {
        launchMobileApplication("ios");
    }

    @After
    public static void afterEveryScenario(Scenario scenario){

        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
        DriverFactory.killDriver();
    }
}

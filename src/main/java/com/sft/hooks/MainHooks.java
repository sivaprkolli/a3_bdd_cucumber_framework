package com.sft.hooks;

import com.sft.automation.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.net.MalformedURLException;

import static com.sft.automation.DriverFactory.*;

public class MainHooks {

    @Before
    public static void launchApplications(Scenario scenario) throws MalformedURLException {
        if (scenario.getSourceTagNames().contains("@Web")){
            initializeWebDriver();
            launchApplication();
            launchMobileApplication("android");
        } else {
            launchMobileApplication("android");
        }
    }


    @After(order = 1)
    public static void afterEveryScenario(Scenario scenario){
        try {
            getScreenShotOnFailure(getWebDriver(), scenario);
        }catch (Exception e){
            getScreenShotOnFailure(getMobileDriver(), scenario);
        }
    }

    @After(order = 0)
    public static void killSessions(){
        killDrivers();
    }
}

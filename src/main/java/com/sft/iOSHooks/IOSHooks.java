package com.sft.iOSHooks;

import com.sft.automation.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.net.MalformedURLException;
import static com.sft.automation.DriverFactory.launchMobileApplication;

public class IOSHooks {

    @Before
    public static void beforeScenario() throws MalformedURLException {
        launchMobileApplication("ios");
    }


}

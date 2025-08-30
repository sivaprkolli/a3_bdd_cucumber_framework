package com.sft.mobileHooks;

import io.cucumber.java.Before;
import java.net.MalformedURLException;

import static com.sft.automation.DriverFactory.*;

public class MobileHooks {

    @Before
    public static void beforeScenario() throws MalformedURLException {
        launchMobileApplication("android");
    }
}

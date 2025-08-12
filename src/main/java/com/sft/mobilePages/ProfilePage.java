package com.sft.mobilePages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    IOSDriver iOSDriver;


    public ProfilePage(WebDriver iOSDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(iOSDriver), this);
        this.iOSDriver = (IOSDriver) iOSDriver;
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Profile\"]")
    private WebElement profileTab;

    @iOSXCUITFindBy(xpath = "//*[@name='₦0']/following-sibling::XCUIElementTypeOther")
    private WebElement settingsButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Panic\"])[1]")
    private WebElement panicOption;

    @iOSXCUITFindBy(xpath = "(//*[@name='Panic Setting'])/preceding-sibling::*/*")
    private WebElement panicSettingButton;

    public void enterPanicPin() {
        iOSDriver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[@name=\"1\"])[1]")).

                click();
        iOSDriver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[@name=\"2\"])[1]")).

                click();
        iOSDriver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[@name=\"3\"])[1]")).

                click();
        iOSDriver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[@name=\"4\"])[1]")).

                click();
    }
    public void navigateToProfile() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        profileTab.click();
    }

    public void openSettings() {
        settingsButton.click();
    }
    public void openPanicOption() {
        panicOption.click();
    }

    public void openPanicSettings() {
        panicSettingButton.click();
    }

}

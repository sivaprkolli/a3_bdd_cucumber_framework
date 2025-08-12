package com.sft.mobilePages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public SignInPage(WebDriver androidDriver){
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    /*public SignInPage(IOSDriver iOSDriver){
        PageFactory.initElements(new AppiumFieldDecorator(iOSDriver), this);
    }*/

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Allow\")")
    //@iOSXCUITFindBy(iOSNsPredicate = )
    private WebElement allowButton;

    @AndroidFindBy(accessibility = "Next")
    private WebElement nextButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"I already have an account\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'I already have an account'")
    private WebElement alreadyHaveAccount;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter your Email\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Enter your Email\"]")
    private WebElement enterEmail;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter your Password\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Enter your Password\"]")
    private WebElement enterPassword;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Login\"]")
    private WebElement loginButton;


    public void login(String username, String password) {
        allowButton.click();
        nextButton.click();
        alreadyHaveAccount.click();
        enterEmail.sendKeys(username);
        enterPassword.sendKeys(password);
        loginButton.click();
    }



}

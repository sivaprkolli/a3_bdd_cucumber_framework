package com.sft.mobilePages;

import com.sft.utils.MobileActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MomentsPage {

    private AndroidDriver androidDriver;
    private IOSDriver iOSDriver;

    public MomentsPage(WebDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        try {
            this.androidDriver = (AndroidDriver) driver;
        } catch (ClassCastException ce) {
            this.iOSDriver = (IOSDriver) driver;
        }
    }

    /*public MomentsPage(IOSDriver iOSDriver){
        PageFactory.initElements(new AppiumFieldDecorator(iOSDriver), this);
        this.iOSDriver = iOSDriver;
    }*/

    @AndroidFindBy(className = "com.horcrux.svg.RectView")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'I already have an account'")
    private WebElement momentLikeButton;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup/android.widget.ImageView)[5]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'I already have an account'")
    private WebElement momentLogoButton;

    @AndroidFindBy(accessibility = "Panic")
    @iOSXCUITFindBy(accessibility = "Panic")
    private WebElement panicButton;

    @AndroidFindBy(xpath = "(//com.horcrux.svg.RectView)[7]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther)")
    private WebElement panicTarget;

    @AndroidFindBy(xpath = "(//com.horcrux.svg.RectView)[1]")
    @iOSXCUITFindBy(accessibility = "Okay")
    private WebElement panicCloseButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Allow\")")
    private WebElement allowButton;

    public void setLikeForMoment() {
        allowButton.click();
        //androidDriver.findElement(AppiumBy.className("com.horcrux.svg.RectView")).click();
        momentLikeButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        momentLogoButton.click();
    }

    public void navigateToMomentLogo() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        panicButton.click();

    }

    public void setPanic() {
        MobileActions mobileActions = new MobileActions();
        mobileActions.dragAndDrop(panicButton, panicTarget, androidDriver);
        panicCloseButton.click();
    }

    public void setPanicIOS() {
        MobileActions mobileActions = new MobileActions();
        mobileActions.dragAndDropIOS(panicButton, panicTarget, iOSDriver);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        panicCloseButton.click();
    }
}

package com.sft.mobilePages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.cucumber.java.bs.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ChatsPage {
    AndroidDriver androidDriver;


    public ChatsPage(WebDriver androidDriver){
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
        this.androidDriver = (AndroidDriver) androidDriver;
    }

    /*public ChatsPage(IOSDriver iOSDriver){
        PageFactory.initElements(new AppiumFieldDecorator(iOSDriver), this);
    }*/

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Chats\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'I already have an account'")
    private WebElement chatsTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"StoneCircle\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'I already have an account'")
    private WebElement stoneCircleChat;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"While using the app\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'I already have an account'")
    private WebElement whileUsingAppOption;

    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'I already have an account'")
    private WebElement messageInputField;

    @AndroidFindBy(xpath = "(//com.horcrux.svg.RectView)[1]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'I already have an account'")
    private WebElement sendMessageButton;

    @AndroidFindBy(xpath = "//*[@text='StoneCircle']/following-sibling::*[2]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'I already have an account'")
    private WebElement sentMessage;

    @AndroidFindBy(xpath = "//*[@text='StoneCircle']/preceding-sibling::android.view.ViewGroup/com.horcrux.svg.SvgView")
    private WebElement backButton;

    public void navigateToChats() {
        chatsTab.click();
    }

    public void sendMessageInChat(String message) {

        try{
            try {
                androidDriver.findElement(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Start a chat\")")).click();
            }catch (Exception e){}

            androidDriver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"My Mobile\")")).click();
            whileUsingAppOption.click();
            messageInputField.click();
            messageInputField.sendKeys(message);
            sendMessageButton.click();
            androidDriver.findElement(AppiumBy.xpath("//*[@text='Mobile My']/preceding-sibling::android.view.ViewGroup/com.horcrux.svg.SvgView")).click();

        }catch (Exception e){
            stoneCircleChat.click();
            whileUsingAppOption.click();
            messageInputField.click();
            messageInputField.sendKeys(message);
            sendMessageButton.click();
            backButton.click();
        }

    }

    public String getChatDetails() {
        try {Thread.sleep(3000);} catch (InterruptedException e) {}
        String lastMessage = null;
        try{
           lastMessage = androidDriver.findElement(AppiumBy.xpath("//*[@text='Mobile My']/following-sibling::*[1]")).getText();
        } catch (Exception e) {
            lastMessage = sentMessage.getText();
            System.out.println("Last Message: " + lastMessage);
        }
        return lastMessage;
    }
}

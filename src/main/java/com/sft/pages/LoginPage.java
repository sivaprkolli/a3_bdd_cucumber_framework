package com.sft.pages;

import com.sft.automation.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameInputBox = By.id("user-name");
    private By passwordInputBox = By.id("password");
    private By loginButton = By.cssSelector("[name='login-button']");

    private By loginCredentials = By.xpath("//div[@id=\"login_credentials\"]");


    public void enterCredentials(String userName, String password) {
        driver.findElement(userNameInputBox).sendKeys(userName);
        driver.findElement(passwordInputBox).sendKeys(password);
    }

    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getUsernames(){
        return driver.findElement(loginCredentials).getText();
    }
}

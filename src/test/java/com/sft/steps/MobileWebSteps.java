package com.sft.steps;

import com.sft.mobilePages.SignInPage;
import com.sft.pages.LoginPage;
import com.sft.pages.ProductsPage;
import io.cucumber.java.en.Given;

import static com.sft.automation.DriverFactory.getMobileDriver;
import static com.sft.automation.DriverFactory.getWebDriver;

public class MobileWebSteps {

    LoginPage loginPage;
    ProductsPage productsPage;
    SignInPage signInPage;

    public MobileWebSteps(){
        signInPage = new SignInPage(getMobileDriver());
        loginPage = new LoginPage(getWebDriver());
        productsPage = new ProductsPage(getWebDriver());
    }

    @Given("User on web landing page")
    public void userOnWebLandingPage() {
        loginPage.enterCredentials("performance_glitch_user","secret_sauce");
        loginPage.clickOnLoginButton();
    }

    @Given("User on mobile landing page")
    public void userOnMobileLandingPage() {
        signInPage.login("siva8kolli@gmail.com","Appium@123");
    }
}

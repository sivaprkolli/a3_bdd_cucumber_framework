package com.sft.steps;

import com.sft.automation.DriverFactory;
import com.sft.mobilePages.ChatsPage;
import com.sft.mobilePages.MomentsPage;
import com.sft.mobilePages.ProfilePage;
import com.sft.mobilePages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.sql.DriverManager;

public class IOSSteps extends DriverFactory {

    SignInPage signInPage;
    MomentsPage momentsPage;
    ChatsPage chatsPage;
    ProfilePage profilePage;


    public IOSSteps(){
        signInPage = new SignInPage(getDriver());
        momentsPage = new MomentsPage(getDriver());
        chatsPage = new ChatsPage(getDriver());
        profilePage = new ProfilePage(getDriver());

    }

    @Given("I have opened the application")
    public void iHaveOpenedTheApplication() {
        System.out.println("Application is opened on iOS Real device");
    }

    @When("I navigate to the profile screen")
    public void iNavigateToTheProfileScreen() {
        profilePage.navigateToProfile();
    }

    @And("I enter the panic PIN {string}")
    public void iEnterThePanicPIN(String arg0) {
        profilePage.openSettings();
        profilePage.openPanicOption();
        profilePage.enterPanicPin();

    }

    @And("I go to panic settings")
    public void iGoToPanicSettings() {
        profilePage.openPanicSettings();
    }

    @And("I log out of the application")
    public void iLogOutOfTheApplication() {
        signInPage.logout();
    }

    @And("I log in to the application")
    public void iLogInToTheApplication() {
        signInPage.loginIOS("siva8kolli@gmail.com","Appium@123");
    }

    @And("I drag and drop the panic icon onto the panic target")
    public void iDragAndDropThePanicIconOntoThePanicTarget() {
        momentsPage.navigateToMomentLogo();
        momentsPage.setPanicIOS();
    }
}

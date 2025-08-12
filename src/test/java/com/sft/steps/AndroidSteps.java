package com.sft.steps;

import com.sft.automation.DriverFactory;
import com.sft.mobilePages.ChatsPage;
import com.sft.mobilePages.MomentsPage;
import com.sft.mobilePages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AndroidSteps extends DriverFactory {

    SignInPage signInPage;
    MomentsPage momentsPage;
    ChatsPage chatsPage;


    public AndroidSteps(){
        signInPage = new SignInPage(getDriver());
        momentsPage = new MomentsPage(getDriver());
        chatsPage = new ChatsPage(getDriver());

    }

    @Given("I am logged into the application")
    public void loginToApplication() {
        signInPage.login("siva8kolli@gmail.com","Appium@123");
    }

    @When("I like or unlike the video")
    public void iLikeOrUnlikeTheVideo() {
        momentsPage.setLikeForMoment();
    }

    @And("I navigate to the chats screen")
    public void iNavigateToTheChatsScreen() {
        chatsPage.navigateToChats();
    }

    @And("I enter the message {string} in the chat box")
    public void iEnterTheMessageInTheChatBox(String message) {
        chatsPage.sendMessageInChat(message);
    }

    @Then("I should see the message {string} displayed in the chat")
    public void iShouldSeeTheMessageDisplayedInTheChat(String message) {
        Assert.assertEquals(chatsPage.getChatDetails(), message, "Message is not displayed correctly in the chat");
    }

    @When("I tap on the panic option")
    public void iTapOnThePanicOption() {
        momentsPage.navigateToMomentLogo();
    }

    @And("I drag and drop the panic icon onto the available panic target")
    public void iDragAndDropThePanicIconOntoTheAvailablePanicTarget() {
        momentsPage.setPanic();
    }

    @Then("the panic action should be successfully triggered")
    public void thePanicActionShouldBeSuccessfullyTriggered() {

    }
}

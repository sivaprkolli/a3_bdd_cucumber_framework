package com.sft.steps;

import com.sft.automation.DriverFactory;
import com.sft.automation.ScenarioContext;
import com.sft.hooks.WebHooks;
import com.sft.pages.LoginPage;
import com.sft.pages.ProductsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class LoginSteps extends DriverFactory {

    public LoginPage loginPage;
    public ProductsPage productsPage;

    public ScenarioContext scenarioContext;

    public LoginSteps(){
        scenarioContext = new ScenarioContext();
    }




    @Given("User on landing page")
    public void user_on_landing_page() {
        loginPage = new LoginPage(getDriver());
        productsPage = new ProductsPage(getDriver());
    }
    @When("User enter username and password")
    public void user_enter_username_and_password() {
        loginPage.enterCredentials(scenarioContext.getContext("un"), scenarioContext.getContext("pwd"));
    }
    @When("User click on login button")
    public void user_click_on_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("User verify welcome page")
    public void userVerifyWelcomePage() {
        Assert.assertEquals(productsPage.getProductsHeading(), "Products");
    }

    @When("User enter {string} and {string}")
    public void userEnterAnd(String username, String password) {
        loginPage.enterCredentials(username,password);
    }

    @When("User enter credentials")
    public void userEnterCredentials(DataTable dataTable) {
        List<String> credentials = dataTable.row(0);
        System.out.println(credentials);

        String userName = credentials.get(0);
        String password = credentials.get(1);
        System.out.println(userName);
        System.out.println(password);

        loginPage.enterCredentials(userName,password);
    }

    @Then("User verify welcome page with username")
    public void user_verify_welcome_page_with_username() {
        System.out.println("Welcome page with username");
    }

    @When("User enter credentials using header")
    public void user_enter_credentials_using_header(DataTable dataTable){
        List<Map<String, String>> maps = dataTable.asMaps(String.class, String.class);

        System.out.println(maps);
        String un = "";
        String pwd = "";
        for (Map<String, String> data : maps){
            un = data.get("username");
            pwd = data.get("password");
        }
        loginPage.enterCredentials(un, pwd);

    }

    @And("User save credentials")
    public void userSaveCredentials() {
//        String userNames = loginPage.getUsernames();
//        System.out.println(userNames);
        // assume that I got creds
        String username = "performance_glitch_user";
        String password = "secret_sauce";
        scenarioContext.setContext("un", username);
        scenarioContext.setContext("pwd", password);

    }
}

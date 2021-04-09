package StepDefinitions;

import Common.DriverSetup;
import Common.PageObjectManager;
import Common.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import PageObjects.*;

public class LoginStepDefinition {


    LoginPage loginPage;
    TestContext testContext;

    public LoginStepDefinition(TestContext context){
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @And("User enters login details (.*) and (.*)")
    public void userEntersLoginDetails(String email, String password) {
        loginPage.enterUserName(email);
        loginPage.enterPasswordAndSubmit(password);
    }

    @Then("User should be able to login successfully with (.*)")
    public void loginSuccess(String email) {
        loginPage.validateLoginSuccess(email);
    }


}

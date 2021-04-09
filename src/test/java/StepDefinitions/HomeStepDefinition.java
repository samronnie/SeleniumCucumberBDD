package StepDefinitions;

import Common.DriverSetup;
import Common.PageObjectManager;
import Common.TestContext;
import io.cucumber.java.en.Given;
import PageObjects.HomePage;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;

public class HomeStepDefinition {

    TestContext testContext;

    public HomeStepDefinition(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    HomePage homePage;

    @Given("User has launched the webpage")
    public void user_has_launched_the_webpage() {
        homePage.navigateToHomePage();
    }

    @When("User navigates to login page")
    public void navigateToLoginFromHome() {
        homePage.navigateToLoginPage();
    }

}

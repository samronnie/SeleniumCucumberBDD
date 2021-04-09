package PageObjects;

import Common.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverHelper {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public final String email = "username";
    @FindBy(id = email)
    public WebElement emailInput;

    public final String continueButton = "loginSubmit";
    @FindBy(id = continueButton)
    public WebElement continueButtonSubmit;

    public final String password = "password";
    @FindBy(id = password)
    public WebElement passwordInput;


    public final String serviceMenu = "app-header-home__menu-hamburger-icon";
    @FindBy(className = serviceMenu)
    public WebElement serviceMenuItem;


    public String containsText = "//*[contains(text(),'%s')]";


    public void enterUserName(String email) {
        explicitlyWaitForElement(driver, emailInput);
        type(driver, emailInput, email);
        click(driver, continueButtonSubmit);
    }


    public void enterPasswordAndSubmit(String password) {
        explicitlyWaitForElement(driver, passwordInput);
        type(driver, passwordInput, password);
        click(driver, continueButtonSubmit);
        explicitlyWaitForElement(driver, serviceMenuItem);
    }

    public void validateLoginSuccess(String email) {
        verifyElementIsVisible(driver, serviceMenuItem, "Service Menu");
        click(driver, serviceMenuItem);
        verifyElementIsVisible(driver, prepareWebElementWithDynamicValue(driver, "xpath", containsText, email), "Logged in user");
    }
}

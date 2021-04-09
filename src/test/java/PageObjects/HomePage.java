package PageObjects;

import Common.DriverHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DriverHelper{
    LoginPage loginPage;
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, this);
    }

    public final String acceptCookie = "//button[@title='Akkoord']";
    @FindBy(xpath = acceptCookie)
    public WebElement acceptCookieBanner;


    public final String frame = "//iframe[contains(@id,'sp_message_iframe')]";
    @FindBy(xpath = frame)
    public WebElement cookieFrame;

    public final String loginButton = "tm-call2action";
    @FindBy(className = loginButton)
    public WebElement loginButtonElement;


    public void navigateToHomePage() {
        navigate(configuration.baseUrl());
        explicitlyWaitForFrame(driver, cookieFrame);
        explicitlyWaitForElement(driver, acceptCookieBanner);
        click(driver, acceptCookieBanner);
        switchToDefaultWindow();
        validateTitle("DPG Media Privacy Gate");
        explicitlyWaitForClickable(driver, By.className(loginButton));

    }

    public void navigateToLoginPage(){
        click(driver,loginButtonElement);
        explicitlyWaitForElement(driver,loginPage.emailInput);
    }

}

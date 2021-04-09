package Common;

import org.openqa.selenium.WebDriver;
import PageObjects.*;

public class PageObjectManager {

    private WebDriver driver;

    private HomePage homePage;
    private LoginPage loginPage;
    private SearchPage searchPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public SearchPage getSearchPage() {
        return (searchPage == null) ? searchPage = new SearchPage(driver) : searchPage;

    }

}

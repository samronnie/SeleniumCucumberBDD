package PageObjects;

import Common.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends DriverHelper {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public final String searchImage = "app-header-home__menu-search-icon";
    @FindBy(className = searchImage)
    public WebElement searchImageArticle;


    public final String searchBox = "query";
    @FindBy(name = searchBox)
    public WebElement articleSearchBox;


    public final String submitArticle = "//input[@type='submit']";
    @FindBy(xpath = submitArticle)
    public WebElement submitArticleButton;


    public final String articleList = "//body/main[@id='main-content']/div[1]/article";
    @FindBy(xpath = articleList)
    public WebElement articleListBar;


    @FindBy(linkText = "Columnisten")
    public WebElement columnsTile;


    @FindBy(className = "results-filter")
    public WebElement columnsFilter;


    public void navigateToSearchPage() {
        explicitlyWaitForElement(driver, searchImageArticle);
        click(driver, searchImageArticle);
        explicitlyWaitForElement(driver, articleSearchBox);
        verifyElementIsVisible(driver, articleSearchBox, "Article Search Box");
    }

    public void enterArticleToSearch(String article) {
        type(driver, articleSearchBox, article);
        click(driver, submitArticleButton);
    }

    public void validateSearchResult(String article) {
        verifyElementIsVisible(driver, articleListBar, "Article List");
    }

    public void navigateToTile(String typeOfTile) {
        switch (typeOfTile) {
            case "Columnists":
                explicitlyWaitForElement(driver, columnsTile);
                click(driver, columnsTile);
                break;
        }
        verifyElementIsVisible(driver, columnsFilter, "Columns filter");
    }

}

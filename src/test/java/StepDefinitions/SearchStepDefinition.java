package StepDefinitions;

import Common.DriverSetup;
import Common.PageObjectManager;
import Common.TestContext;
import PageObjects.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class SearchStepDefinition {

    SearchPage searchPage;
    TestContext testContext;

    public SearchStepDefinition(TestContext context){
        testContext = context;
        searchPage = testContext.getPageObjectManager().getSearchPage();
    }

    @And("User clicks on search article icon")
    public void userClicksOnSearchArticle() {
        searchPage.navigateToSearchPage();
    }


    @And("User searches for article named (.*)")
    public void userSearchesArticle(String article) {
        searchPage.enterArticleToSearch(article);
    }

    @Then("User should find result for the searched article (.*)")
    public void checkSearchedArticle(String article){
        searchPage.validateSearchResult(article);
    }


    @And("User navigate to (.*) tile")
    public void navigateToSpecificTile(String typeOfTile){
       searchPage.navigateToTile(typeOfTile);
    }
}

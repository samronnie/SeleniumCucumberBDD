Feature: Validate article search functionality

  @Search @Regression
  Scenario: As a user, user should be to search an article
    Given User has launched the webpage
    When User clicks on search article icon
    And User searches for article named corona virus
    Then User should find result for the searched article corona virus

  @NavigateToColumnisten @Regression
  Scenario: As a user, user should be able to navigate to Columnisten
    Given User has launched the webpage
    When User clicks on search article icon
    And User navigate to Columnists tile

Feature: Validate user login functionality

  @Regression @Login
  Scenario: As a registered user, user should be able to logged in
    Given User has launched the webpage
    When User navigates to login page
    And User enters login details smrj47@gmail.com and dpgAutomation_
    Then User should be able to login successfully with smrj47@gmail.com




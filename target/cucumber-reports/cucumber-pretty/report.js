$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/Features/ValidateLogin.feature");
formatter.feature({
  "name": "Validate user login functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "As a registered user, user should be able to logged in",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Regression"
    },
    {
      "name": "@Login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User has launched the webpage",
  "keyword": "Given "
});
formatter.match({
  "location": "HomeStepDefinition.user_has_launched_the_webpage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to login page",
  "keyword": "When "
});
formatter.match({
  "location": "HomeStepDefinition.navigateToLoginFromHome()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters login details smrj47@gmail.com and dpgAutomation_",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDefinition.userEntersLoginDetails(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to login successfully with smrj47@gmail.com",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.loginSuccess(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});
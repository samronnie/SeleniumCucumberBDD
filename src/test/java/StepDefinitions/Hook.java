package StepDefinitions;

import Common.DriverSetup;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends DriverSetup {

    @Before
    public void hookUp(Scenario scenario) {
        logger.info("***Execution of \"" + scenario.getName() + "\" has started.***");
        initBrowsers();
    }

    @After
    public void teardown(Scenario scenario) {
        logger.info("***Execution of \"" + scenario.getName() + "\" is completed. Result " + scenario.getStatus() + "***");
        quitDriver();
    }

}

package Runner;


import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/java/Features", strict = true, glue = {"StepDefinitions"},
        tags = {"@Login"}, plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
        "json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun.txt"})
public class TestNgCucumberScenarioRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
    public void feature(PickleEventWrapper pickleEventWrapper,
                        CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEventWrapper.getPickleEvent());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }

}


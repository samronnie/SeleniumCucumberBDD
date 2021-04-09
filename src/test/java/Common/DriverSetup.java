package Common;

import io.cucumber.core.api.Scenario;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;


public class DriverSetup {
    public final Logger logger = Logger.getLogger(DriverSetup.class);
    public static Configuration configuration = ConfigurationManager.getConfiguration();
    public static  boolean isHeadless;
    public static String browserName;
    public ChromeOptions chromeOptions;
    public static WebDriver driver;


    public DriverSetup() {
        isHeadless = configuration.isHeadLess();
        browserName = configuration.browserName();
    }

    public WebDriver getDriver() {
        if (driver == null) driver = initBrowsers();
        return driver;
    }

    /**
     * Function to initialize drivers based on the browser configuration mentioned in config.properties
     */
    public WebDriver initBrowsers() {

        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = initChrome(isHeadless);
                break;
            case "firefox":
                driver = initFirefox(isHeadless);
                break;
        }
        return driver;
    }

    protected WebDriver initChrome(Boolean isHeadless) {

        logger.info("Setting Chrome web driver...");
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        chromeOptions.addArguments("--ignore-certificate-errors");

        if (isHeadless) {
            logger.info("Setting up arguments for Chrome driver");
            chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
                    "--ignore-certificate-errors");
            chromeOptions.setExperimentalOption("useAutomationExtension", false);
            chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            logger.info("Arguments set up is completed.");
        }
        driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    protected WebDriver initFirefox(Boolean isHeadless) {
        WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        if (isHeadless) {
            try {
                firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }


    public void quitDriver(){
        driver.quit();
    }
}

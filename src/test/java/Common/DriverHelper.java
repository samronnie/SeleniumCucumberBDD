package Common;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class DriverHelper extends DriverSetup {

    private static int TIME_OUT_IN_SECONDS = 60;

    /**
     * Function to find element and highlight
     *
     * @param driver Web driver object
     * @param elem   web element to identify
     * @param color  highlighting element
     */

    public void findElementAndHighlight(WebDriver driver, WebElement elem, String color) {
        try {
            explicitlyWaitForElement(driver, elem);
            if (driver instanceof JavascriptExecutor) {
                logger.info("Highlighting: " + elem);
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid " + color + "'",
                        elem);

            }
        } catch (NoSuchElementException e) {
            logger.error("Element highlight method could not find the locator: " + elem);
        } catch (Exception e) {
            logger.error("Some error occurred while highlighting the locator: " + elem);
        }

    }

    /**
     * Function to wait for presence of the element
     *
     * @param driver  Web driver object
     * @param locator web element to identify
     * @return
     */
    public WebElement explicitlyWaitForElement(WebDriver driver, WebElement locator) {
        WebElement foundLocator = null;
        try {

            WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
            wait.ignoring(StaleElementReferenceException.class);
            foundLocator = wait.until(ExpectedConditions.visibilityOf(locator));
        } catch (TimeoutException e) {
            handleException(e, locator);
        }
        return foundLocator;
    }


    /**
     * Function to wait for frame and switch to it
     *
     * @param driver  Web driver object
     * @param locator web element to identify
     */
    public void explicitlyWaitForFrame(WebDriver driver, WebElement locator) {
        try {
            WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
            wait.ignoring(StaleElementReferenceException.class);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
        } catch (TimeoutException e) {
            handleException(e, locator);
        }
    }

    /**
     * Navigate to specific url
     *
     * @param url Url to navigate
     */
    public void navigate(String url) {
        driver.get(url);
    }

    /**
     * Function to handle exception
     *
     * @param e       exception
     * @param locator web element to identify
     */
    private void handleException(TimeoutException e, WebElement locator) {
        throw new RuntimeException("Timeout looking for " + locator.toString() + " after " + TIME_OUT_IN_SECONDS + " seconds at page " + driver.getCurrentUrl());
    }


    /**
     * Function to validate web page tile
     *
     * @param expected Expected Title of web page
     */
    public void validateTitle(String expected) {
        String actualText = driver.getTitle();
        Assert.assertEquals(actualText, expected);
    }

    /**
     * Function to click
     *
     * @param driver Webdriver object
     * @param ele    web element to identify
     */
    public void click(WebDriver driver, WebElement ele) {
        try {
            findElementAndHighlight(driver, ele, "red");
            ele.click();
        } catch (NoSuchElementException e) {
            handleException(e);
        } catch (StaleElementReferenceException e) {
            findElementAndHighlight(driver, ele, "red");
            ele.click();
        }
    }

    protected void handleException(NoSuchElementException e) {
        Assert.fail(e.getMessage() + " on page " + driver.getCurrentUrl());
    }


    /**
     * function to wait for element to be clickable
     *
     * @param driver  Webdriver object
     * @param locator By object to identify
     * @return returns element
     */
    public WebElement explicitlyWaitForClickable(WebDriver driver, By locator) {
        WebElement foundLocator = null;
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        wait.ignoring(StaleElementReferenceException.class);
        foundLocator = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return foundLocator;
    }

    /**
     * Function to switch to default content/window
     */

    public void switchToDefaultWindow() {
        driver.switchTo().defaultContent();
    }


    /**
     * Function to type value
     *
     * @param driver Webdriver object
     * @param ele    By object to identify
     * @param value  Input to be entered
     */

    public void type(WebDriver driver, WebElement ele, String value) {
        try {
            findElementAndHighlight(driver, ele, "red");
            ele.click();
            ele.clear();
            ele.sendKeys(value);
        } catch (NoSuchElementException e) {
            handleException(e);
        }

    }

    /**
     * @param: String locator. This method verifies if the element is visible.
     */
    public void verifyElementIsVisible(WebDriver driver, WebElement locator, String locatorName) {
        findElementAndHighlight(driver, locator, "green");
        assertTrue(locator.isDisplayed());
        logger.info(locatorName + " is displayed");
    }


    /**
     * Function to replace a string
     *
     * @param regex       regular expression to replace
     * @param actualValue value to be replaced
     * @return updated string
     */
    public String getStringFormat(String regex, String actualValue) {
        return String.format(regex, actualValue);
    }

    /**
     * Function to dynamically generate the webelement by substituting strings
     *
     * @param driver            Webdriver object
     * @param locator           Webelement
     * @param runtimeValue      value to be passed during the run time
     * @param substitutionValue value to be substituted
     * @return
     */
    public WebElement prepareWebElementWithDynamicValue(WebDriver driver, String locator, String runtimeValue,
                                                        String substitutionValue) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        WebElement we = null;
        try {
            if (locator.equalsIgnoreCase("id")) {

                we = driver.findElement(By.id(getStringFormat(runtimeValue, substitutionValue)));

            } else if (locator.equalsIgnoreCase("class")) {
                we = driver.findElement(By.className(getStringFormat(runtimeValue, substitutionValue)));
            } else if (locator.equalsIgnoreCase("name")) {
                we = driver.findElement(By.name(getStringFormat(runtimeValue, substitutionValue)));
            } else if (locator.equalsIgnoreCase("css")) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(getStringFormat(runtimeValue, substitutionValue))));
                we = driver.findElement(By.cssSelector(getStringFormat(runtimeValue, substitutionValue)));
            } else if (locator.equalsIgnoreCase("xpath")) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(getStringFormat(runtimeValue, substitutionValue))));
                we = driver.findElement(By.xpath(getStringFormat(runtimeValue, substitutionValue)));
            } else if (locator.equalsIgnoreCase("linktext")) {
                we = driver.findElement(By.linkText(getStringFormat(runtimeValue, substitutionValue)));
            } else {
                return null;
            }

        } catch (NoSuchElementException ignore) {
            handleException(ignore);
        }
        return we;
    }
}

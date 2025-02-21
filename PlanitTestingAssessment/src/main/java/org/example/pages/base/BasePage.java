package org.example.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    //simplify common methods to be used by child pages
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void waitForElementToExist(By locator, int milliseconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        //Wait given amount of ms for element to load, polling every 50ms
        wait.withTimeout(Duration.ofMillis(milliseconds));
        wait.pollingEvery(Duration.ofMillis(50));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitForElementToHaveAttribute(By locator, String attribute, String value, int milliseconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        //Wait given amount of ms for element to load, polling every 50ms
        wait.withTimeout(Duration.ofMillis(milliseconds));
        wait.pollingEvery(Duration.ofMillis(50));
        wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    protected void waitForElementToNotBeVisible(By locator, int milliseconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofMillis(milliseconds));
        wait.pollingEvery(Duration.ofMillis(50));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected List<WebElement> findElementList(By locator) {
        List<WebElement> elementList = driver.findElements(locator);
        return elementList;
    }

}

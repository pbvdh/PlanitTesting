package org.example.pages.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

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

    protected void waitForElementToBeClickable(By locator, int milliseconds) {
        FluentWait wait = new FluentWait(driver);
        //Wait given amount of ms for element to load, polling every 100ms
        wait.withTimeout(Duration.ofMillis(milliseconds));
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}

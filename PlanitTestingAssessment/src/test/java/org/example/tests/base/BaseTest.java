package org.example.tests.base;

import org.example.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;

    /*
    set up and tear down methods to be inherited by child tests
    */

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        basePage = new BasePage();
        basePage.setDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}

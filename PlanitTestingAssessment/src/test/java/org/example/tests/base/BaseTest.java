package org.example.tests.base;

import org.example.pages.base.BasePage;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;


    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        basePage = new BasePage();
        basePage.setDriver(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}

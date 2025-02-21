package org.example.pages;

import org.example.pages.Base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends BasePage {

    private final By contactNavLink = By.id("nav-contact");
    private final By shopNavLink = By.id("nav-shop");
    private final By homeNavLink = By.id("nav-home");
    private By cartNavLink = By.id("nav-cart");

    public HomePage(){
        //wait for page to load and verify that "home" is the active button in the navbar
        waitForElementToBeClickable(homeNavLink, 2000);
        Assert.assertTrue(find(homeNavLink).getDomAttribute("class").contains("active"), "Page navigation button not active");
    }

    public void navigateToShopPage() {
        click(shopNavLink);
    }

    public void navigateToContactPage() {
        click(contactNavLink);
    }

    public void navigateToCart() {
        click(cartNavLink);
    }
}


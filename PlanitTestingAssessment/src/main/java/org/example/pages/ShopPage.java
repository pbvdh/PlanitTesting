package org.example.pages;

import org.example.pages.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ShopPage extends BasePage {

    private By shopNavLink = By.id("nav-shop");
    public ShopPage() {
        //wait for page to load and verify that "shop" is the active button in the navbar
        waitForElementToExist(shopNavLink, 1000);
        waitForElementToHaveAttribute(shopNavLink, "class", "active", 1000);
    }
}

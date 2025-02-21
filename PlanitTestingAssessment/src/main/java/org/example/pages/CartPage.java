package org.example.pages;

import org.example.pages.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CartPage extends BasePage {
    private final By cartNavLink = By.id("nav-cart");

    public CartPage() {
        //wait for page to load and verify that "cart" is the active button in the navbar
        waitForElementToExist(cartNavLink, 1000);
        waitForElementToHaveAttribute(cartNavLink, "class", "active", 1000);
    }
}

package org.example.pages;

import org.example.pages.base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By contactNavLink = By.id("nav-contact");
    private final By homeNavLink = By.id("nav-home");

    public HomePage(){
        //wait for page to load and verify that "home" is the active button in the navbar
        waitForElementToExist(homeNavLink, 1000);
        waitForElementToHaveAttribute(homeNavLink, "class", "active", 1000);
    }

    public void navigateToContactPage() {
        click(contactNavLink);
    }

}


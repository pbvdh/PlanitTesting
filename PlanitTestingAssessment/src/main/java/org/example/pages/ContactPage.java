package org.example.pages;

import org.example.pages.Base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ContactPage extends BasePage {
    private final By contactNavLink = By.id("nav-contact");
    public ContactPage() {
        //wait for page to load and verify that "contact" is the active button in the navbar
        waitForElementToBeClickable(contactNavLink, 2000);
        Assert.assertTrue(find(contactNavLink).getDomAttribute("class").contains("active"), "Page navigation button not active");
    }
}

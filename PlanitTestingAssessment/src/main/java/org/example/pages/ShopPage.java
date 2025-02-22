package org.example.pages;

import org.example.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ShopPage extends BasePage {

    private final By shopNavLink = By.id("nav-shop");
    private final By cartNavLink = By.id("nav-cart");
    //assumption: product ids correlate to specific products and won't change
    private final By shopItems = By.className("product");
    private final By productTitle = By.className("product-title");
    private final By purchaseButton = By.linkText("Buy");

    public ShopPage() {
        //wait for page to load and verify that "shop" is the active button in the navbar
        waitForElementToExist(shopNavLink, 1000);
        waitForElementToHaveAttribute(shopNavLink, "class", "active", 1000);
    }

    public void navigateToCartPage() {
        click(cartNavLink);
    }

    //buy a given quantity of a named item
    public void buyShopItems(String name, int quantity) {
        //list of all shop item web elements
        List<WebElement> shopItemsList = findElementList(shopItems);

        //for each shop item
        for (WebElement shopItem : shopItemsList) {
            //if the title matches the text we are looking for
            if (shopItem.findElement(productTitle).getText().equals(name)) {
                //click the purchase button as many times as the desired quantity
                for (int i = 0; i < quantity; i++) {
                    shopItem.findElement(purchaseButton).click();
                }
                //stop looking as we found our item
                return;
            }
        }
        //if we are still in the method (didn't find item and return): fail as we did not find the item.
        Assert.fail("Item named '" + name + "' not found on shop page.");
    }

}

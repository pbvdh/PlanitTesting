package org.example.pages;

import org.example.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    private final By cartNavLink = By.id("nav-cart");
    private final By cartItems = By.className("cart-item");
    private final By cartTotal = By.className("total");

    public CartPage() {
        //wait for page to load and verify that "cart" is the active button in the navbar
        waitForElementToExist(cartNavLink, 1000);
        waitForElementToHaveAttribute(cartNavLink, "class", "active", 1000);
    }

    public double getPriceOfItem(String itemName) {
        //All table rows with items
        List<WebElement> cartItemsList = findElementList(cartItems);
        //for each table row
        for(WebElement cartItem : cartItemsList){
            //if the first cell has the name of the item we are looking for
            if(cartItem.findElement(By.xpath("td[1]")).getText().contains(itemName)){
                //then get the 2nd data cell and extract the price from it
                WebElement itemPriceCell = cartItem.findElement(By.xpath("td[2]"));
                return Double.parseDouble(itemPriceCell.getText().replace("$", ""));
            }
        }
        //if no matching item found
        return -1;
    }

    public double getSubtotalOfItem(String itemName) {
        //All table rows with items
        List<WebElement> cartItemsList = findElementList(cartItems);
        //for each table row
        for(WebElement cartItem : cartItemsList){
            //if the first cell has the name of the item we are looking for
            if(cartItem.findElement(By.xpath("td[1]")).getText().contains(itemName)){
                //Then get the fourth data cell and extract the subtotal from it
                WebElement itemSubtotalCell = cartItem.findElement(By.xpath("td[4]"));
                return Double.parseDouble(itemSubtotalCell.getText().replace("$", ""));
            }
        }
        //if no matching item found
        return -1;
    }

    public double getTotalPriceOfCart(){
        //find 'total' cell and remove extra characters
        String total = find(cartTotal).getText().replace("Total: ","");
        return Double.parseDouble(total);
    }

}

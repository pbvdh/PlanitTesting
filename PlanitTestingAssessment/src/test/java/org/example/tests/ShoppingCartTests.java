package org.example.tests;

import org.example.pages.CartPage;
import org.example.pages.ShopPage;
import org.example.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ShoppingCartTests extends BaseTest {
    protected String shopPageUrl = "https://jupiter.cloud.planittesting.com/#/shop";
    @Test
    public void testShoppingCartPricesAndTotals() {
        driver.get(shopPageUrl);
        ShopPage shopPage = new ShopPage();

        //Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
        shopPage.buyShopItems("Stuffed Frog", 2);
        shopPage.buyShopItems("Fluffy Bunny", 5);
        shopPage.buyShopItems("Valentine Bear", 3);

        //go to the cart page
        shopPage.navigateToCartPage();
        CartPage cartPage = new CartPage();


        //verify the price for each product
        Assert.assertEquals(cartPage.getPriceOfItem("Stuffed Frog"), 10.99,
                "\n The price per Stuffed Frog should be correct \n");
        Assert.assertEquals(cartPage.getPriceOfItem("Valentine Bear"), 14.99,
                "\n The price per Valentine Bear should be correct \n");
        Assert.assertEquals(cartPage.getPriceOfItem("Fluffy Bunny"), 9.99,
                "\n The price per Fluffy Bunny should be correct \n");


        //verify the subtotal for each product is correct
        Assert.assertEquals(cartPage.getSubtotalOfItem("Stuffed Frog"), 21.98,
                "\n The subtotal for Stuffed Frogs should be correct \n");
        Assert.assertEquals(cartPage.getSubtotalOfItem("Valentine Bear"), 44.97,
                "\n The subtotal for Valentine Bears should be correct \n");
        Assert.assertEquals(cartPage.getSubtotalOfItem("Fluffy Bunny"), 49.95,
                "\n The subtotal for Fluffy Bunnies should be correct \n");

        //verify that the total is the sum of the sub totals
        double sumOfSubtotals =
                cartPage.getSubtotalOfItem("Stuffed Frog") +
                cartPage.getSubtotalOfItem("Valentine Bear") +
                cartPage.getSubtotalOfItem("Fluffy Bunny");
        Assert.assertEquals(cartPage.getTotalPriceOfCart(), sumOfSubtotals,
                "\n The total price displayed for the cart should equal the sum of the subtotals for each item \n");

    }
}
package org.example.tests;

import org.example.pages.ShopPage;
import org.example.tests.base.BaseTest;
import org.testng.annotations.Test;

public class ShoppingCartTests extends BaseTest {
    protected String shopPageUrl = "https://jupiter.cloud.planittesting.com/#/shop";
    @Test
    public void testShoppingCartPricesAndTotals() {
        driver.get(shopPageUrl);
        ShopPage shopPage = new ShopPage();
    }
}
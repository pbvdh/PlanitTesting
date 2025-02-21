package org.example.tests;

import org.example.tests.base.BaseTest;
import org.testng.annotations.Test;

public class ContactFormTests extends BaseTest {

    @Test
    public void testValidContactForm() {
        homePage.navigateToContactPage();
    }

    @Test
    public void testResubmitEmptyContactForm() {

    }
}

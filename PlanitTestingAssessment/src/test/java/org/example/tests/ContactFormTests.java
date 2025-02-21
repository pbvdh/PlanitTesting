package org.example.tests;

import org.example.pages.ContactPage;
import org.example.pages.HomePage;
import org.example.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class ContactFormTests extends BaseTest {
    protected String homePageUrl = "https://jupiter.cloud.planittesting.com/#/home";
    @Test
    public void testValidContactForm() {
        driver.get(homePageUrl);
        HomePage homePage = new HomePage();
        homePage.navigateToContactPage();
        ContactPage contactPage = new ContactPage();

        String forename = "Joe";
        String email = "JoeBloggs@email.com";
        //to create unique input information each time & be able to trace test
        String message = "Test message " + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

        contactPage.populateContactForm(forename, email, message);
        contactPage.submitContactForm();
        contactPage.waitForSuccessMessage();
        Assert.assertEquals(contactPage.getAlertMessage(), "Thanks " + forename + ", we appreciate your feedback.",
                "\n Success alert should display correct message containing forename. \n");
    }

    @Test
    public void testResubmitEmptyContactForm() {
        driver.get(homePageUrl);
        HomePage homePage = new HomePage();
        homePage.navigateToContactPage();
        ContactPage contactPage = new ContactPage();
        contactPage.submitContactForm();
        contactPage.waitForErrorMessage();

        String expectedErrorMessage = "We welcome your feedback - but we won't get it unless you complete the form correctly.";
        Assert.assertEquals(contactPage.getAlertMessage(), expectedErrorMessage,
                "\n Error alert should display correct message. \n");
        Assert.assertTrue(contactPage.emailErrorExists() && contactPage.forenameErrorExists() && contactPage.messageErrorExists(),
                "\n There should be visible errors for email, forename and message. \n");

        String forename = "Bob";
        String email = "BobSmith@email.com";
        //to create unique input information each time & be able to trace test
        String message = "Test message " + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        contactPage.populateContactForm(forename, email, message);

        Assert.assertFalse(contactPage.emailErrorExists() || contactPage.forenameErrorExists() || contactPage.messageErrorExists(),
                "None of the email, forename or message errors should be visible.");
        Assert.assertNotEquals(contactPage.getAlertMessage(), expectedErrorMessage,
                "\n Current alert should no longer display the same error message. \n");

    }
}

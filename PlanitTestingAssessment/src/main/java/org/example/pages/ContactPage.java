package org.example.pages;

import org.example.pages.base.BasePage;
import org.openqa.selenium.By;

public class ContactPage extends BasePage {
    private final By contactNavLink = By.id("nav-contact");
    private final By submitButton = By.linkText("Submit");
    private final By forenameField = By.id("forename");
    private final By emailField = By.id("email");
    private final By messageField = By.id("message");
    private final By submissionAlert = By.className("alert");
    private final By modalProgressBar = By.className("progress-info");

    //error messages
    private final By forenameError = By.id("forename-err");
    private final By emailError = By.id("email-err");
    private final By messageError = By.id("message-err");


    public ContactPage() {
        //wait for "contact" to be the active button in the navbar
        waitForElementToExist(contactNavLink, 1000);
        waitForElementToHaveAttribute(contactNavLink, "class","active",1000);
    }

    public void submitContactForm() {
        click(submitButton);
    }

    public void populateContactForm(String forename, String email, String message) {
        set(forenameField, forename);
        set(emailField, email);
        set(messageField, message);
    }

    public void waitForSuccessMessage(int milliseconds) {
        waitForElementToNotBeVisible(modalProgressBar, milliseconds);
        waitForElementToHaveAttribute(submissionAlert, "class", "alert-success", 100);
    }

    public String getAlertMessage() {
        return find(submissionAlert).getText();
    }

    public void waitForErrorMessage() {
        waitForElementToHaveAttribute(submissionAlert, "class", "alert-error", 100);
    }

    public boolean forenameErrorExists(){
        return !findElementList(forenameError).isEmpty();
    }
    public boolean emailErrorExists(){
        return !findElementList(emailError).isEmpty();
    }
    public boolean messageErrorExists(){
        return !findElementList(messageError).isEmpty();
    }


}

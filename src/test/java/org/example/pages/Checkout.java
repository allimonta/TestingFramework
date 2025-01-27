package org.example.pages;
import org.example.bases.BasePageObjects;
import org.example.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Checkout extends BasePageObjects {
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeinput = By.id("postal-code");
    private By cancelButton = By.id("cancel");
    private By continueButton = By.id("continue");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public Checkout() {
        super();
    }

    public void CheckoutScreenIsComplete() {
        Assert.assertTrue(driver.findElement(screenTitle).isDisplayed(), "Checkout title is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(firstNameInput).isDisplayed(), "First Name input is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(lastNameInput).isDisplayed(), "Last Name input is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(postalCodeinput).isDisplayed(), "Postal code is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(cancelButton).isDisplayed(), "Cancel button is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(continueButton).isDisplayed(), "Continue button is not displayed in Checkout screen");
        Assert.assertEquals(driver.findElement(screenTitle).getText(), Constants.CHECKOUT_TITLE_TXT);
        Assert.assertEquals(driver.findElement(firstNameInput).getAttribute("placeholder"), Constants.FIRST_NAME_TXT);
        Assert.assertEquals(driver.findElement(lastNameInput).getAttribute("placeholder"), Constants.LAST_NAME_TXT);
        Assert.assertEquals(driver.findElement(postalCodeinput).getAttribute("placeholder"), Constants.ZIP_CODE_TXT);
        Assert.assertEquals(driver.findElement(cancelButton).getText(), Constants.CANCEL_TXT);
        Assert.assertEquals(driver.findElement(continueButton).getAttribute("value"), Constants.CONTINUE_TXT);
    }

    public void ClickContinue() {
        WebElement continueBtn = driver.findElement(continueButton);
        Assert.assertTrue(continueBtn.isDisplayed());
        continueBtn.click();
    }

    public void ErrorMessageDisplayed() {
        WebElement error = driver.findElement(errorMessage);
        Assert.assertTrue(error.isDisplayed(), "Error message is not displayed");
        Assert.assertEquals(error.getText(), Constants.ERROR_FIRST_NAME_MSG);
    }

    public void FieldsInErrorValidation() {
        Assert.assertEquals(driver.findElement(firstNameInput).getAttribute("class"), Constants.ERROR_CLASS_NAME);
        Assert.assertEquals(driver.findElement(lastNameInput).getAttribute("class"), Constants.ERROR_CLASS_NAME);
        Assert.assertEquals(driver.findElement(postalCodeinput).getAttribute("class"), Constants.ERROR_CLASS_NAME);
    }

    public void EnterText(By element, String text) {
        WebElement elementToText = driver.findElement(element);
        Assert.assertTrue(elementToText.isDisplayed());
        elementToText.sendKeys(text);
        Assert.assertEquals(elementToText.getAttribute("value"), text);
    }

    public void EnterCheckoutValidInformation() {
        EnterText(firstNameInput, Constants.FIRST_NAME);
        EnterText(lastNameInput, Constants.LAST_NAME);
        EnterText(postalCodeinput, Constants.ZIP_CODE);
    }
}

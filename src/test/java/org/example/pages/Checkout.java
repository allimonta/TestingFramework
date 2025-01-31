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
        AssertTrue(GetElement(screenTitle).isDisplayed());
        AssertTrue(GetElement(firstNameInput).isDisplayed());
        AssertTrue(GetElement(lastNameInput).isDisplayed());
        AssertTrue(GetElement(postalCodeinput).isDisplayed());
        AssertTrue(GetElement(cancelButton).isDisplayed());
        AssertTrue(GetElement(continueButton).isDisplayed());
        AssertEquals(GetElement(screenTitle).getText(), Constants.CHECKOUT_TITLE_TXT);
        AssertEquals(GetElement(firstNameInput).getAttribute("placeholder"), Constants.FIRST_NAME_TXT);
        AssertEquals(GetElement(lastNameInput).getAttribute("placeholder"), Constants.LAST_NAME_TXT);
        AssertEquals(GetElement(postalCodeinput).getAttribute("placeholder"), Constants.ZIP_CODE_TXT);
        AssertEquals(GetElement(cancelButton).getText(), Constants.CANCEL_TXT);
        AssertEquals(GetElement(continueButton).getAttribute("value"), Constants.CONTINUE_TXT);
    }

    public void ClickContinue() {
        CLickElement(continueButton);
    }

    public void ErrorMessageDisplayed() {
        WebElement error = GetElement(errorMessage);
        AssertTrue(error.isDisplayed());
        AssertEquals(error.getText(), Constants.ERROR_FIRST_NAME_MSG);
    }

    public void FieldsInErrorValidation() {
        AssertEquals(GetElement(firstNameInput).getAttribute("class"), Constants.ERROR_CLASS_NAME);
        AssertEquals(GetElement(lastNameInput).getAttribute("class"), Constants.ERROR_CLASS_NAME);
        AssertEquals(GetElement(postalCodeinput).getAttribute("class"), Constants.ERROR_CLASS_NAME);
    }

    public void EnterCheckoutValidInformation() {
        TypeText(firstNameInput, Constants.FIRST_NAME);
        TypeText(lastNameInput, Constants.LAST_NAME);
        TypeText(postalCodeinput, Constants.ZIP_CODE);
    }
}

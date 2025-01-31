package org.example.pages;

import org.example.bases.BasePageObjects;
import org.example.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage extends BasePageObjects {

    private By continueShoppingButton = By.cssSelector("#continue-shopping");
    private By checkoutButton = By.cssSelector("#checkout");
    private By descriptionLabel = By.cssSelector(".cart_desc_label");
    private By quantityLabel = By.cssSelector(".cart_quantity_label");
    private By removeButtons = By.cssSelector("[id*='remove']");

    public CartPage() {
        super();
    }

    public void CartScreenIsCompleted() {
        AssertTrue(GetElement(continueShoppingButton).isDisplayed());
        AssertTrue(GetElement(checkoutButton).isDisplayed());
        AssertTrue(GetElement(screenTitle).isDisplayed());
        AssertTrue(GetElement(descriptionLabel).isDisplayed());
        AssertTrue(GetElement(quantityLabel).isDisplayed());
        AssertEquals(GetElement(continueShoppingButton).getText(), Constants.CONTINUE_SHOPPING_BUTTON);
        AssertEquals(GetElement(checkoutButton).getText(), Constants.CHECKOUT_BUTTON);
        AssertEquals(GetElement(screenTitle).getText(), Constants.YOUR_CART_TXT);
        AssertEquals(GetElement(descriptionLabel).getText(), Constants.DESCRIPTION_TXT);
        AssertEquals(GetElement(quantityLabel).getText(), Constants.QYT_TXT);
    }

    public void DeleteProduct() {
        WebElement firstElement = SmartWait(5).until(ExpectedConditions.visibilityOfElementLocated(removeButtons));
        AssertTrue(firstElement.isDisplayed());
        AssertEquals(firstElement.getText(), Constants.REMOVE_TXT);
        firstElement.click();
    }

    public void GoToCheckout() {
        CLickElement(checkoutButton);
        AssertEquals(driver.getCurrentUrl(), Constants.CHECKOUT_STEP_1_URL);
    }
}

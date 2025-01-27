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

    public CartPage(){
        super();
    }

    public void CartScreenIsCompleted(){
        Assert.assertTrue(driver.findElement(continueShoppingButton).isDisplayed(), "Continue Shopping button is not displayed in Cart screen");
        Assert.assertTrue(driver.findElement(checkoutButton).isDisplayed(), "Checkout button is not displayed in Cart screen");
        Assert.assertTrue(driver.findElement(screenTitle).isDisplayed(), "Cart Title is not displayed in Cart screen");
        Assert.assertTrue(driver.findElement(descriptionLabel).isDisplayed(), "Description label is not displayed in Cart screen");
        Assert.assertTrue(driver.findElement(quantityLabel).isDisplayed(), "Quantity label is not displayed in Cart screen");
        Assert.assertEquals(driver.findElement(continueShoppingButton).getText(), Constants.CONTINUE_SHOPPING_BUTTON);
        Assert.assertEquals(driver.findElement(checkoutButton).getText(), Constants.CHECKOUT_BUTTON);
        Assert.assertEquals(driver.findElement(screenTitle).getText(), Constants.YOUR_CART_TXT);
        Assert.assertEquals(driver.findElement(descriptionLabel).getText(), Constants.DESCRIPTION_TXT);
        Assert.assertEquals(driver.findElement(quantityLabel).getText(), Constants.QYT_TXT);
    }

    public void DeleteProduct(){
            WebElement firstElement = SmartWait(5).until(ExpectedConditions.visibilityOfElementLocated(removeButtons));
            Assert.assertTrue(firstElement.isDisplayed(), "First product is displayed");
            Assert.assertEquals(firstElement.getText(), Constants.REMOVE_TXT);
            firstElement.click();
        }

    public void GoToCheckout(){
        WebElement checkout = driver.findElement(checkoutButton);
        Assert.assertTrue(checkout.isDisplayed());
        checkout.click();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.CHECKOUT_STEP_1_URL);
    }
}

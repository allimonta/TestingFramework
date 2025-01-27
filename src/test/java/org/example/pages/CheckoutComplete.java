package org.example.pages;
import org.example.bases.BasePageObjects;
import org.example.utils.Constants;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckoutComplete extends BasePageObjects {
    private By confirmImg = By.cssSelector("[data-test='pony-express']");
    private By confirmSubTitle = By.cssSelector("[data-test='complete-header']");
    private By confirmDescription = By.cssSelector("[class='complete-text']");
    private By backHomeButton = By.id("back-to-products");

    public CheckoutComplete(){
        super();
    }

    public void CompleteScreenIsCorrectlyDisplayed(){
        Assert.assertTrue(driver.findElement(screenTitle).isDisplayed(), "Checkout: Complete! title is not displayed in Complete screen");
        Assert.assertTrue(driver.findElement(confirmImg).isDisplayed(), "Complete Image is not displayed in Complete screen");
        Assert.assertTrue(driver.findElement(confirmSubTitle).isDisplayed(), "Subtitle is not displayed in Complete screen");
        Assert.assertTrue(driver.findElement(confirmDescription).isDisplayed(), "Description is not displayed in Complete screen");
        Assert.assertTrue(driver.findElement(backHomeButton).isDisplayed(), "Back home button is not displayed in Complete screen");
        Assert.assertEquals(driver.findElement(screenTitle).getText(), Constants.CHECKOUT_COMPLETE_TITLE_TXT);
        Assert.assertEquals(driver.findElement(confirmSubTitle).getText(), Constants.CHECKOUT_COMPLETE_SUBTITLE_TXT);
        Assert.assertEquals(driver.findElement(confirmDescription).getText(), Constants.CHECKOUT_COMPLETE_DESCRIPTION_TXT);
        Assert.assertEquals(driver.findElement(backHomeButton).getText(), Constants.BACK_HOME_BUTTON);
    }
}

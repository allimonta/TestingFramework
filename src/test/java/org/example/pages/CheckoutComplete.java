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
        AssertTrue(GetElement(screenTitle).isDisplayed());
        AssertTrue(GetElement(confirmImg).isDisplayed());
        AssertTrue(GetElement(confirmSubTitle).isDisplayed());
        AssertTrue(GetElement(confirmDescription).isDisplayed());
        AssertTrue(GetElement(backHomeButton).isDisplayed());
        AssertEquals(GetElement(screenTitle).getText(), Constants.CHECKOUT_COMPLETE_TITLE_TXT);
        AssertEquals(GetElement(confirmSubTitle).getText(), Constants.CHECKOUT_COMPLETE_SUBTITLE_TXT);
        AssertEquals(GetElement(confirmDescription).getText(), Constants.CHECKOUT_COMPLETE_DESCRIPTION_TXT);
        AssertEquals(GetElement(backHomeButton).getText(), Constants.BACK_HOME_BUTTON);
    }
}

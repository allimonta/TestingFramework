package org.example.bases;
import org.example.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.time.Duration;

public class BasePageObjects {
    protected WebDriver driver;
    protected By bannerTitle = By.cssSelector(".app_logo");
    protected By screenTitle = By.cssSelector(".title");
    protected By menuBar = By.id("react-burger-menu-btn");
    protected By cartIcon = By.cssSelector(".shopping_cart_link");
    protected By optionAllItems = By.id("inventory_sidebar_link");
    protected By optionAbout = By.id("about_sidebar_link");
    protected By optionLogout = By.id("logout_sidebar_link");
    protected By optionResetApp = By.id("reset_sidebar_link");

    public BasePageObjects() {
        driver = DriverProvider.Driver();
    }

    public void Wait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public WebDriverWait SmartWait(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait;
    }

    public WebElement GetElement(By elementLocator){
        return driver.findElement(elementLocator);
    }

    public void TypeText(By elementLocator, String text){
        WebElement element = GetElement(elementLocator);
        Assert.assertTrue(element.isDisplayed());
        element.clear();
        element.sendKeys(text);
    }

    public void CLickElement(By elementLocator){
        SmartWait(5).until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        WebElement element = GetElement(elementLocator);
        Assert.assertTrue(element.isDisplayed());
        SmartWait(3).until(ExpectedConditions.elementToBeClickable(elementLocator));
        element.click();
    }

    public void ClickMenuBar() {
        CLickElement(menuBar);
    }

    public void AssertTrue(boolean validation){
        Assert.assertTrue(validation, "Expected True but returned False");
    }

    public void AssertFalse(boolean validation){
        Assert.assertFalse(validation, "Expected False but returned True");
    }

    public <T> void AssertEquals(T element1, T element2) {
        Assert.assertEquals(element1, element2, "Expected elements to be equal, but they are different.");
    }

    public <T> void AssertNotEquals(T element1, T element2) {
        Assert.assertNotEquals(element1, element2, "Expected elements to be equal, but they are different.");
    }


    public String GetURL(){
        return driver.getCurrentUrl();
    }

    public void SelectOptionMenuBar(String option) {
        switch (option) {
            case "All Items":
                CLickElement(optionAllItems);
                AssertEquals(GetURL(), Constants.INVENTORY_URL);
                break;
            case "About":
                CLickElement(optionAbout);
                AssertEquals(GetURL(), Constants.SAUCE_LABS_URL);
                break;
            case "Logout":
                CLickElement(optionLogout);
                //AssertEquals(GetURL(), Constants.SAUCE_LABS_DEMO_URL);
                break;
            case "Reset App State":
                CLickElement(optionResetApp);
                System.out.println("Reset App State is not working");
                break;
            default:
                System.out.println("The option Entered is not valid");
                break;
        }
    }
}

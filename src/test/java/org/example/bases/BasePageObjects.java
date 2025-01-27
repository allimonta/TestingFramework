package org.example.bases;
import org.example.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    public void ClickMenuBar() {
        WebElement menuBarButton = driver.findElement(menuBar);
        Assert.assertTrue(menuBarButton.isDisplayed());
        menuBarButton.click();
    }

    public void SelectOptionMenuBar(String option) {
        switch (option) {
            case "All Items":
                WebElement allItemsLink = driver.findElement(optionAllItems);
                allItemsLink.click();
                Assert.assertEquals(driver.getCurrentUrl(), Constants.INVENTORY_URL);
                break;
            case "About":
                WebElement about = driver.findElement(optionAbout);
                about.click();
                Assert.assertEquals(driver.getCurrentUrl(), Constants.SAUCE_LABS_URL);
                break;
            case "Logout":
                WebElement logout = SmartWait(5).until(ExpectedConditions.elementToBeClickable(optionLogout));
                logout.click();
                Assert.assertEquals(driver.getCurrentUrl(), Constants.SAUCE_LABS_DEMO_URL);
                break;
            case "Reset App State":
                WebElement resetApp = driver.findElement(optionResetApp);
                resetApp.click();
                System.out.println("Reset App State is not working");
                break;
            default:
                System.out.println("The option Entered is not valid");
                break;
        }
    }
}

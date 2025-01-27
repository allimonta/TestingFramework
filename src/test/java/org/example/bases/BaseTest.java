package org.example.bases;
import org.example.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void Initialize()
    {
        driver = DriverProvider.Driver();
        driver.get(Constants.HOME_URL);
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, Constants.SAUCE_LABS_BANNER_TITLE);
    }

    @AfterMethod
    public void CloseBrowser()
    {
       DriverProvider.DestroyDriver();
    }
}

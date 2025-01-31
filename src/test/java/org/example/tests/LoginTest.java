package org.example.tests;
import org.example.bases.BaseTest;
import org.example.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.pages.LoginPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Test
    public void LoginWrongPassword() {
        loginPage = new LoginPage();
        loginPage.Login(Constants.INVALID_USERNAME, Constants.INVALID_PASSWORD);
        loginPage.verifyErrorMessage(Constants.ERROR_USERNAME_AND_PASSWORD_MSG);
    }

    @Test
    public void LoginEmptyPassword() {
        loginPage = new LoginPage();
        loginPage.Login(Constants.EMPTY_TXT, Constants.EMPTY_TXT);
        loginPage.verifyErrorMessage(Constants.ERROR_USERNAME_REQUIRED_MSG);
    }

    @Test
    public void CompleteLogin() {
        loginPage = new LoginPage();
        loginPage.Login(Constants.USERNAME, Constants.PASSWORD);
        Assert.assertEquals(driver.getCurrentUrl(), Constants.INVENTORY_URL);
    }

    @Test
    public void Logout(){
        loginPage = new LoginPage();
        loginPage.Login(Constants.USERNAME, Constants.PASSWORD);
        loginPage.ClickMenuBar();
        loginPage.SelectOptionMenuBar(Constants.LOGOUT_TXT);
        loginPage.LoginScreenIsCorrectlyDisplayed();
    }
}

package org.example.pages;
import org.example.bases.BasePageObjects;
import org.example.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePageObjects {
    private By usernameInp = By.id("user-name");
    private By passwordInp = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMessageTxt = By.cssSelector("[data-test='error']");

    public LoginPage(){
        super();
    }

    public void enterUsername(String user) {
        WebElement username = driver.findElement(usernameInp);
        username.clear();
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        WebElement password = driver.findElement(passwordInp);
        password.clear();
        password.sendKeys(pass);
    }

    public void clickLogin() {
        WebElement loginButton = driver.findElement(loginBtn);
        loginButton.click();
    }

    public void verifyErrorMessage(String message) {
        WebElement errorMessage = driver.findElement(errorMessageTxt);
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), message);
    }

    public void LoginSuccessful(){
        enterUsername(Constants.USERNAME);
        enterPassword(Constants.PASSWORD);
        clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.INVENTORY_URL);
    }

    public void LoginScreenIsCorrectlyDisplayed(){
        Assert.assertTrue(driver.findElement(usernameInp).isDisplayed(), "Username input is not displayed in Login screen");
        Assert.assertTrue(driver.findElement(passwordInp).isDisplayed(), "Password input is not displayed in Login screen");
        Assert.assertTrue(driver.findElement(loginBtn).isDisplayed(), "Login button input is not displayed in Login screen");
    }
}

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

    public void verifyErrorMessage(String message) {
        WebElement errorMessage = GetElement(errorMessageTxt);
        AssertTrue(errorMessage.isDisplayed());
        AssertEquals(errorMessage.getText(), message);
    }

    public void Login(String username, String password){
        TypeText(usernameInp, username);
        TypeText(passwordInp, password);
        CLickElement(loginBtn);
    }

    public void LoginScreenIsCorrectlyDisplayed(){
        AssertTrue(GetElement(usernameInp).isDisplayed());
        AssertTrue(GetElement(passwordInp).isDisplayed());
        AssertTrue(GetElement(loginBtn).isDisplayed());
    }
}

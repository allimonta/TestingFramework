package org.example.tests;

import org.example.bases.BaseTest;
import org.example.pages.*;
import org.example.utils.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {
    Inventory inventoryPage;
    LoginPage loginPage;
    CartPage cart;
    Checkout checkout;
    CheckoutOverview overview;
    CheckoutComplete complete;

    public CheckoutTests() {
        super();
    }

    @BeforeMethod
    public void GoToCheckout(){
        loginPage = new LoginPage();
        inventoryPage = new Inventory();
        cart = new CartPage();
        checkout = new Checkout();
        overview = new CheckoutOverview();
        complete = new CheckoutComplete();
        loginPage.Login(Constants.USERNAME, Constants.PASSWORD);
        inventoryPage.addProduct();
        inventoryPage.GoToCart();
        cart.GoToCheckout();
    }

    @Test
    public void ValidatingFieldsInCheckoutScreenShouldNotBeEmpty(){
        checkout.CheckoutScreenIsComplete();
        checkout.ClickContinue();
        checkout.ErrorMessageDisplayed();
        checkout.FieldsInErrorValidation();
    }

    @Test
    public void ToTalAmountInOverviewScreenIsCorrect(){
        checkout.CheckoutScreenIsComplete();
        checkout.EnterCheckoutValidInformation();
        checkout.ClickContinue();
        checkout.AssertEquals(checkout.GetURL(), Constants.CHECKOUT_STEP_2_URL);
        overview.CheckoutOverviewScreenIsComplete();
        overview.ComparingSumOfProductsAndItemsTotalLabel();
    }

    @Test
    public void VerifyCheckoutOrderCanBeCompleted(){
        checkout.CheckoutScreenIsComplete();
        checkout.EnterCheckoutValidInformation();
        checkout.ClickContinue();
        overview.CheckoutOverviewScreenIsComplete();
        overview.GoToComplete();
        complete.CompleteScreenIsCorrectlyDisplayed();
    }
}

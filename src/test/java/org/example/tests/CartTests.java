package org.example.tests;
import org.example.bases.BaseTest;
import org.example.pages.CartPage;
import org.example.pages.Inventory;
import org.example.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    Inventory inventoryPage;
    LoginPage loginPage;
    CartPage cart;

    public CartTests() {
        super();
    }

    @BeforeMethod
    public void GoToCart() {
        loginPage = new LoginPage();
        loginPage.LoginSuccessful();
        inventoryPage = new Inventory();
        cart = new CartPage();
    }

    @Test
    public void RemovingProductsFromCart() {
        inventoryPage.addProduct();
        inventoryPage.GoToCart();
        cart.CartScreenIsCompleted();
        cart.DeleteProduct();
    }
}

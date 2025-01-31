package org.example.tests;
import org.example.bases.BaseTest;
import org.example.pages.Product;
import org.example.utils.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.example.pages.Inventory;
import org.example.pages.LoginPage;

public class InventoryTests extends BaseTest {
    Inventory inventoryPage;
    LoginPage loginPage;
    Product product;

    @BeforeMethod
    public void OpeningWeb() {
        loginPage = new LoginPage();
        loginPage.Login(Constants.USERNAME, Constants.PASSWORD);
        inventoryPage = new Inventory();
        product = new Product();
    }

    @Test
    public void AddProductToCart() {
        inventoryPage.addProduct();
    }

    @Test
    public void RemoveProductFromCart() {
        inventoryPage.addProduct();
        inventoryPage.Wait(3);
        inventoryPage.removeProduct();
    }

    @Test
    public void SortProductsByNameAscendant() {
        inventoryPage.SortByName(Constants.ASC_NAME);
    }

    @Test
    public void SortProductsByNameDescendant() {
        inventoryPage.SortByName(Constants.DESC_NAME);
    }

    @Test
    public void SortProductsByPriceAscendant() {
        inventoryPage.SortByName(Constants.ASC_PRICE);
    }

    @Test
    public void SortProductsByPriceDescendant() {
        inventoryPage.SortByName(Constants.DESC_PRICE);
    }

    @Test
    public void ImageLinkRedirectsToProductDetails(){
        inventoryPage.GoToProductDetails(Constants.ZERO, "Image");
        product.ProductDetailsScreenCompleteness();
        product.BackButtonTextValidation();
        product.ActionButtonTextValidation();
    }

    @Test
    public void TitleLinkRedirectsToProductDetails(){
        inventoryPage.GoToProductDetails(Constants.ZERO, "Title");
        product.ProductDetailsScreenCompleteness();
        product.BackButtonTextValidation();
        product.ActionButtonTextValidation();
    }
}
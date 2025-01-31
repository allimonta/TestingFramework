package org.example.pages;
import java.time.Duration;
import java.util.List;
import org.example.bases.BasePageObjects;
import org.example.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Inventory extends BasePageObjects {
    private By removeButtonList = By.cssSelector("[name*=remove-sauce-labs]");
    private By addButtonList = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By filterButton = By.cssSelector(".product_sort_container");
    private By cartIconButton = By.id("shopping_cart_container");
    private By menuListButton = By.id(".bm-burger-button");
    private By cartProductCounter = By.cssSelector("[data-test='shopping-cart-badge']");
    private By filterSlected = By.cssSelector("[data-test='active-option']");
    private By productTitle = By.cssSelector("[data-test='inventory-item-name']");
    private By productImage = By.cssSelector(".inventory_item img");

    public Inventory() {
        super();
    }

    public void addProduct() {
        List<WebElement> productList = driver.findElements(addButtonList);
        WebElement productToAdd = productList.get(Constants.ZERO);
        productToAdd.click();
        WebElement productsAddedOnCart = GetElement(cartProductCounter);
        AssertEquals(productsAddedOnCart.getText(), "1");
    }

    public void removeProduct() {
        WebElement productToRemove = GetElement(removeButtonList);
        productToRemove.click();
    }

    public void SelectProductByValue(String value){
        Select selectFilter = new Select(GetElement(filterButton));
        selectFilter.selectByValue(value);
    }

    public void SortByName(String sortCriteria){
        if (sortCriteria == Constants.ASC_NAME){
            SelectProductByValue(sortCriteria);
            AssertEquals(GetElement(filterSlected).getText(), Constants.SORTING_NAME_ASC_TXT);
        } else if (sortCriteria == Constants.DESC_NAME) {
            SelectProductByValue(sortCriteria);
            AssertEquals(GetElement(filterSlected).getText(), Constants.SORTING_NAME_DESC_TXT);
        } else {
            System.out.println("Incorrect sort criteria you should try using az or za");
        }
    }

    public void SortByPrice(String sortCriteria){
        if (sortCriteria == Constants.ASC_PRICE){
            SelectProductByValue(sortCriteria);
            AssertEquals(GetElement(filterSlected).getText(), Constants.SORTING_PRICE_LOHI_TXT);
        } else if (sortCriteria == Constants.DESC_PRICE) {
            SelectProductByValue(sortCriteria);
            AssertEquals(GetElement(filterSlected).getText(), Constants.SORTING_PRICE_HILO_TXT);
        } else {
            System.out.println("Incorrect sort criteria you should try using (lohi) or (hilo)");
        }
    }

    public void GoToProductDetails(int index, String link){
        if (link == "Image"){
            List<WebElement> listOfProducts = driver.findElements(productImage);
            SmartWait(5).until(ExpectedConditions.visibilityOfAllElements(listOfProducts));
            WebElement productSelected = listOfProducts.get(index);
            SmartWait(5).until(ExpectedConditions.elementToBeClickable(productSelected));
            productSelected.click();
        }
        else {
            List<WebElement> listOfProducts = driver.findElements(productTitle);
            SmartWait(5).until(ExpectedConditions.visibilityOfAllElements(listOfProducts));
            WebElement productSelected = listOfProducts.get(index);
            productSelected.click();
        }
    }

    public void GoToCart(){
        CLickElement(cartIconButton);
        AssertEquals(driver.getCurrentUrl(), Constants.CART_URL);
    }
}

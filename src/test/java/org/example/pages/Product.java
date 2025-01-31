package org.example.pages;

import org.example.bases.BasePageObjects;
import org.example.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Product extends BasePageObjects {
    private By productTitle = By.cssSelector("[data-test='inventory-item-desc']");
    private By productImage = By.cssSelector("[data-test='item-sauce-labs-backpack-img']");
    private By productDescription = By.cssSelector("[data-test='inventory-item-desc']");
    private By productPrice = By.cssSelector(".inventory_details_price");
    private By productActionButton = By.cssSelector("[class*='btn_small btn_inventory']");
    private By productBackButton = By.id("back-to-products");

    public Product() {
        super();
    }

    public void ProductDetailsScreenCompleteness(){
        WebElement title = GetElement(productTitle);
        WebElement image = GetElement(productImage);
        WebElement description = GetElement(productDescription);
        WebElement price = GetElement(productPrice);
        AssertTrue(title.isDisplayed());
        AssertTrue(image.isDisplayed());
        AssertTrue(description.isDisplayed());
        AssertTrue(price.isDisplayed());
    }

    public void BackButtonTextValidation(){
        WebElement backBtn = GetElement(productBackButton);
        AssertTrue(backBtn.isDisplayed());
        AssertEquals(backBtn.getText(), Constants.BACK_TO_PRODUCTS_BUTTON);
    }

    public void ActionButtonTextValidation(){
        WebElement actionButton = GetElement(productActionButton);
        AssertTrue(actionButton.isDisplayed());
        if (actionButton.getText().equals(Constants.ADD_TO_CART_BUTTON)){
            AssertEquals(actionButton.getText(), Constants.ADD_TO_CART_BUTTON);
        }else {
            AssertEquals(actionButton.getText(), Constants.REMOVE_TXT);
        }
    }
}

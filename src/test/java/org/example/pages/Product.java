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
        WebElement title = driver.findElement(productTitle);
        WebElement image = driver.findElement(productImage);
        WebElement description = driver.findElement(productDescription);
        WebElement price = driver.findElement(productPrice);
        Assert.assertTrue(title.isDisplayed());
        Assert.assertTrue(image.isDisplayed());
        Assert.assertTrue(description.isDisplayed());
        Assert.assertTrue(price.isDisplayed());
    }

    public void BackButtonTextValidation(){
        WebElement backBtn = driver.findElement(productBackButton);
        Assert.assertTrue(backBtn.isDisplayed());
        Assert.assertEquals(backBtn.getText(), Constants.BACK_TO_PRODUCTS_BUTTON);
    }

    public void ActionButtonTextValidation(){
        WebElement actionButton = driver.findElement(productActionButton);
        Assert.assertTrue(actionButton.isDisplayed());
        if (actionButton.getText().equals(Constants.ADD_TO_CART_BUTTON)){
            Assert.assertEquals(actionButton.getText(), Constants.ADD_TO_CART_BUTTON);
        }else {
            Assert.assertEquals(actionButton.getText(), Constants.REMOVE_TXT);
        }
    }
}

package org.example.pages;
import org.example.bases.BasePageObjects;
import org.example.utils.Constants;
import org.example.utils.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutOverview extends BasePageObjects {
    private By paymentInformationLabel = By.cssSelector("[data-test='payment-info-label']");
    private By paymentInformationValue = By.cssSelector("[data-test='payment-info-value']");
    private By shippingInformationLabel = By.cssSelector("[data-test='shipping-info-label']");
    private By shippingInformationValue = By.cssSelector("[data-test='shipping-info-value']");
    private By priceTotalLabel = By.cssSelector("[data-test='total-info-label']");
    private By itemTotalValue = By.cssSelector("[data-test='subtotal-label']");
    private By taxValue = By.cssSelector("[data-test='tax-label']");
    private By totalvalue = By.cssSelector("[data-test='total-label']");
    private By cancelButton = By.id("cancel");
    private By finishButton = By.id("finish");
    private By productsPrice = By.cssSelector(".inventory_item_price");


    public CheckoutOverview(){
        super();
    }

    public void ClickFinish(){
        WebElement finishBtn = driver.findElement(finishButton);
        Assert.assertTrue(finishBtn.isDisplayed());
        finishBtn.click();
    }

    public void CheckoutOverviewScreenIsComplete(){
        Assert.assertTrue(driver.findElement(screenTitle).isDisplayed(), "Checkout Overview title is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(paymentInformationLabel).isDisplayed(), "Payment Information label is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(paymentInformationValue).isDisplayed(), "Payment Information value is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(shippingInformationLabel).isDisplayed(), "Shipping Information label is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(shippingInformationValue).isDisplayed(), "Shipping Information value is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(priceTotalLabel).isDisplayed(), "Price Total label is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(itemTotalValue).isDisplayed(), "Item Total label is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(taxValue).isDisplayed(), "Tax label is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(totalvalue).isDisplayed(), "Total label is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(cancelButton).isDisplayed(), "Cancel button is not displayed in Checkout screen");
        Assert.assertTrue(driver.findElement(finishButton).isDisplayed(), "Finish button is not displayed in Checkout screen");
        Assert.assertEquals(driver.findElement(screenTitle).getText(), Constants.CHECKOUT_OVERVIEW_TITLE_TXT);
        Assert.assertEquals(driver.findElement(paymentInformationLabel).getText(), Constants.PAYMENT_INFORMATION_TXT);
        Assert.assertEquals(driver.findElement(paymentInformationValue).getText(), Constants.PAYMENT_INFORMATION_VALUE_TXT);
        Assert.assertEquals(driver.findElement(shippingInformationLabel).getText(), Constants.SHIPPING_INFORMATION_TXT);
        Assert.assertEquals(driver.findElement(shippingInformationValue).getText(), Constants.SHIPPING_INFORMATION_VALUE_TXT);
        Assert.assertEquals(driver.findElement(priceTotalLabel).getText(), Constants.TOTAL_PRICE_TXT);
        Assert.assertTrue(driver.findElement(itemTotalValue).getText().contains(Constants.ITEM_TOTAL_TXT));
        Assert.assertTrue(driver.findElement(taxValue).getText().contains(Constants.TAX_TXT));
        Assert.assertTrue(driver.findElement(totalvalue).getText().contains(Constants.TOTAL_TXT));
        Assert.assertEquals(driver.findElement(cancelButton).getText(), Constants.CANCEL_TXT);
        Assert.assertEquals(driver.findElement(finishButton).getText(), Constants.FINISH_BUTTON_TXT);
    }

    public double calculatingTotalPrice() {
        double totalPrice = 0;
        WebElement product = driver.findElement(productsPrice);
        String priceText = product.getText();
        double price = Functions.extractNumber(priceText);
        totalPrice += price;
        totalPrice = Math.round(totalPrice * 100.0) / 100.0;
        return totalPrice;
    }

    public void ComparingSumOfProductsAndItemsTotalLabel(){
        double productsSumTotalPrice = calculatingTotalPrice();
        WebElement itemTotal = driver.findElement(itemTotalValue);
        double totalClean = Functions.extractNumber(itemTotal.getText());
        Assert.assertEquals(productsSumTotalPrice, totalClean);
    }

    public void GoToComplete(){
        WebElement finish = driver.findElement(finishButton);
        Assert.assertTrue(finish.isDisplayed());
        finish.click();
        Assert.assertEquals(driver.getCurrentUrl(), Constants.CHECKOUT_COMPLETE_URL);
    }
}

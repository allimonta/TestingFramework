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

    public void CheckoutOverviewScreenIsComplete(){
        AssertTrue(GetElement(screenTitle).isDisplayed());
        AssertTrue(GetElement(paymentInformationLabel).isDisplayed());
        AssertTrue(GetElement(paymentInformationValue).isDisplayed());
        AssertTrue(GetElement(shippingInformationLabel).isDisplayed());
        AssertTrue(GetElement(shippingInformationValue).isDisplayed());
        AssertTrue(GetElement(priceTotalLabel).isDisplayed());
        AssertTrue(GetElement(itemTotalValue).isDisplayed());
        AssertTrue(GetElement(taxValue).isDisplayed());
        AssertTrue(GetElement(totalvalue).isDisplayed());
        AssertTrue(GetElement(cancelButton).isDisplayed());
        AssertTrue(GetElement(finishButton).isDisplayed());
        AssertEquals(GetElement(screenTitle).getText(), Constants.CHECKOUT_OVERVIEW_TITLE_TXT);
        AssertEquals(GetElement(paymentInformationLabel).getText(), Constants.PAYMENT_INFORMATION_TXT);
        AssertEquals(GetElement(paymentInformationValue).getText(), Constants.PAYMENT_INFORMATION_VALUE_TXT);
        AssertEquals(GetElement(shippingInformationLabel).getText(), Constants.SHIPPING_INFORMATION_TXT);
        AssertEquals(GetElement(shippingInformationValue).getText(), Constants.SHIPPING_INFORMATION_VALUE_TXT);
        AssertEquals(GetElement(priceTotalLabel).getText(), Constants.TOTAL_PRICE_TXT);
        AssertTrue(GetElement(itemTotalValue).getText().contains(Constants.ITEM_TOTAL_TXT));
        AssertTrue(GetElement(taxValue).getText().contains(Constants.TAX_TXT));
        AssertTrue(GetElement(totalvalue).getText().contains(Constants.TOTAL_TXT));
        AssertEquals(GetElement(cancelButton).getText(), Constants.CANCEL_TXT);
        AssertEquals(GetElement(finishButton).getText(), Constants.FINISH_BUTTON_TXT);
    }

    public double calculatingTotalPrice() {
        double totalPrice = 0;
        WebElement product = GetElement(productsPrice);
        String priceText = product.getText();
        double price = Functions.extractNumber(priceText);
        totalPrice += price;
        return Functions.round(totalPrice, 2);
    }

    public void ComparingSumOfProductsAndItemsTotalLabel(){
        double productsSumTotalPrice = calculatingTotalPrice();
        WebElement itemTotal = GetElement(itemTotalValue);
        double totalClean = Functions.extractNumber(itemTotal.getText());
        AssertEquals(productsSumTotalPrice, totalClean);
    }

    public void GoToComplete(){
        CLickElement(finishButton);
        AssertEquals(GetURL(), Constants.CHECKOUT_COMPLETE_URL);
    }
}

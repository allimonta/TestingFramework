package org.example.utils;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Functions {

    public static int convertToNumber(String numberString){
        return Integer.parseInt(numberString);
    }

    public static double extractNumber(String text) {
        String number = text.replaceAll("[^\\d.]", "").trim();
        return Double.parseDouble(number);
    }

}

package org.example.utils;

public class Functions {

    public static double extractNumber(String text) {
        String number = text.replaceAll("[^\\d.]", "").trim();
        return Double.parseDouble(number);
    }

    public static double round(double number, int decimals) {
        if (decimals < 0) throw new IllegalArgumentException("Decimals cannot be negative");
        double scale = Math.pow(10, decimals);
        return Math.round(number * scale) / scale;
    }
}
package org.example.bases;
import org.example.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverProvider {
    private static WebDriver driver;

    public static WebDriver Driver() {
        if (driver == null) {
            InitDriver();
        }
        return driver;
    }

    public static void InitDriver() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_URL);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void DestroyDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                throw new RuntimeException("Error closing the driver: " + e.getMessage(), e);
            } finally {
                driver = null;
            }
        }
    }
}

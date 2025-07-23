package com.tractorjunction.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tractorjunction.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ConfigReader configReader = new ConfigReader();

    public static WebDriver createDriver(boolean headless) {
        WebDriver driver = null;
        ChromeOptions options = new ChromeOptions();

        // Read browser name from system property or use default
        String browser = System.getProperty("browser");
        if (browser == null || browser.isEmpty()) {
            browser = "chrome"; // default browser
        }

        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Unsupported browser: " + browser + ". Falling back to Chrome.");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
        }

        return driver;
    }
}

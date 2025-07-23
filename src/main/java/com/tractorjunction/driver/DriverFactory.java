package com.tractorjunction.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static WebDriver createDriver(String browser, boolean headless, String gridUrl) {
        WebDriver driver;

        if (browser == null || browser.isEmpty()) {
            browser = "chrome";
        }

        try {
            switch (browser.toLowerCase()) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (headless) {
                        chromeOptions.addArguments("--headless=new", "--window-size=1920,1080", "--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
                    }
                    chromeOptions.setAcceptInsecureCerts(true);
                    driver = getDriver(chromeOptions, gridUrl);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (headless) {
                        firefoxOptions.addArguments("--headless");
                    }
                    firefoxOptions.setAcceptInsecureCerts(true);
                    driver = getDriver(firefoxOptions, gridUrl);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (headless) {
                        edgeOptions.addArguments("--headless=new", "--window-size=1920,1080");
                    }
                    edgeOptions.setAcceptInsecureCerts(true);
                    driver = getDriver(edgeOptions, gridUrl);
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize browser: " + browser);
        }

        return driver;
    }

    private static WebDriver getDriver(Object options, String gridUrl) throws MalformedURLException {
        if (gridUrl != null && !gridUrl.isEmpty()) {
            System.out.println("[DriverFactory] Running on Selenium Grid: " + gridUrl);
            if (options instanceof ChromeOptions) {
                return new RemoteWebDriver(new URL(gridUrl), (ChromeOptions) options);
            } else if (options instanceof FirefoxOptions) {
                return new RemoteWebDriver(new URL(gridUrl), (FirefoxOptions) options);
            } else if (options instanceof EdgeOptions) {
                return new RemoteWebDriver(new URL(gridUrl), (EdgeOptions) options);
            } else {
                throw new IllegalArgumentException("Unsupported options type for remote execution.");
            }
        } else {
            System.out.println("[DriverFactory] Running locally.");
            if (options instanceof ChromeOptions) {
                return new org.openqa.selenium.chrome.ChromeDriver((ChromeOptions) options);
            } else if (options instanceof FirefoxOptions) {
                return new org.openqa.selenium.firefox.FirefoxDriver((FirefoxOptions) options);
            } else if (options instanceof EdgeOptions) {
                return new EdgeDriver((EdgeOptions) options);
            } else {
                throw new IllegalArgumentException("Unsupported options type for local execution.");
            }
        }
    }
}

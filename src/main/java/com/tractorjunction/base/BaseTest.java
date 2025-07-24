package com.tractorjunction.base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.tractorjunction.driver.DriverFactory;
import com.tractorjunction.driver.DriverManager;
import com.tractorjunction.utils.ConfigReader;

public class BaseTest {

    protected ConfigReader config;
    protected String baseUrl;

    @BeforeMethod
    @Parameters({"browser", "headless", "gridUrl", "environment"})
    public void setUp(
            @Optional("chrome") String browser,
            @Optional("false") String headless,
            @Optional("") String gridUrl,
            @Optional("prod") String environment) {

        boolean runHeadless = Boolean.parseBoolean(headless);

        // Load env-specific config
        config = new ConfigReader(environment);
        baseUrl = config.getProperty("baseUrl");

        WebDriver driver = DriverFactory.createDriver(browser, runHeadless, gridUrl);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        DriverManager.setDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}

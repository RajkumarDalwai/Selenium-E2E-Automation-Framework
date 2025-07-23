package com.tractorjunction.base;

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
            @Optional("test") String environment) {

        boolean runHeadless = Boolean.parseBoolean(headless);

        // Load env-specific config
        config = new ConfigReader(environment);
        baseUrl = config.getProperty("baseUrl");

        WebDriver driver = DriverFactory.createDriver(browser, runHeadless, gridUrl);
        driver.manage().window().maximize();
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

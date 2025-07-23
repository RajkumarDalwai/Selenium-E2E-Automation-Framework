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
    protected boolean runHeadless;

    @BeforeMethod
    @Parameters({"headless"})
    public void setUp(@Optional("false") String headless) {
        String browserFromProperty = System.getProperty("browser");

        config = new ConfigReader();
        baseUrl = config.getProperty("baseUrl");
        runHeadless = Boolean.parseBoolean(headless);

        WebDriver driver = DriverFactory.createDriver(runHeadless);
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

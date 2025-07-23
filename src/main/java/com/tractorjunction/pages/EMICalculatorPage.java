package com.tractorjunction.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EMICalculatorPage {
    WebDriver driver;

    public EMICalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Brand selector dropdown
    @FindBy(css = "#brandselect")
    public WebElement brandSelect;

    // First brand in modal
    @FindBy(xpath = "(//span[contains(@class, 'emi-listing-item') and contains(@class, 'brand')])[1]")
    public WebElement firstBrand;

    // First model under selected brand
    @FindBy(xpath = "(//li[@class='brand-wraaper tractorlisting'])[1]")
    public WebElement firstModel;

    // Calculate EMI button
    @FindBy(xpath = "//span[normalize-space()='Calculate EMI']")
    public WebElement calculateEMIButton;

    // Monthly EMI result
    @FindBy(css = ".total_emi")
    public WebElement monthlyEMI;

    // Loan Amount result
    @FindBy(css = "#loanAmount")
    public WebElement loanAmount;

    // Total Payable result
    @FindBy(css = "#totalPayable")
    public WebElement totalPayable;
}

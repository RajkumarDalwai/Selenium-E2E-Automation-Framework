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

    @FindBy(css = "#brandselect")
    public WebElement brandSelect;

    @FindBy(xpath = "(//span[contains(@class, 'emi-listing-item') and contains(@class, 'brand')])[1]")
    public WebElement firstBrand;

    @FindBy(xpath = "(//li[@class='brand-wraaper tractorlisting'])[1]")
    public WebElement firstModel;

    @FindBy(xpath = "//span[normalize-space()='Calculate EMI']")
    public WebElement calculateEMIButton;

    @FindBy(css = ".total_emi")
    public WebElement monthlyEMI;

    @FindBy(css = "#loanAmount")
    public WebElement loanAmount;

    @FindBy(css = "#totalPayable")
    public WebElement totalPayable;
    
    @FindBy(css = "#downPaymentValue")
    public WebElement downPayment;
}
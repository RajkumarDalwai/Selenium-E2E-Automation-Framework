package com.tractorjunction.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;

public class UsedTractorListingPage {

    WebDriver driver;

    public UsedTractorListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 📌 Price filter dropdown
    @FindBy(xpath = "//span[contains(text(),'Price')]")
    public WebElement priceFilterDropdown;

    // 📌 0 Lakh - 2 Lakh option
    @FindBy(xpath = "//label[contains(text(),'0 Lakh - 2 Lakh')]")
    public WebElement priceOption_0to2Lakh;

    // 📌 2 Lakh - 3 Lakh option
    @FindBy(xpath = "//label[contains(text(),'2 Lakh - 3 Lakh')]")
    public WebElement priceOption_2to3Lakh;

    // 📌 Brand filter dropdown
    @FindBy(xpath = "//span[contains(text(),'Brand')]")
    public WebElement brandFilterDropdown;

    // 📌 Mahindra brand option
    @FindBy(xpath = "//label[contains(text(),'Mahindra')]")
    public WebElement brandOptionMahindra;

    // 📌 Model filter dropdown
    @FindBy(xpath = "//span[contains(text(),'Model')]")
    public WebElement modelFilterDropdown;

    // 📌 Mahindra 575 DI model
    @FindBy(xpath = "(//label//span[contains(text(),'575 DI')])[1]")
    public WebElement modelOption575DI;

    // 📌 Apply Filter button
    @FindBy(id = "apply_filter")
    public WebElement applyFilterButton;

    // 📌 Sort By dropdown
    @FindBy(xpath = "//input[@id='gCityMob']")
    public WebElement sortByDropdown;

    // 📌 Sort by Price Low to High option
    @FindBy(xpath = "//li[contains(text(),'Price - Low to High')]")
    public WebElement sortPriceLowToHigh;

    // 📌 Year filter dropdown
    @FindBy(xpath = "//span[contains(text(),'Year')]")
    public WebElement yearFilterDropdown;

    @FindBy(xpath = "//label[normalize-space()='2025']")
    public WebElement yearOption2025;

    // 📌 Year 2011 option
    @FindBy(xpath = "//label[normalize-space()='2011']")
    public WebElement yearOption2011;

    // ✅ Listing elements
    @FindBy(css = ".hotDeal-tractor-price")
    public List<WebElement> priceElements;

    @FindBy(css = "div.hotDeal-tractor-content p.used-product-name a.weblink")
    public List<WebElement> listingTitleLinks;

    @FindBy(xpath = "//span[contains(@class, 'oneline') and contains(text(),'Model')]")
    public List<WebElement> yearElements;

    // ✅ FILTER METHODS

    public void applyPriceFilter_0to2Lakh() {
        priceFilterDropdown.click();
        priceOption_0to2Lakh.click();
        applyFilterButton.click();
    }

    public void applyPriceFilter_2to3Lakh() {
        priceFilterDropdown.click();
        priceOption_2to3Lakh.click();
        applyFilterButton.click();
    }

    public void applyBrandModelFilter_Mahindra_575DI() {
        brandFilterDropdown.click();
        brandOptionMahindra.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(modelFilterDropdown)).click();

        try {
            WebElement modelOption = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("(//label//span[contains(text(),'575 DI')])[1]")));
            modelOption.click();
        } catch (TimeoutException e) {
            throw new NoSuchElementException("Model '575 DI' not found in loaded options.", e);
        }

        applyFilterButton.click();
    }

    public void applyBrandFilter_Mahindra() {
        brandFilterDropdown.click();
        brandOptionMahindra.click();
        applyFilterButton.click();
    }

    public void applyYearFilter_2025() {
        yearFilterDropdown.click();
        yearOption2025.click();
        applyFilterButton.click();
    }

    public void applyYearFilter_2011() {
        yearFilterDropdown.click();
        yearOption2011.click();
        applyFilterButton.click();
    }

    public void sortByPriceLowToHigh() {
        sortByDropdown.click();
        sortPriceLowToHigh.click();
    }

    // ✅ EXTRACTION METHODS

    public List<Integer> getAllPrices() {
        List<Integer> prices = new ArrayList<>();
        for (WebElement el : priceElements) {
            String fullText = el.getText();
            String usedPrice = fullText.split("\n")[0];
            usedPrice = usedPrice.replaceAll("[^0-9]", "");

            if (!usedPrice.isEmpty()) {
                prices.add(Integer.parseInt(usedPrice));
            }
        }
        return prices;
    }

    public List<String> getAllTitles() {
        List<String> titles = new ArrayList<>();
        for (WebElement el : listingTitleLinks) {
            titles.add(el.getText().trim());
        }
        return titles;
    }

    public List<String> getAllYears() {
        List<String> years = new ArrayList<>();
        for (WebElement el : yearElements) {
            years.add(el.getText().trim());
        }
        return years;
    }

    // ✅ VALIDATION

    public boolean arePricesSortedLowToHigh() {
        List<Integer> prices = getAllPrices();
        System.out.println("Captured Prices: " + prices);
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}

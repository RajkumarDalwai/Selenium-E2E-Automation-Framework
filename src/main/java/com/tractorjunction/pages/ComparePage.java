package com.tractorjunction.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ComparePage {

    WebDriver driver;

    public ComparePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ------------------------- Locators -------------------------

    // "Add Tractor" buttons
    @FindBy(xpath = "//p[text()='Add Tractor' and contains(@class, 'text-decoration-underline')]")
    public List<WebElement> addTractorButtons;

    // Brand cards in popup
    @FindBy(xpath = "//span[contains(@class, 'emi-listing-item') and contains(@class, 'brand')]")
    public List<WebElement> brandCards;

    // First model card
    @FindBy(xpath = "(//span[@class='popup-listing-brand model0'])[1]")
    public WebElement firstModelCard;

    // Compare button
    @FindBy(css = "a[title='Compare Tractors']")
    public WebElement compareButton;

    // Comparison result H1 heading
    @FindBy(tagName = "h1")
    public WebElement comparisonHeader;

    // "Other Information" tab on result page
    @FindBy(css = "div.tabNEW-block.result-tabs-container.pt-2 span[title='Other Information']")
    public WebElement otherInfoTab;

    // "Other Information" section to scroll to
    @FindBy(xpath = "//*[contains(text(),'Other Information') or contains(@id, 'OtherInformation')]")
    public WebElement otherInfoSection;

    // ------------------------- Actions -------------------------

    // Click nth "Add Tractor" slot (0-based)
    public void clickAddTractorSlot(int index) {
        if (index < addTractorButtons.size()) {
            addTractorButtons.get(index).click();
        } else {
            throw new RuntimeException("Add Tractor button at index " + index + " not found.");
        }
    }

    // Click brand by index (1-based for user clarity)
    public void clickBrandByIndex(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(brandCards));

        if (index - 1 < brandCards.size()) {
            brandCards.get(index - 1).click();
        } else {
            throw new RuntimeException("Brand card at index " + index + " not available.");
        }
    }

    // Get brand name by index (1-based)
    public String getBrandNameByIndex(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(brandCards));

        if (index - 1 < brandCards.size()) {
            return brandCards.get(index - 1).getText().trim();
        } else {
            throw new RuntimeException("Brand card at index " + index + " not available.");
        }
    }

    // Click first model and return its name
    public String clickFirstModelAndGetText() {
        String text = firstModelCard.getText().trim();
        firstModelCard.click();
        return text;
    }

    // Click on Compare button
    public void clickCompare() {
        compareButton.click();
    }

    // Get comparison heading (H1)
    public String getComparisonHeading() {
        return comparisonHeader.getText().trim();
    }
}

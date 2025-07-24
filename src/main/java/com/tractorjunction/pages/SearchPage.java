package com.tractorjunction.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By headingLocator = By.tagName("h1"); // Use By locator instead of caching WebElement
    private By noSuggestionsLocator = By.cssSelector("#messageBoxInner");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increased timeout
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "serachInt_fields")
    private WebElement searchField;
    
    @FindBy(id = "searchBox")
    private WebElement searchBox;

    public void enterSearchAndSubmit(String keywords) {
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.click(); // Activate the input
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBox.clear();
        searchBox.sendKeys(keywords);
        searchBox.sendKeys(Keys.ENTER);
        // Wait for page load after submission
        wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
    }

    public String getSearchHeadingText() {
        WebElement headingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(headingLocator));
        return headingElement.getText().trim();
    }

    public String getNoSuggestionMessage() {
        WebElement noSuggestionsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(noSuggestionsLocator));
        return noSuggestionsElement.getText().trim();
    }
}
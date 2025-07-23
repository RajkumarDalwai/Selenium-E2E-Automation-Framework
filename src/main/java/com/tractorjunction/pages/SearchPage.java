package com.tractorjunction.pages;

import java.time.Duration;

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

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "serachInt_fields")
    private WebElement searchField;
    
    @FindBy(id = "searchBox")
    private WebElement searchBox;

    @FindBy(tagName = "h1")
    private WebElement headingElement;

    @FindBy(css = "#messageBoxInner")
    private WebElement noSuggestionsSpan;

    public void enterSearchAndSubmit(String keywords) {
        searchField.click(); // activate the input
        searchBox.clear();
        searchBox.sendKeys(keywords);
        searchBox.sendKeys(Keys.ENTER);
    }

    public String getSearchHeadingText() {
        wait.until(ExpectedConditions.visibilityOf(headingElement));
        return headingElement.getText().trim();
    }

    public String getNoSuggestionMessage() {
        wait.until(ExpectedConditions.visibilityOf(noSuggestionsSpan));
        return noSuggestionsSpan.getText().trim();
    }
}

package com.tractorjunction.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LanguageSwitcherPage {

    private WebDriver driver;

    @FindBy(id = "lang-mobile-btn")
    private WebElement languageDropdownButton;

    @FindBy(className = "checkLang_hi")
    private WebElement hindiOption;

    @FindBy(css = "a[hreflang='te']")
    private WebElement teluguOption;

    @FindBy(linkText = "Tamil")
    private WebElement tamilOption;

    @FindBy(linkText = "Marathi")
    private WebElement marathiOption;

    public LanguageSwitcherPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void openLanguageDropdown() {
        languageDropdownButton.click();
    }

    public void selectHindi() {
        hindiOption.click();
    }

    public void selectTelugu() {
        teluguOption.click();
    }

    public void selectTamil() {
        tamilOption.click();
    }

    public void selectMarathi() {
        marathiOption.click();
    }
}

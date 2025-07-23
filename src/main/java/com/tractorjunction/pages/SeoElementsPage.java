package com.tractorjunction.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.stream.Collectors;

public class SeoElementsPage {

    WebDriver driver;

    public SeoElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    private WebElement h1;

    @FindBy(tagName = "h2")
    private List<WebElement> h2s;

    @FindBy(tagName = "h3")
    private List<WebElement> h3s;

    @FindBy(xpath = "//meta[@name='description']")
    private WebElement metaDescription;

    @FindBy(xpath = "//meta[@name='keywords']")
    private WebElement metaKeywords;

    @FindBy(css = "ul.breadcrumbs-main.mb-0 li")
    private List<WebElement> breadcrumbItems;

    public String getH1Text() {
        return h1.getText().trim();
    }

    public List<String> getH2Texts() {
        return h2s.stream().map(e -> e.getText().trim().replaceAll("\\s+", " ")).collect(Collectors.toList());
    }

    public List<String> getH3Texts() {
        return h3s.stream().map(e -> e.getText().trim().replaceAll("\\s+", " ")).collect(Collectors.toList());
    }

    public String getMetaTitle() {
        return driver.getTitle().trim();
    }

    public String getMetaDescription() {
        return metaDescription.getAttribute("content").trim();
    }

    public String getMetaKeywords() {
        return metaKeywords.getAttribute("content").trim();
    }

    public String getBreadcrumbText() {
        return breadcrumbItems.stream().map(e -> e.getText().trim()).collect(Collectors.joining(" > "));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

package com.tractorjunction.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LocationMasterPage {

    WebDriver driver;

    public LocationMasterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ====================
    // 🔹 Common Elements
    // ====================

    @FindBy(id = "states")
    public WebElement stateDropdown;

    @FindBy(css = "#states option")
    public List<WebElement> stateDropdownOptions;
    
    @FindBy(xpath = "(//select[@id='states'])[1]/option")
    public List<WebElement> imagestateDropdownOptions;
    
    @FindBy(css = "#statesid2 option")
    public List<WebElement> tyreDropdownOptions;

    @FindBy(css = "#statesflashPopupModal option")
    public List<WebElement> flashPopupStateOptions;

    @FindBy(css = ".cross")
    public WebElement popupCloseIcon;

    @FindBy(css = ".brand-listing-wrapper.subsidy-location p.oneline")
    public List<WebElement> subsidyStateWidgets;

    // ====================
    // 🔹 Page-Specific Elements
    // ====================

    // Home → Click 2nd New Tractor
    @FindBy(css = "#popularnew > .section-css-slider > :nth-child(2) .card_initiate")
    public WebElement secondNewTractorCard;

    // All Brands → Click 2nd Brand Tractor
    @FindBy(xpath = "(//span[contains(@class, 'card_initiate')])[1]")
    public WebElement secondBrandTractorCard;

    // Used Detail 
    @FindBy(xpath = "(//span[contains(@class, 'card_initiate')])[2]")
    public WebElement usedDetailCard;
    
    // Compare Page
    @FindBy(xpath = "(//span[text()='ధరను తనిఖీ చేయండి'])[1]")
    public WebElement compareCard;

    // Tyres Page
    @FindBy(css = ".new-equipment-card-anchor > .new-equipment-anchor")
    public WebElement firstTyreCard;

    // PDP → Image popup
    @FindBy(css = ":nth-child(1) > .setCurrentIndex > .imageNew-inner > .cursor")
    public WebElement firstImageGalleryThumb;
    
    // Listing Page → Click 1st Tractor
    @FindBy(css = ":nth-child(1) > .product-card-main > .product-card-anchor > .card_initiate")
    public WebElement firstTractorCard;

    @FindBy(css = "#modal-image-gallery-grid .checkBtn")
    public WebElement imageGalleryConfirmButton;

    // PDP → Flash popup open
    @FindBy(css = "div[class='modal-body'] span[title='ऑन रोड प्राइस']")
    public WebElement pdpFlashPopupTrigger;
    
    @FindBy(xpath = "(//span[@class='card_initiate ellipsis bg-blue-color boldfont text-center px-2 rounded text-capitalize transition cursor transition requestModal'][normalize-space()='Check Tractor Price'])[1]")
    public WebElement emiCalcTractorCard;

    // ====================
    // 🔹 Actions
    // ====================

    public void closePopupIfPresent() {
        try {
            if (popupCloseIcon.isDisplayed()) {
                popupCloseIcon.click();
            }
        } catch (Exception ignored) {}
    }

    public int getDropdownOptionCount(List<WebElement> options) {
        return options.size() - 1; // Exclude first (placeholder) option
    }
}

package com.tractorjunction.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object for all Lead Form types:
 * - New Tractor Lead Forms (7 Placements)
 * - Sell Used Tractor
 * - Sell Used Implements
 * - Sell Used Harvester
 */
public class LeadFormPage {

    private WebDriver driver;

    public LeadFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // -------------------- New Tractor Lead Form CTAs --------------------

    @FindBy(css = "#popularnew > .section-css-slider > :nth-child(2) .card_initiate")
    public WebElement ctpHpTractorsIn2024;

    @FindBy(css = "#budget3 > .section-css-slider > :nth-child(2) .card_initiate")
    public WebElement ctpHpTractorsByBudget;

    @FindBy(css = ".container-mid > .section-css-slider > :nth-child(2) .card_initiate")
    public WebElement ctpHpMiniTractors;

    @FindBy(css = ":nth-child(6) > .product-card-main > .product-card-anchor > .card_initiate")
    public WebElement ctpLpNewTractors1;

    @FindBy(css = ":nth-child(6) > .product-card-main > .product-card-anchor > .card_initiate")
    public WebElement ctpLpNewTractors2;

    @FindBy(css = ".cta-wrapper > .submitBtnNew")
    public WebElement ctpPdpNtHeroSection;

    @FindBy(css = ":nth-child(1) > .product-card-main > .product-card-anchor > .card_initiate")
    public WebElement ctpPdpNtSimilarSection;
    
    @FindBy(xpath = "(//span[@class='card_initiate ellipsis bg-blue-color boldfont text-center px-2 rounded text-capitalize transition cursor transition requestModal'][normalize-space()='Check Tractor Price'])[1]")
    public WebElement ctpEMIPage;

 // -------------------- New Tractor Lead Form Fields --------------------

    @FindBy(css = "#GetOnRoadPrice > .modal-dialog > .modal-content > .customModal-body > #tractor_submit_form > .row > :nth-child(1) > .form-control")
    public WebElement ctpNameInput;

    @FindBy(css = ".modal.show > .modal-dialog > .modal-content > .customModal-body > #tractor_submit_form > .row > :nth-child(2) > .form-control")
    public WebElement ctpMobileInput;

    @FindBy(id = "states")
    public WebElement ctpStateDropdown;

    @FindBy(id = "gorp_form_dist_id")
    public WebElement ctpDistrictDropdown;

    @FindBy(id = "gorp_form_village_id")
    public WebElement ctpTehsilDropdown;

    @FindBy(css = "div#GetOnRoadPrice button.tractor_submit.fillBtn.w-100.text-white.boldfont.flashpopup.CTP-card")
    public WebElement ctpMainCTAButton;

    @FindBy(css = "#recom-form > .modal-footer > .btn")
    public WebElement ctaReceiveSimilarOffers;

    @FindBy(css = ".ssss")
    public WebElement finalValidationToast;
    
    // -------------------- Sell Used Tractor --------------------

    @FindBy(id = "locationPlaceholder")
    public WebElement sutLocationInput;

    @FindBy(css = "#locations > li > a")
    public WebElement sutLocationSuggestion;

    @FindBy(id = "userName")
    public WebElement sutUserName;

    @FindBy(id = "userMobile")
    public WebElement sutUserMobile;

    @FindBy(css = ".form-sell-btn2")
    public WebElement sutSubmitBtn1;

    @FindBy(id = "tractorBrand")
    public WebElement sutBrandDropdown;

    @FindBy(id = "tractorModal")
    public WebElement sutModelDropdown;

    @FindBy(id = "tractorYear")
    public WebElement sutYearDropdown;

    @FindBy(css = "#step1 button.default-btn")
    public WebElement sutStep1Continue;

    @FindBy(id = "tractorEnginConditions")
    public WebElement sutEngineCondition;

    @FindBy(id = "tractorTyreConditions")
    public WebElement sutTyreCondition;

    @FindBy(id = "tractorEngineHours")
    public WebElement sutEngineHours;

    @FindBy(css = "button[data-step='TRACTOR_CONDITION']")
    public WebElement sutStep2Continue;

    @FindBy(id = "image1")
    public WebElement sutImage1;

    @FindBy(id = "image2")
    public WebElement sutImage2;

    @FindBy(css = "#step3 button.default-btn")
    public WebElement sutStep3Continue;

    @FindBy(id = "dealbtn")
    public WebElement sutFinalSubmit;

    @FindBy(css = ".thankModal-img")
    public WebElement sutThankModalClose;

    @FindBy(css = ".close-request")
    public WebElement sutCloseModal;

    // -------------------- Sell Used Implements --------------------

    @FindBy(css = ".col-12 > .form-group > .form-control")
    public WebElement suiCategoryDropdown;

    @FindBy(css = ":nth-child(2) > .form-group > .form-control")
    public WebElement suiBrandDropdown;

    @FindBy(id = "model_name")
    public WebElement suiModelName;

    @FindBy(css = ":nth-child(4) > .form-group > .form-control")
    public WebElement suiYearDropdown;

    @FindBy(css = "fieldset.ng-scope > .form-submit-btn")
    public WebElement suiContinue1;

    @FindBy(css = ".col-12 > .form-group > .form-control")
    public WebElement suiOwnerName;

    @FindBy(css = ".input-group > .form-control")
    public WebElement suiPriceInput;

    @FindBy(css = ".row > :nth-child(3) > .form-group > .form-control")
    public WebElement suiDescription;

    @FindBy(css = ".ng-scope > .form-submit-btn")
    public WebElement suiContinue2;

    @FindBy(id = "fileField0")
    public WebElement suiImage1;

    @FindBy(id = "fileField1")
    public WebElement suiImage2;

    @FindBy(css = "fieldset.ng-scope > .form-submit-btn")
    public WebElement suiContinue3;

    @FindBy(css = ".row > :nth-child(1) > .form-group > .form-control")
    public WebElement suiContactName;

    @FindBy(css = ":nth-child(2) > .form-group > .form-control")
    public WebElement suiContactMobile;

    @FindBy(css = ".row > :nth-child(3) > .form-group > .form-control")
    public WebElement suiStateDropdown;

    @FindBy(css = ":nth-child(4) > .form-group > .form-control")
    public WebElement suiDistrictDropdown;

    @FindBy(css = ":nth-child(5) > .form-group > .form-control")
    public WebElement suiTehsilDropdown;

    @FindBy(css = ".row > :nth-child(6) > .form-group > .form-control")
    public WebElement suiPincodeInput;

    @FindBy(css = "fieldset.ng-scope > .form-submit-btn")
    public WebElement suiFinalSubmit;

    // -------------------- Sell Used Harvester --------------------

    @FindBy(css = ":nth-child(2) > .form-group > .form-control")
    public WebElement suhModelInput;

    @FindBy(css = ".row > :nth-child(3) > .form-group > .form-control")
    public WebElement suhCropType;

    @FindBy(css = ":nth-child(4) > .form-group > .form-control")
    public WebElement suhCuttingWidth;

    @FindBy(css = ":nth-child(5) > .form-group > .form-control")
    public WebElement suhDriveType;

    @FindBy(css = ".col-12 > .form-group > .form-control")
    public WebElement suhBrandDropdown;

    @FindBy(css = "fieldset.ng-scope > .form-submit-btn")
    public WebElement suhContinue1;

    @FindBy(css = ".col-12 > .form-group > .form-control")
    public WebElement suhOwnerName;

    @FindBy(css = ":nth-child(2) > .form-group > .form-control")
    public WebElement suhEngineHours;

    @FindBy(css = ".row > :nth-child(3) > .form-group > .form-control")
    public WebElement suhYearDropdown;

    @FindBy(css = ".input-group > .form-control")
    public WebElement suhPriceInput;

    @FindBy(css = ":nth-child(5) > .form-group > .form-control")
    public WebElement suhDescription;

    @FindBy(id = "fileField0")
    public WebElement suhImage1;

    @FindBy(id = "fileField1")
    public WebElement suhImage2;

    @FindBy(css = "fieldset.ng-scope > .form-submit-btn")
    public WebElement suhContinue2;

    @FindBy(css = ".row > :nth-child(1) > .form-group > .form-control")
    public WebElement suhContactName;

    @FindBy(css = ":nth-child(2) > .form-group > .form-control")
    public WebElement suhContactMobile;

    @FindBy(css = ".row > :nth-child(3) > .form-group > .form-control")
    public WebElement suhStateDropdown;

    @FindBy(css = ":nth-child(4) > .form-group > .form-control")
    public WebElement suhDistrictDropdown;

    @FindBy(css = ":nth-child(5) > .form-group > .form-control")
    public WebElement suhTehsilDropdown;

    @FindBy(css = ".row > :nth-child(6) > .form-group > .form-control")
    public WebElement suhPincodeInput;

    @FindBy(css = "fieldset.ng-scope > .form-submit-btn")
    public WebElement suhFinalSubmit;
    
 

    
    
    
    
    
}

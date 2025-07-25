package com.tractorjunction.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.tractorjunction.base.BaseTest;
import com.tractorjunction.pages.LocationMasterPage;
import com.tractorjunction.utils.DropdownValidator;
import com.tractorjunction.utils.TestUtils;

public class LocationMasterTests extends BaseTest {

    @Test
    public void validateStates_HomePage_English() {
        LocationMasterPage page = new LocationMasterPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().get(baseUrl);
        wait.until(ExpectedConditions.elementToBeClickable(page.secondNewTractorCard)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(page.stateDropdownOptions));
        DropdownValidator.validateStateDropdown("english", page.stateDropdownOptions);
    }

    @Test
    public void validateStates_AllBrands_Hindi() {
        LocationMasterPage page = new LocationMasterPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().get(baseUrl + "hi/all-brands/");
        wait.until(ExpectedConditions.elementToBeClickable(page.secondBrandTractorCard)).click();   
        wait.until(ExpectedConditions.visibilityOfAllElements(page.stateDropdownOptions));
        DropdownValidator.validateStateDropdown("hindi", page.stateDropdownOptions);
    }

    @Test
    public void validateStates_UsedDetail_Tamil() {
        LocationMasterPage page = new LocationMasterPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().get(baseUrl + "ta/used-tractor/john-deere/5045-d-205177/221192/");
        wait.until(ExpectedConditions.elementToBeClickable(page.usedDetailCard)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(page.stateDropdownOptions));
        DropdownValidator.validateStateDropdown("tamil", page.stateDropdownOptions);
    }

    @Test
    public void validateStates_TractorCompare_Telugu() {
        LocationMasterPage page = new LocationMasterPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().get(baseUrl + "te/compare-tractors/");
        wait.until(ExpectedConditions.elementToBeClickable(page.compareCard)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(page.stateDropdownOptions));
        DropdownValidator.validateStateDropdown("telugu", page.stateDropdownOptions);
    }

    @Test
    public void validateStates_Tyres_Marathi() {
        LocationMasterPage page = new LocationMasterPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().get(baseUrl + "mr/tyres/");
        wait.until(ExpectedConditions.elementToBeClickable(page.firstTyreCard)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(page.tyreDropdownOptions));
        DropdownValidator.validateStateDropdown("marathi", page.tyreDropdownOptions);
    } 

    @Test
    public void validateStates_PDPImage_English() {
        LocationMasterPage page = new LocationMasterPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().get(baseUrl + "mahindra-tractor/575-di-xp-plus/");
        TestUtils.scrollToBottom(getDriver());
        wait.until(ExpectedConditions.elementToBeClickable(page.popupCloseIcon)).click();
        TestUtils.jsClick(getDriver(), page.firstImageGalleryThumb);
        wait.until(ExpectedConditions.elementToBeClickable(page.imageGalleryConfirmButton)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(page.imagestateDropdownOptions));
        DropdownValidator.validateStateDropdown("english", page.imagestateDropdownOptions);
    } 

    @Test
    public void validateStates_PDPFlashPopup_Hindi() {
        LocationMasterPage page = new LocationMasterPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().get(baseUrl + "hi/mahindra-tractor/575-di-xp-plus/");
        TestUtils.scrollToBottom(getDriver());
        wait.until(ExpectedConditions.elementToBeClickable(page.pdpFlashPopupTrigger)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(page.imagestateDropdownOptions));
        DropdownValidator.validateStateDropdown("hindi", page.imagestateDropdownOptions);
    } 

    @Test
    public void validateStates_ListingFlashPopup_Telugu() {
        LocationMasterPage page = new LocationMasterPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().get(baseUrl + "te/tractors/");
        TestUtils.scrollToBottom(getDriver());
        wait.until(ExpectedConditions.visibilityOfAllElements(page.flashPopupStateOptions));
        DropdownValidator.validateStateDropdown("telugu", page.flashPopupStateOptions);
    } 

    @Test
    public void validateStates_NewsDetail_English() {
        LocationMasterPage page = new LocationMasterPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().get(baseUrl + "tractor-news/madras-hc-grants-status-quo-on-massey-ferguson-brand/");
        wait.until(ExpectedConditions.elementToBeClickable(page.firstTractorCard)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(page.stateDropdownOptions));
        DropdownValidator.validateStateDropdown("english", page.stateDropdownOptions);
    } 

    @Test
    public void validateEMICalcStates_English() {
        LocationMasterPage page = new LocationMasterPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().get(baseUrl + "tractor-loan-emi-calculator/");
        wait.until(ExpectedConditions.elementToBeClickable(page.emiCalcTractorCard)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(page.stateDropdownOptions));
        DropdownValidator.validateStateDropdown("english", page.stateDropdownOptions);
    }
}

package com.tractorjunction.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tractorjunction.models.LeadTestData;
import com.tractorjunction.pages.LeadFormPage;

public class LeadFormHelper {

    public static void submitLeadForm(WebDriver driver, LeadFormPage page, int index) {
        LeadTestData data = LeadTestDataReader.getTestDataByIndex(index);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        page.ctpNameInput.sendKeys("Testqa");
        TestUtils.sleep(1000);
        page.ctpMobileInput.sendKeys(data.getMobile());
        TestUtils.sleep(1000);
        new Select(page.ctpStateDropdown).selectByVisibleText(data.getState());
        TestUtils.sleep(1000);
        new Select(page.ctpDistrictDropdown).selectByVisibleText(data.getDistrict());
        TestUtils.sleep(1000);
        new Select(page.ctpTehsilDropdown).selectByVisibleText(data.getTaluka());

        page.ctpMainCTAButton.click();
        wait.until(ExpectedConditions.visibilityOf(page.finalValidationToast));

        if (page.ctaReceiveSimilarOffers.isDisplayed()) {
            page.ctaReceiveSimilarOffers.click();
        }
    }
}

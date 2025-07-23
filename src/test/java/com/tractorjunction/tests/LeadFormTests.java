package com.tractorjunction.tests;

import org.testng.annotations.Test;

import com.tractorjunction.base.BaseTest;
import com.tractorjunction.pages.LeadFormPage;
import com.tractorjunction.utils.LeadFormHelper;
import com.tractorjunction.utils.TestUtils;

public class LeadFormTests extends BaseTest {

    @Test
    public void TJWA_TC_LNT_001() {
        LeadFormPage page = new LeadFormPage(getDriver());
        getDriver().get(baseUrl);
        TestUtils.sleep(2000);
        page.ctpHpTractorsIn2024.click();
        TestUtils.sleep(2000);
        LeadFormHelper.submitLeadForm(getDriver(), page, 0);
    } 

  /*  @Test
    public void TJWA_TC_LNT_002() {
        LeadFormPage page = new LeadFormPage(getDriver());
        getDriver().get(baseUrl);
        TestUtils.sleep(2000);
        page.ctpHpTractorsByBudget.click();
        TestUtils.sleep(2000);
        LeadFormHelper.submitLeadForm(getDriver(), page, 1);
    }

    @Test
    public void TJWA_TC_LNT_003() {
        LeadFormPage page = new LeadFormPage(getDriver());
        getDriver().get(baseUrl);
        TestUtils.sleep(2000);
        page.ctpHpMiniTractors.click();
        TestUtils.sleep(2000);
        LeadFormHelper.submitLeadForm(getDriver(), page, 2);
    }

    @Test
    public void TJWA_TC_LNT_004() {
        LeadFormPage page = new LeadFormPage(getDriver());
        getDriver().get(baseUrl + "tractors/");
        TestUtils.sleep(2000);
        page.ctpLpNewTractors1.click();
        TestUtils.sleep(2000);
        TestUtils.closePopupIfPresent(getDriver(), null);
        LeadFormHelper.submitLeadForm(getDriver(), page, 3);
    }

    @Test
    public void TJWA_TC_LNT_005() {
        LeadFormPage page = new LeadFormPage(getDriver());
        getDriver().get(baseUrl + "massey-ferguson-tractor/");
        TestUtils.sleep(2000);
        TestUtils.closePopupIfPresent(getDriver(), null);
        page.ctpLpNewTractors2.click();
        TestUtils.sleep(2000);
        LeadFormHelper.submitLeadForm(getDriver(), page, 5);
    }

    @Test
    public void TJWA_TC_LNT_006() {
        LeadFormPage page = new LeadFormPage(getDriver());
        getDriver().get(baseUrl + "captain-tractor/200-di-ls/");
        TestUtils.sleep(2000);
        page.ctpPdpNtHeroSection.click();
        TestUtils.sleep(2000);
        LeadFormHelper.submitLeadForm(getDriver(), page, 6);
    }

    @Test
    public void TJWA_TC_LNT_007() {
        LeadFormPage page = new LeadFormPage(getDriver());
        getDriver().get(baseUrl + "tractor-loan-emi-calculator/");
        TestUtils.sleep(2000);
        page.ctpEMIPage.click();
        TestUtils.sleep(2000);
        LeadFormHelper.submitLeadForm(getDriver(), page, 7);
    }

    @Test
    public void TJWA_TC_LNT_008() {
        LeadFormPage page = new LeadFormPage(getDriver());
        getDriver().get(baseUrl + "sell-used-tractor/");
        TestUtils.sleep(2000);

        page.sutLocationInput.sendKeys("Belagavi (Belgaum)");
        TestUtils.sleep(2000);
        page.sutLocationSuggestion.click();
        TestUtils.sleep(1000);
        page.sutUserName.sendKeys("Testqa");
        page.sutUserMobile.sendKeys("9730535423");
        page.sutSubmitBtn1.click();
        TestUtils.sleep(2000);

        new Select(page.sutBrandDropdown).selectByVisibleText("Mahindra");
        TestUtils.sleep(1000);
        new Select(page.sutModelDropdown).selectByIndex(1);
        TestUtils.sleep(1000);
        new Select(page.sutYearDropdown).selectByVisibleText("2021");
        page.sutStep1Continue.click();
        TestUtils.sleep(2000);

        new Select(page.sutEngineCondition).selectByIndex(1);
        new Select(page.sutTyreCondition).selectByIndex(1);
        page.sutEngineHours.sendKeys("1000");
        page.sutStep2Continue.click();
        TestUtils.sleep(2000);

        String imagePath = new File("src/main/resources/test-data/atlassian.png").getAbsolutePath();
        page.sutImage1.sendKeys(imagePath);
        page.sutImage2.sendKeys(imagePath);
        page.sutStep3Continue.click();
        TestUtils.sleep(2000);

        page.sutFinalSubmit.click();
        TestUtils.sleep(2000);

        if (TestUtils.isElementPresent(page.sutThankModalClose)) {
            page.sutThankModalClose.click();
        }
    }

    @Test
    public void TJWA_TC_LSU_002() {
        LeadFormPage page = new LeadFormPage(getDriver());
        getDriver().get(baseUrl + "sell/farm-implements/");
        TestUtils.sleep(2000);

        new Select(page.suiCategoryDropdown).selectByValue("56");
        new Select(page.suiBrandDropdown).selectByValue("79");
        page.suiModelName.sendKeys("Testqa SUI W");
        new Select(page.suiYearDropdown).selectByVisibleText("2024");
        page.suiContinue1.click();
        TestUtils.sleep(1000);

        page.suiOwnerName.sendKeys("Testqa SUI W");
        page.suiPriceInput.sendKeys("50000");
        page.suiDescription.sendKeys("Testqa SUI W");
        page.suiContinue2.click();
        TestUtils.sleep(2000);

        String imagePath = new File("src/main/resources/test-data/atlassian.png").getAbsolutePath();
        page.suiImage1.sendKeys(imagePath);
        TestUtils.sleep(2000);
        page.suiImage2.sendKeys(imagePath);
        TestUtils.sleep(2000);
        page.suiContinue3.click();
        TestUtils.sleep(2000);

        page.suiContactName.sendKeys("Testqa SUI W");
        page.suiContactMobile.sendKeys("9730535354");
        new Select(page.suiStateDropdown).selectByVisibleText("Rajasthan");
        TestUtils.sleep(2000);
        new Select(page.suiDistrictDropdown).selectByVisibleText("Dholpur");
        TestUtils.sleep(2000);
        new Select(page.suiTehsilDropdown).selectByVisibleText("Dholpur");
        page.suiPincodeInput.sendKeys("591265");
        page.suiFinalSubmit.click();
    }

    @Test
    public void TJWA_TC_LSU_010() {
        LeadFormPage page = new LeadFormPage(getDriver());
        getDriver().get(baseUrl + "sell/harvester/");
        TestUtils.sleep(2000);

        new Select(page.suhBrandDropdown).selectByValue("64");
        page.suhModelInput.sendKeys("Testqa SUH W");
        TestUtils.sleep(2000);
        new Select(page.suhCropType).selectByVisibleText("Paddy");
        TestUtils.sleep(2000);
        new Select(page.suhCuttingWidth).selectByVisibleText("8-14 Feets");
        TestUtils.sleep(2000);
        new Select(page.suhDriveType).selectByVisibleText("Self");
        TestUtils.sleep(2000);
        page.suhContinue1.click();
        TestUtils.sleep(2000);

        page.suhOwnerName.sendKeys("Testqa SUH W");
        new Select(page.suhEngineHours).selectByVisibleText("1001 - 2000");
        new Select(page.suhYearDropdown).selectByVisibleText("2020");
        page.suhPriceInput.sendKeys("50000");
        page.suhDescription.sendKeys("Testqa SUH W");
        page.suhContinue2.click();
        TestUtils.sleep(2000);

        String imagePath = new File("src/main/resources/test-data/atlassian.png").getAbsolutePath();
        page.suhImage1.sendKeys(imagePath);
        TestUtils.sleep(2000);
        page.suhImage2.sendKeys(imagePath);
        TestUtils.sleep(2000);
        page.suhContinue2.click(); // Assuming same continue button
        TestUtils.sleep(2000);

        page.suhContactName.sendKeys("Testqa SUH W");
        page.suhContactMobile.sendKeys("9730535354");
        new Select(page.suhStateDropdown).selectByVisibleText("Maharashtra");
        TestUtils.sleep(2000);
        new Select(page.suhDistrictDropdown).selectByVisibleText("Beed");
        TestUtils.sleep(2000);
        new Select(page.suhTehsilDropdown).selectByVisibleText("Beed");
        page.suhPincodeInput.sendKeys("591265");
        page.suhFinalSubmit.click();
        TestUtils.sleep(2000);
    }*/
}

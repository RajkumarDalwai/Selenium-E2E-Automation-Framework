package com.tractorjunction.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tractorjunction.base.BaseTest;
import com.tractorjunction.pages.PageRedirectionPage;
import com.tractorjunction.utils.LinkValidator;

public class PageRedirectionTests extends BaseTest {

    private PageRedirectionPage page;
    private LinkValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new LinkValidator(getDriver());
    }

  /*  @Test
    public void validateAllLinksOnHeaders() {
        getDriver().get(baseUrl);
        page = new PageRedirectionPage(getDriver());
        validator.validateLinks(page.headerLinks);
    } */

    @Test
    public void validateAllLinksOnFooter() {
        getDriver().get(baseUrl);
        page = new PageRedirectionPage(getDriver());
        validator.validateLinks(page.footerLinks);
    }

  /*  @Test
    public void validateAllLinksOnHomePage() {
        getDriver().get(baseUrl);
        page = new PageRedirectionPage(getDriver());
        validator.validateLinks(page.commonPageLinks);
    }

    @Test
    public void validateAllLinksOnNewListingPage() {
        getDriver().get(baseUrl + "tractors/");
        page = new PageRedirectionPage(getDriver());
        validator.validateLinks(page.commonPageLinks);
    }

    @Test
    public void validateAllLinksOnUsedListingPage() {
        getDriver().get(baseUrl + "used-tractors-for-sell/");
        page = new PageRedirectionPage(getDriver());
        validator.validateLinks(page.commonPageLinks);
    }

    @Test
    public void validateAllLinksOnNewProductDetailPage() {
        getDriver().get(baseUrl + "mahindra-tractor/575-di-xp-plus/");
        page = new PageRedirectionPage(getDriver());
        validator.validateLinks(page.commonPageLinks);
    }

    @Test
    public void validateAllLinksOnUsedProductDetailPage() {
        getDriver().get(baseUrl + "used-tractor/sonalika/di-42-rx-205130/221145/");
        page = new PageRedirectionPage(getDriver());
        validator.validateLinks(page.commonPageLinks);
    }

    @Test
    public void validateAllLinksOnComparePage() {
        getDriver().get(baseUrl + "compare-tractors/");
        page = new PageRedirectionPage(getDriver());
        validator.validateLinks(page.commonPageLinks);
    }

    @Test
    public void validateAllLinksOnEMICalcPage() {
        getDriver().get(baseUrl + "tractor-loan-emi-calculator/");
        page = new PageRedirectionPage(getDriver());
        validator.validateLinks(page.commonPageLinks);
    }

    @Test
    public void validateAll500UrlsFromExcel() {
        String filePath = "src/main/resources/test-data/top_500_endpoints.xlsx";
        String sheetName = "Endpoints";

        String[][] data = ExcelReader.getTestData(filePath, sheetName);

        for (String[] row : data) {
            String url = row[0].trim();
            String fullUrl = url.startsWith("http") ? url : baseUrl + url;
            validator.validateSingleUrl(fullUrl);  // ✅ Updated method name
        }

        validator.printValidationSummary();       // ✅ Updated method name
    }*/

}

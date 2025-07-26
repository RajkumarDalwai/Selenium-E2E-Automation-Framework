package com.tractorjunction.tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tractorjunction.base.BaseTest;
import com.tractorjunction.pages.UsedTractorListingPage;

public class UsedTractorListingTests extends BaseTest {

    @Test
    public void TJWA_TC_UTL_001_verifyUsedTractorPricesIn0to2LakhRange() {
        UsedTractorListingPage page = new UsedTractorListingPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        getDriver().get(baseUrl + "assured-used-tractors-for-sell/");

        page.applyPriceFilter_0to2Lakh();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector(".hotDeal-tractor-price")));

        List<Integer> allPrices = page.getAllPrices();
        for (Integer price : allPrices) {
            assertTrue(price <= 200000, "❌ Price is not in 0–2 Lakh range: ₹" + price);
        }
    }

    @Test
    public void TJWA_TC_UTL_002_verifyBrandModelFilter_Mahindra575DI() {
        UsedTractorListingPage page = new UsedTractorListingPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        getDriver().get(baseUrl + "assured-used-tractors-for-sell/");

        page.applyBrandModelFilter_Mahindra_575DI();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("div.hotDeal-tractor-content p.used-product-name a.weblink")));

        List<String> titles = page.getAllTitles();
        for (String title : titles) {
            String lowerTitle = title.toLowerCase();
            Assert.assertTrue(
                    lowerTitle.contains("mahindra") && lowerTitle.contains("575"),
                    "❌ Title does not match expected model: " + title
            );
        }
    }

    @Test
    public void TJWA_TC_UTL_003_verifyYearFilter_2025() {
        UsedTractorListingPage page = new UsedTractorListingPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        getDriver().get(baseUrl + "assured-used-tractors-for-sell/");

        page.applyYearFilter_2025();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//span[contains(@class, 'oneline') and contains(text(),'Model')]")));

        List<String> years = page.getAllYears();
        for (String year : years) {
            Assert.assertTrue(year.contains("2025"), "❌ Year does not match filter: " + year);
        }
    }

    @Test
    public void TJWA_TC_UTL_004_verifySortByLowToHighAfterPriceFilter() {
        UsedTractorListingPage page = new UsedTractorListingPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        getDriver().get(baseUrl + "assured-used-tractors-for-sell/");

        page.applyPriceFilter_0to2Lakh();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector(".hotDeal-tractor-price")));

        page.sortByPriceLowToHigh();

        wait.until(driver -> page.getAllPrices().size() > 0);

        Assert.assertTrue(page.arePricesSortedLowToHigh(), "❌ Prices not sorted from Low to High.");
    }

    @Test
    public void TJWA_TC_UTL_006_combinedFilters_2to3Lakh_Mahindra_2011_Sorted() {
        UsedTractorListingPage page = new UsedTractorListingPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        getDriver().get(baseUrl + "assured-used-tractors-for-sell/");

        page.applyPriceFilter_2to3Lakh();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector(".hotDeal-tractor-price")));

        page.applyBrandFilter_Mahindra();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector(".hotDeal-tractor-price")));

        page.applyYearFilter_2011();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector(".hotDeal-tractor-price")));

        page.sortByPriceLowToHigh();
        wait.until(driver -> page.getAllPrices().size() > 0);

        List<Integer> prices = page.getAllPrices();
        for (Integer price : prices) {
            Assert.assertTrue(
                    price >= 200000 && price <= 300000,
                    "❌ Price not in 2–3 Lakh range: ₹" + price
            );
        }

        List<String> titles = page.getAllTitles();
        for (String title : titles) {
            Assert.assertTrue(
                    title.toLowerCase().contains("mahindra"),
                    "❌ Title does not contain Mahindra: " + title
            );
        }

        List<String> years = page.getAllYears();
        for (String year : years) {
            Assert.assertTrue(
                    year.contains("2011"),
                    "❌ Year does not match filter: " + year
            );
        }

        Assert.assertTrue(page.arePricesSortedLowToHigh(), "❌ Prices not sorted Low to High.");
    }
}

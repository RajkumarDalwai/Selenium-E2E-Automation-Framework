package com.tractorjunction.tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tractorjunction.base.BaseTest;
import com.tractorjunction.pages.UsedTractorListingPage;

public class UsedTractorListingTests extends BaseTest {

    UsedTractorListingPage page;
    WebDriverWait wait;

    @BeforeMethod
    public void setupPageObject() {
        page = new UsedTractorListingPage(getDriver());
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        getDriver().get(baseUrl + "assured-used-tractors-for-sell/");
    }

    @Test
    public void TJWA_TC_UTL_001_verifyUsedTractorPricesIn0to2LakhRange() {
        page.applyPriceFilter_0to2Lakh();

        // Wait for price elements to load after filter
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector(".hotDeal-tractor-price")));

        List<Integer> allPrices = page.getAllPrices();
        System.out.println("Extracted Prices: " + allPrices);

        for (Integer price : allPrices) {
            assertTrue(price <= 200000, "❌ Price is not in 0–2 Lakh range: ₹" + price);
        }
    }

    @Test
    public void TJWA_TC_UTL_002_verifyBrandModelFilter_Mahindra575DI() {
        page.applyBrandModelFilter_Mahindra_575DI();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("div.hotDeal-tractor-content p.used-product-name a.weblink")));

        List<String> titles = page.getAllTitles();
        System.out.println("📝 Titles found:");
        titles.forEach(System.out::println);

        for (String title : titles) {
            String lowerTitle = title.toLowerCase();
            Assert.assertTrue(
                    lowerTitle.contains("mahindra") && lowerTitle.contains("575"),
                    "❌ Title does not match expected model: " + title
            );
        }

        System.out.println("✅ All filtered results are for Mahindra 575 DI.");
    }

    @Test
    public void TJWA_TC_UTL_003_verifyYearFilter_2025() {
        page.applyYearFilter_2025();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//span[contains(@class, 'oneline') and contains(text(),'Model')]")));

        List<String> years = page.getAllYears();
        System.out.println("📅 Years found:");
        years.forEach(System.out::println);

        for (String year : years) {
            Assert.assertTrue(year.contains("2025"), "❌ Year does not match filter: " + year);
        }

        System.out.println("✅ All filtered results are for year 2025.");
    }

    @Test
    public void TJWA_TC_UTL_004_verifySortByLowToHighAfterPriceFilter() {
        page.applyPriceFilter_0to2Lakh();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector(".hotDeal-tractor-price")));

        page.sortByPriceLowToHigh();

        wait.until(driver -> page.getAllPrices().size() > 0);

        Assert.assertTrue(page.arePricesSortedLowToHigh(), "❌ Prices not sorted from Low to High.");
    }

    @Test
    public void TJWA_TC_UTL_006_combinedFilters_2to3Lakh_Mahindra_2011_Sorted() {
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
        System.out.println("Filtered Prices: " + prices);
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

package com.tractorjunction.tests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tractorjunction.base.BaseTest;
import com.tractorjunction.pages.ComparePage;

public class CompareTests extends BaseTest {

    @Test
    public void verifyComparisonHeadingIsCorrect() {
        ComparePage comparePage = new ComparePage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // Navigate to comparison page
        getDriver().get(baseUrl + "compare-tractors/");
        wait.until(ExpectedConditions.visibilityOfAllElements(comparePage.addTractorButtons));

        // --- First tractor (Brand 1, Model 1) ---
        comparePage.clickAddTractorSlot(0);
        String brand1 = comparePage.getBrandNameByIndex(1);
        comparePage.clickBrandByIndex(1);
        wait.until(ExpectedConditions.visibilityOf(comparePage.firstModelCard));
        String model1 = comparePage.clickFirstModelAndGetText();

        // --- Second tractor (Brand 2, Model 1) ---
        String brand2 = comparePage.getBrandNameByIndex(2);
        comparePage.clickBrandByIndex(2);
        wait.until(ExpectedConditions.visibilityOf(comparePage.firstModelCard));
        String model2 = comparePage.clickFirstModelAndGetText();

        // Click Compare
        wait.until(ExpectedConditions.elementToBeClickable(comparePage.compareButton));
        comparePage.clickCompare();

        // Validate heading
        wait.until(ExpectedConditions.visibilityOf(comparePage.comparisonHeader));
        String actualHeading = comparePage.getComparisonHeading();
        String expectedHeading = brand1 + " " + model1 + " vs " + brand2 + " " + model2 + " Comparison";

        System.out.println("✅ Expected: " + expectedHeading);
        System.out.println("✅ Actual: " + actualHeading);

        Assert.assertEquals(actualHeading, expectedHeading, "❌ Comparison H1 does not match expected.");
    }

    @Test
    public void verifyScrollToOtherInformationSectionOnTabClick() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        ComparePage comparePage = new ComparePage(getDriver());

        // Navigate directly to the compare result page
        getDriver().get(baseUrl + "compare-tractors/mahindra+575-di-xp-plus-vs-farmtrac+60-epi-t20-powermaxx/");

        // Wait and click on the "Other Information" tab
        wait.until(ExpectedConditions.elementToBeClickable(comparePage.otherInfoTab));
        comparePage.otherInfoTab.click();

        // Wait for the "Other Information" section to be visible
        wait.until(ExpectedConditions.visibilityOf(comparePage.otherInfoSection));

        // Scroll into view
        ((JavascriptExecutor) getDriver()).executeScript(
            "arguments[0].scrollIntoView({behavior: 'smooth'});", 
            comparePage.otherInfoSection
        );

        // Wait for scroll animation
        Thread.sleep(1000);

        // Verify the section is in viewport
        Boolean isInView = (Boolean) ((JavascriptExecutor) getDriver()).executeScript(
            "const rect = arguments[0].getBoundingClientRect();" +
            "return (rect.top >= 0 && rect.bottom <= (window.innerHeight || document.documentElement.clientHeight));",
            comparePage.otherInfoSection
        );

        Assert.assertTrue(isInView, "❌ 'Other Information' section is not visible in viewport after tab click.");
    }
}

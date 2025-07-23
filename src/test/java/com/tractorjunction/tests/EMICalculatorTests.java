package com.tractorjunction.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tractorjunction.base.BaseTest;
import com.tractorjunction.pages.EMICalculatorPage;

public class EMICalculatorTests extends BaseTest {

    @Test
    public void TC_001_verifyEmiCalculationWithDefaultDownPayment() {
        getDriver().get(baseUrl + "tractor-loan-emi-calculator/");
        EMICalculatorPage page = new EMICalculatorPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // Open brand dropdown
        page.brandSelect.click();
        wait.until(ExpectedConditions.visibilityOf(page.firstBrand)).click();

        // Select first model
        wait.until(ExpectedConditions.visibilityOf(page.firstModel)).click();

        // Click Calculate EMI
        wait.until(ExpectedConditions.elementToBeClickable(page.calculateEMIButton)).click();

        // Wait for EMI results to be visible
        wait.until(ExpectedConditions.visibilityOf(page.monthlyEMI));
        wait.until(ExpectedConditions.visibilityOf(page.loanAmount));
        wait.until(ExpectedConditions.visibilityOf(page.totalPayable));

        // Expected values
        String expectedEMI = "₹ 22,795";
        String expectedLoanAmount = "₹ 9,58,185";
        String expectedTotalPayable = "₹ 13,67,709";

        // Validations
        Assert.assertEquals(page.monthlyEMI.getText().trim(), expectedEMI, "❌ EMI mismatch");
        Assert.assertEquals(page.loanAmount.getText().trim(), expectedLoanAmount, "❌ Loan Amount mismatch");
        Assert.assertEquals(page.totalPayable.getText().trim(), expectedTotalPayable, "❌ Total Payable mismatch");
    }
}

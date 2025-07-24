package com.tractorjunction.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tractorjunction.base.BaseTest;
import com.tractorjunction.pages.SearchPage;

public class SearchTests extends BaseTest {

	@Test
	public void testSearchFunctionality() {
	    WebDriver driver = getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increased timeout

	    driver.get(baseUrl); // Load the application

	    // Initialize Page Object
	    SearchPage searchPage = new SearchPage(driver);

	    // Step 1 & 2: Perform search via Page Object method
	    searchPage.enterSearchAndSubmit("Mahindra 575");

	    // Wait for page to be fully loaded
	    wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));

	    // Wait for the heading element to be visible
	    By headingLocator = By.tagName("h1");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(headingLocator));

	    // Step 3: Wait until the heading text matches the expected value
	    wait.until(d -> {
	        try {
	            WebElement refreshedHeading = driver.findElement(headingLocator);
	            return refreshedHeading.getText().trim().equals("Mahindra 575 DI SP Plus");
	        } catch (StaleElementReferenceException e) {
	            return false; // Retry if stale element is encountered
	        }
	    });

	    // Step 4: Final assertion
	    String headingText = driver.findElement(headingLocator).getText().trim();
	    Assert.assertEquals(headingText, "Mahindra 575 DI SP Plus", "Search result heading mismatch.");
	}

	@Test
	public void testInvalidSearchShowsNoSuggestionsMessage() {
	    WebDriver driver = getDriver();
	    driver.get(baseUrl);

	    SearchPage searchPage = new SearchPage(driver);

	    // Use existing method to enter and submit invalid search
	    searchPage.enterSearchAndSubmit("nfjnvj");

	    // Get the no suggestion message
	    String noResultMsg = searchPage.getNoSuggestionMessage();

	    // Assert the expected result
	    Assert.assertTrue(noResultMsg.contains("Oops! No result found for 'nfjnvj'"),"Expected no result message not found");

	}

}

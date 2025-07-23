package com.tractorjunction.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tractorjunction.base.BaseTest;
import com.tractorjunction.pages.SearchPage;

public class SearchTests extends BaseTest {

	@Test
	public void testSearchFunctionality() {
	    WebDriver driver = getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    driver.get(baseUrl); // Load the application

	    // Initialize Page Object
	    SearchPage searchPage = new SearchPage(driver);

	    // Step 1 & 2: Perform search via Page Object method
	    searchPage.enterSearchAndSubmit("Mahindra 575");

	    // Step 3: Wait until the correct heading appears
	    wait.until(driver1 -> searchPage.getSearchHeadingText().equals("Mahindra 575 DI SP Plus"));

	    // Step 4: Final assertion
	    Assert.assertEquals(searchPage.getSearchHeadingText(),"Mahindra 575 DI SP Plus","Search result heading mismatch.");
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

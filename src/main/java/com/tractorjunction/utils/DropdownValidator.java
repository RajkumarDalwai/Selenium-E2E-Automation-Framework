package com.tractorjunction.utils;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DropdownValidator {

    public static void validateStateDropdown(String langKey, List<WebElement> actualOptions) {
        List<String> expected = ExcelReader.getStateData(
            "src/main/resources/test-data/MultilingualStates.xlsx", langKey);

        int actualSize = actualOptions.size() - 1;
        Assert.assertEquals(actualSize, expected.size(),
            "❌ Mismatch in dropdown count for " + langKey);

        for (int i = 1; i < actualOptions.size(); i++) {
            String actual = actualOptions.get(i).getText().trim();
            String expectedText = expected.get(i - 1).trim();
            Assert.assertEquals(actual, expectedText,
                "❌ Mismatch at index " + (i - 1) + ": expected '" + expectedText + "', found '" + actual + "'");
        }

        System.out.println("✅ All states matched for language: " + langKey);
    }
}

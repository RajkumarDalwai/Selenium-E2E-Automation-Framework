package com.tractorjunction.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tractorjunction.base.BaseTest;
import com.tractorjunction.pages.LanguageSwitcherPage;

public class LanguageSwitcherTests extends BaseTest {

    @Test
    public void testHindiLanguageSwitching() {
        LanguageSwitcherPage languageSwitcherPage = new LanguageSwitcherPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().get(baseUrl);
        languageSwitcherPage.openLanguageDropdown();
        languageSwitcherPage.selectHindi();
        wait.until(ExpectedConditions.urlToBe("https://www.tractorjunction.com/hi/"));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.tractorjunction.com/hi/", "Hindi URL mismatch");
    }

    @Test
    public void testTeluguLanguageSwitching() {
        LanguageSwitcherPage languageSwitcherPage = new LanguageSwitcherPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().get(baseUrl);
        languageSwitcherPage.openLanguageDropdown();
        languageSwitcherPage.selectTelugu();
        wait.until(ExpectedConditions.urlToBe("https://www.tractorjunction.com/te/"));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.tractorjunction.com/te/", "Telugu URL mismatch");
    }

    @Test
    public void testTamilLanguageSwitching() {
        LanguageSwitcherPage languageSwitcherPage = new LanguageSwitcherPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().get(baseUrl);
        languageSwitcherPage.openLanguageDropdown();
        languageSwitcherPage.selectTamil();
        wait.until(ExpectedConditions.urlToBe("https://www.tractorjunction.com/ta/"));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.tractorjunction.com/ta/", "Tamil URL mismatch");
    }

    @Test
    public void testMarathiLanguageSwitching() {
        LanguageSwitcherPage languageSwitcherPage = new LanguageSwitcherPage(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        getDriver().get(baseUrl);
        languageSwitcherPage.openLanguageDropdown();
        languageSwitcherPage.selectMarathi();
        wait.until(ExpectedConditions.urlToBe("https://www.tractorjunction.com/mr/"));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.tractorjunction.com/mr/", "Marathi URL mismatch");
    }
}
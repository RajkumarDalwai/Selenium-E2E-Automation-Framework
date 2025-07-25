package com.tractorjunction.tests;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tractorjunction.base.BaseTest;
import com.tractorjunction.pages.SeoElementsPage;

public class SeoElementsTests extends BaseTest {

    JSONObject currentLangData;
    SeoElementsPage seoPage;

    @BeforeMethod
    public void setupPageObject() {
        seoPage = new SeoElementsPage(getDriver());
    }

    // Store current language data and navigate to the test URL
    private void load(JSONObject langData) {
        currentLangData = langData;
        // Navigate to the test URL
        String testUrl = baseUrl + langData.get("url").toString();
        getDriver().get(testUrl);
        System.out.println("Navigated to: " + testUrl); // Debug log
    }

    @Test(dataProvider = "seoData", dataProviderClass = com.tractorjunction.utils.DataProviderUtils.class)
    public void test01_H1Validation(String lang, JSONObject langData) {
        load(langData);
        Assert.assertEquals(
            seoPage.getH1Text(),
            langData.get("h1"),
            "H1 mismatch for language: " + lang
        );
    }

    @Test(dataProvider = "seoData", dataProviderClass = com.tractorjunction.utils.DataProviderUtils.class)
    public void test02_H2Validation(String lang, JSONObject langData) {
        load(langData);
        JSONArray expectedH2s = (JSONArray) langData.get("h2s");
        for (Object h2 : expectedH2s) {
            Assert.assertTrue(
                seoPage.getH2Texts().contains(h2.toString().trim()),
                "Missing H2 for lang [" + lang + "]: " + h2
            );
        }
    }

    @Test(dataProvider = "seoData", dataProviderClass = com.tractorjunction.utils.DataProviderUtils.class)
    public void test03_H3Validation(String lang, JSONObject langData) {
        load(langData);
        if (langData.containsKey("h3s")) {
            JSONArray expectedH3s = (JSONArray) langData.get("h3s");
            for (Object h3 : expectedH3s) {
                Assert.assertTrue(
                    seoPage.getH3Texts().contains(h3.toString().trim()),
                    "Missing H3 for lang [" + lang + "]: " + h3
                );
            }
        }
    }

    @Test(dataProvider = "seoData", dataProviderClass = com.tractorjunction.utils.DataProviderUtils.class)
    public void test04_MetaTitleValidation(String lang, JSONObject langData) {
        load(langData);
        JSONObject meta = (JSONObject) langData.get("meta");
        String expectedTitle = meta.get("title").toString().trim();
        Assert.assertEquals(
            seoPage.getMetaTitle(),
            expectedTitle,
            "Meta Title mismatch for lang: " + lang
        );
    }

    @Test(dataProvider = "seoData", dataProviderClass = com.tractorjunction.utils.DataProviderUtils.class)
    public void test05_MetaDescriptionValidation(String lang, JSONObject langData) {
        load(langData);
        JSONObject meta = (JSONObject) langData.get("meta");
        String expectedDescription = meta.get("description").toString().trim();
        Assert.assertEquals(
            seoPage.getMetaDescription(),
            expectedDescription,
            "Meta Description mismatch for lang: " + lang
        );
    }

    @Test(dataProvider = "seoData", dataProviderClass = com.tractorjunction.utils.DataProviderUtils.class)
    public void test06_MetaKeywordsValidation(String lang, JSONObject langData) {
        load(langData);
        JSONObject meta = (JSONObject) langData.get("meta");
        String expectedKeywords = meta.get("keywords").toString().trim();
        Assert.assertEquals(
            seoPage.getMetaKeywords(),
            expectedKeywords,
            "Meta Keywords mismatch for lang: " + lang
        );
    }

    @Test(dataProvider = "seoData", dataProviderClass = com.tractorjunction.utils.DataProviderUtils.class)
    public void test07_BreadcrumbValidation(String lang, JSONObject langData) {
        load(langData);
        String expectedBreadcrumb = langData.get("breadcrumb").toString().trim();
        Assert.assertEquals(
            seoPage.getBreadcrumbText(),
            expectedBreadcrumb,
            "Breadcrumb mismatch for lang: " + lang
        );
    }

    @Test(dataProvider = "seoData", dataProviderClass = com.tractorjunction.utils.DataProviderUtils.class)
    public void test08_UrlStructureValidation(String lang, JSONObject langData) {
        load(langData);
        String expectedUrl = langData.get("url").toString().trim();
        Assert.assertTrue(
            seoPage.getCurrentUrl().contains(expectedUrl),
            "URL mismatch for lang: " + lang + ". Expected to contain: " + expectedUrl
        );
    }
}
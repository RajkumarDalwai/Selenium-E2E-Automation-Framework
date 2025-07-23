package com.tractorjunction.utils;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider(name = "seoData")
    public static Object[][] seoData() {
        JSONObject seoData = SeoDataReader.getSeoData();
        Object[][] testData = new Object[seoData.size()][2];
        int i = 0;
        for (Object key : seoData.keySet()) {
            testData[i][0] = key.toString();
            testData[i][1] = (JSONObject) seoData.get(key);
            i++;
        }
        return testData;
    }
}

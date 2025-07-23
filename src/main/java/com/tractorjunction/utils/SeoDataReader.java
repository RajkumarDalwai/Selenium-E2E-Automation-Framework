package com.tractorjunction.utils;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SeoDataReader {

    public static JSONObject getSeoData() {
        JSONObject seoData = null;
        try {
            FileReader reader = new FileReader("src/main/resources/test-data/SEO-Elements/StateSubsidyPage.json");
            JSONParser jsonParser = new JSONParser();
            seoData = (JSONObject) jsonParser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seoData;
    }
}

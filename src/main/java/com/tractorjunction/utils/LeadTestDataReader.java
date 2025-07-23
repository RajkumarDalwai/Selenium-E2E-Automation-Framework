package com.tractorjunction.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tractorjunction.models.LeadTestData;

public class LeadTestDataReader {

    private static final String JSON_FILE_PATH = "src/main/resources/test-data/NewTractorTestData.json";

    public static List<LeadTestData> getAllTestData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(new File(JSON_FILE_PATH))
                         .get("dataSet")
                         .traverse(mapper)
                         .readValueAs(new TypeReference<List<LeadTestData>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Failed to read test data from JSON", e);
        }
    }

    public static LeadTestData getTestDataByIndex(int index) {
        List<LeadTestData> allData = getAllTestData();
        if (index >= 0 && index < allData.size()) {
            return allData.get(index);
        } else {
            throw new IndexOutOfBoundsException("No test data at index: " + index);
        }
    }
}

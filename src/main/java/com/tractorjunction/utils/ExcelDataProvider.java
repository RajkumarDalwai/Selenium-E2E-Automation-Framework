package com.tractorjunction.utils;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

    @DataProvider(name = "endpointData")
    public Object[][] getEndpointData() {
        String filePath = System.getProperty("user.dir") + "src/main/resources/test-data/top_500_endpoints.xlsx";
        return ExcelReader.getTestData(filePath, "Endpoints"); // Sheet name as per your Excel
    }
}

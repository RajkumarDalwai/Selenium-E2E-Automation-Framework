package com.tractorjunction.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    // ✅ Existing method for matrix test data
    public static String[][] getTestData(String filePath, String sheetName) {
        String[][] data = null;

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new String[rowCount - 1][colCount]; // Exclude header row
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    data[i - 1][j] = formatter.formatCellValue(cell).trim();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    // ✅ New method for fetching multilingual state data
    public static List<String> getStateData(String filePath, String langKey) {
        List<String> stateList = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(file)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming first sheet
            Row headerRow = sheet.getRow(0);
            int langColumn = -1;

            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().trim().equalsIgnoreCase(langKey)) {
                    langColumn = cell.getColumnIndex();
                    break;
                }
            }

            if (langColumn == -1) {
                throw new RuntimeException("Language column not found: " + langKey);
            }

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null && row.getCell(langColumn) != null) {
                    String value = row.getCell(langColumn).getStringCellValue().trim();
                    stateList.add(value);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read state data for: " + langKey);
        }

        return stateList;
    }
}

package com.google.testdata;

import com.google.utils.Constants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by abryhas on 16.03.2016.
 */
public class TestUser {

    public TestUser() {
    }

    /**
     * @param number of desired user in the .xslx table
     */
    public String getEmail(int number) {
        return getUserData(number).get(Constants.XLSX_FIRST_CELL.getField());
    }

    public String getPassword(int number) {
        return getUserData(number).get(Constants.XLSX_SECOND_CELL.getField());
    }

    public String getFirstName(int number) {
        return getUserData(number).get(Constants.XLSX_THIRD_CELL.getField());
    }

    public String getLastName(int number) {
        return getUserData(number).get(Constants.XLSX_FOURTH_CELL.getField());
    }

    /**
     * Gets user data from .xslx file.
     * Returns data for single user from 'userNumber' row
     */
    private List<String> getUserData(int userNumber) {
        try {
            File userFile = new File(LocalPathes.USERS_XLSX.toString());
            FileInputStream fis = new FileInputStream(userFile);

            // Finds the workbook instance for XLSX file
            XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);

            // Returns first sheet from the XLSX workbook
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);

            // Get iterator to all the rows in current sheet
            Iterator<Row> rowIterator = mySheet.iterator();

            //2-dimensional array of all users
            List<List<String>> usersData = new ArrayList<List<String>>();

            //1-dimensional array of single user
            List<String> userData = new ArrayList<String>();

            Row row = mySheet.getRow(userNumber);

            // For given row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                userData.add(cell.getStringCellValue());
            }

            return userData;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}

package com.google.testdata;

/**
 * Created by abryhas on 12/04/2016.
 */
public enum LocalPathes {
    CHROMEDRIVER("C:/Selenium/chromedriver.exe"),
    FIREFOXDRIVER("C:/Selenium/wires-0.6.2-win.exe"),
    USERS_XLSX("D://googletest/src/test/resources/users.xlsx");

    private String field;

    LocalPathes(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return this.field;
    }
}

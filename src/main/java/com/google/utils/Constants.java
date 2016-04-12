package com.google.utils;

/**
 * Created by abryhas on 12/04/2016.
 */
public enum Constants {
    //the value of this one is 1 because an array for unread emails has 2 webelements for each email,
    //the second of which being the one needed.
    FIRST_UNREAD_EMAIL(1),

    XLSX_FIRST_CELL(0),
    XLSX_SECOND_CELL(1),
    XLSX_THIRD_CELL(2),
    XLSX_FOURTH_CELL(3),
    EMAIL_SUBJ_LENGTH(5),
    EMAIL_TEXT_LENGTH(10);

    private int field;

    Constants(int field) {
        this.field = field;
    }

    public int getField() {
        return this.field;
    }
}

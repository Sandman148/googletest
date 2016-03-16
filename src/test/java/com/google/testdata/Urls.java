package com.google.testdata;

/**
 * Created by abryhas on 16.03.2016.
 */
public enum Urls {
    GOOGLE_HOME("https://www.google.com.ua");

    private String field;

    Urls(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return this.field;
    }
}

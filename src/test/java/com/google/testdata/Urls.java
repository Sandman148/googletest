package com.google.testdata;

/**
 * Created by abryhas on 16.03.2016.
 */
public enum Urls {
    GOOGLE_HOME("https://www.google.com.ua"),
    GOOGLE_MAPS("https://www.google.com.ua/maps"),
    BLACKJACK("https://www.youtube.com/watch?v=ED7UkLYNkjY"),
    WHORES("http://i2.wp.com/www.thewideeyed.com/wp-content/uploads/2014/09/0082CropUltraBlackM-TEXT2.jpg");

    private String field;

    Urls(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return this.field;
    }
}

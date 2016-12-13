package com.google.utils;

/**
 * Created by abryhas on 12/04/2016.
 */
public enum Timeouts {
    COMMON_TIMEOUT(20),
    SHORT_MILLIS(2000),
    LONG_MILLIS(8000),
    BLACKJACK_TIMEOUT(45000);

    private long field;

    Timeouts(long field) {
        this.field = field;
    }

    public long getField() {
        return this.field;
    }
}

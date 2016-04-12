package com.google.testdata;

import com.google.utils.Constants;
import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by abryhas on 12/04/2016.
 */
public class TestEmail {

    public static String getSubject() {
        return RandomStringUtils.randomAlphabetic(Constants.EMAIL_SUBJ_LENGTH.getField()).toLowerCase();
    }

    public static String getText() {
        return RandomStringUtils.randomAlphabetic(Constants.EMAIL_TEXT_LENGTH.getField()).toLowerCase();
    }
}

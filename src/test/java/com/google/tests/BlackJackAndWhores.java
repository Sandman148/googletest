package com.google.tests;

import com.google.pages.BlackJackPage;
import com.google.pages.WhoresPage;
import com.google.testdata.Urls;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by abryhas on 04/04/2016.
 */
public class BlackJackAndWhores extends TestBase{

    private WebDriver driver;
    private BlackJackPage blackJackPage;
    private WhoresPage whoresPage;

    @Test
    public void blackJack() {
        driver = getDriver();
        driver.get(Urls.BLACKJACK.toString());
        blackJackPage = new BlackJackPage(driver);
        blackJackPage.fixedWait(45000); //for you to enjoy!
        Assert.assertTrue(blackJackPage.getTitle().contains("blackjack"), "That ain't true!!");
    }

    @Test
    public void whores() {
        driver = getDriver();
        driver.get(Urls.WHORES.toString());
        whoresPage = new WhoresPage(driver);
        whoresPage.fixedWait(10000); //for you to enjoy!
        Assert.assertTrue(whoresPage.getWhoresSrc().contains(".jpg"), "That ain't true!!");
    }


}

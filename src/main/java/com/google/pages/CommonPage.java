package com.google.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by abryhas on 11.03.2016.
 */
public abstract class CommonPage {
    protected WebDriver driver;

    protected CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void fixedWait(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(WebElement element) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        try {
            element.getSize(); // will invoke findElement
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void setTextToInputField(WebElement inp, String text) {
        waitForElementVisibility(inp);
        inp.click();
        inp.clear();
        inp.sendKeys(text);
    }

    public boolean isCheckboxSelected(WebElement element) {
        return element.getAttribute("aria-checked").contains("true");
    }

    public void selectCheckbox(WebElement element) {
        if (!isCheckboxSelected(element)) {
            element.click();
        }
    }
}

package com.miaus.yehor.mojam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

abstract class BasePage {
    private final WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }
    WebDriver getDriver(){
        return driver;
    }
    void switchToLastTab() {
        ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(String.valueOf(tabs2.get(tabs2.size()-1)));
    }
    void switchToFirstTab() {
        ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(String.valueOf(tabs2.get(0)));
    }
    void scrollToElement(By elem) {
        WebElement element = getDriver().findElement(elem);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    void waitPresenceOfElement(By locator, int waitTime) {
        WebDriverWait wait = (new WebDriverWait(getDriver(), waitTime));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    void waitPresenceOfElement(WebElement element, int waitTime) {
        WebDriverWait wait = (new WebDriverWait(getDriver(), waitTime));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    void scrollToBottom(By locator) {
        for(int i = 1000; i<100000; i = i+1000) {
            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
            jse.executeScript("scroll(0, " + i + ")");
            if (isElementPresent(locator)) {
                return;
            }
        }
    }
    private boolean isElementPresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception ignored) { }
        return false;
    }
    void waitForPageLoad(){
        isElementPresent(By.id("@111"));
    }

}

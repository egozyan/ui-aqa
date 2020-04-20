package com.miaus.yehor.mojam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpeningCasesPage extends BasePage {

    private final By OPEN_FAST_BUTTON = By.cssSelector(".case-item__open-case-fast-btn");
    private final By OPEN_REGULAR_BUTTON = By.cssSelector(".case-item__open-case-btn");
    private final By SELL_BUTTON = By.cssSelector("div.case-win-block__sell-item-btn");

    @FindBy(css = ".case-item__open-case-fast-btn") private WebElement buttonOpenFast;
    @FindBy(css = ".case-item__open-case-btn") private WebElement buttonOpenRegular;

    public OpeningCasesPage(WebDriver driver){
        super(driver);
    }
    public CaseContentPage openCaseFast(){
        scrollToElement(OPEN_FAST_BUTTON);
        Assert.assertTrue(buttonOpenFast.isDisplayed());
        Assert.assertEquals(buttonOpenFast.getText(), "БЫСТРО");
        buttonOpenFast.click();
        CaseContentPage caseContentPage = PageFactory.initElements(getDriver(), CaseContentPage.class);
        caseContentPage.waitForPageLoad();
        return caseContentPage;
    }
    public CaseContentPage openCaseRegular(){
        scrollToElement(OPEN_REGULAR_BUTTON);
        Assert.assertTrue(buttonOpenRegular.isDisplayed());
        Assert.assertEquals(buttonOpenRegular.getText(), "ОБЫЧНО");
        buttonOpenRegular.click();
        CaseContentPage caseContentPage = PageFactory.initElements(getDriver(), CaseContentPage.class);
        caseContentPage.waitPresenceOfElement(SELL_BUTTON, 15);
        return caseContentPage;
    }
}

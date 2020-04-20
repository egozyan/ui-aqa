package com.miaus.yehor.mojam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    private static final String PAGE_URL = "https://three.jcdev.ru/";
    private final By ANY_CASE = By.cssSelector("div.holder li.main-case.viewn-3");

    @FindBy(css = "div.user__logged-out > a") private WebElement fieldEnterUsingSteam;
    @FindBy(css = "div.modal-holder i") private WebElement closeIcon;

    public MainPage(WebDriver driver){
        super(driver);
    }
    public static MainPage open(WebDriver driver){
        driver.get(MainPage.PAGE_URL);
        return PageFactory.initElements(driver, MainPage.class);
    }
    public void closePopUp(){
        waitPresenceOfElement(closeIcon, 15);
        closeIcon.click();
    }
    private SteamCommunityPage enterUsingSteamAccount(){
        waitPresenceOfElement(fieldEnterUsingSteam, 10);
        fieldEnterUsingSteam.click();
        switchToLastTab();
        SteamCommunityPage steamCommunityPage = PageFactory.initElements(getDriver(), SteamCommunityPage.class);
        steamCommunityPage.waitForPageLoad();
        return steamCommunityPage;
    }
    public void logIn(String login, String password){
        SteamCommunityPage steamCommunityPage = enterUsingSteamAccount();
        steamCommunityPage.logInUsingSteamAccount(login, password);
        switchToFirstTab();
        waitForPageLoad();
    }
    public OpeningCasesPage selectAnyCase(){
        waitPresenceOfElement(ANY_CASE, 10);
        scrollToElement(ANY_CASE);
        waitPresenceOfElement(By.cssSelector("div.holder li.main-case.viewn-3"), 10);
        WebElement randomCase = getDriver().findElement(By.cssSelector("div.holder li.main-case.viewn-3"));
        randomCase.click();
        OpeningCasesPage openingCasesPage =  PageFactory.initElements(getDriver(), OpeningCasesPage.class);
        openingCasesPage.waitForPageLoad();
        return openingCasesPage;
    }
}

package com.miaus.yehor.mojam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SteamCommunityPage extends BasePage {

    @FindBy(id = "steamAccountName") private WebElement fieldSteamAccountName;
    @FindBy(id = "steamPassword") private WebElement fieldPassword;
    @FindBy(id = "imageLogin") private WebElement fieldSignIn;

    public SteamCommunityPage(WebDriver driver){
        super(driver);
    }
    private void setTextAccountName(String text){
        fieldSteamAccountName.sendKeys(text);
        Assert.assertEquals(fieldSteamAccountName.getAttribute("value"), text);
    }
    private void setTextPassword(String text){
        fieldPassword.sendKeys(text);
        Assert.assertEquals(fieldPassword.getAttribute("value"), text);
    }
    private void signInUsingSteam(){
        fieldSignIn.click();
    }
    void logInUsingSteamAccount(String accountName, String password){
        setTextAccountName(accountName);
        setTextPassword(password);
        signInUsingSteam();
    }
}

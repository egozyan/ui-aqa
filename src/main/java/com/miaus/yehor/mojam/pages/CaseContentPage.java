package com.miaus.yehor.mojam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaseContentPage extends BasePage {

    private static final String CASE_SECOND_IMAGE = "//*[@id='lazy-list']//img[contains(@src,'%s')]";
    private static final String CASE_SECOND_NAME = "//*[@id='lazy-list']//img[contains(@src,'%s')]/../following-sibling::div[@class = 'case-items__item-name']";
    private static final String CASE_SECOND_TITLE = "//*[@id='lazy-list']//img[contains(@src,'%s')]/../following-sibling::div[@class = 'case-items__item-title']";

    @FindBy (css = "img.case-win-block__img") private WebElement caseImage;
    @FindBy (css = ".case-win-block__type") private WebElement caseTitle;
    @FindBy (css = ".case-win-block__name") private WebElement caseName;

    public CaseContentPage(WebDriver driver) {
        super(driver);
    }

    public String getCaseImage(){
        String src = caseImage.getAttribute("src");
        int length = src.length();
        return src.substring(0, length - 11).replace("https:", "");
    }
    public String getCaseSecondImage(String itemName){
        WebElement element = getDriver().findElement(By.xpath(String.format(CASE_SECOND_IMAGE, itemName)));
        String src = element.getAttribute("src");
        int length = src.length();
        return src.substring(0, length - 11).replace("https:", "");
    }
    public String getCaseTitle(){
        return caseTitle.getText();
    }
    public String getCaseSecondTitle(String itemName){
        WebElement element = getDriver().findElement(By.xpath(String.format(CASE_SECOND_NAME, itemName)));
        return element.getText();
    }
    public String getCaseName(){
        return caseName.getText();
    }
    public String getCaseSecondName(String itemName){
        WebElement element = getDriver().findElement(By.xpath(String.format(CASE_SECOND_TITLE, itemName)));
        return element.getText();
    }
    public void scrollToContentCase(String itemMame){
        By element = By.xpath(String.format(CASE_SECOND_IMAGE, itemMame));
        scrollToBottom(element);
    }
}

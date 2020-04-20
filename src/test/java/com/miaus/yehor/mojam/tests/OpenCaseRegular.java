package com.miaus.yehor.mojam.tests;
import com.miaus.yehor.mojam.model.Case;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.miaus.yehor.mojam.pages.CaseContentPage;
import com.miaus.yehor.mojam.pages.MainPage;
import com.miaus.yehor.mojam.pages.OpeningCasesPage;

public class OpenCaseRegular extends BaseTest{

    private final String LOGIN = "egozyan";
    private final String PASSWORD = "n5rPB..fh(5QLg)";

    @Test
    public void openCaseRegular() {
        MainPage mainPage = MainPage.open(getDriver());
        mainPage.closePopUp();
        mainPage.logIn(LOGIN, PASSWORD);
        OpeningCasesPage openingCasesPage = mainPage.selectAnyCase();
        CaseContentPage caseContentPage = openingCasesPage.openCaseRegular();
        Case expectedCase = new Case(caseContentPage.getCaseImage(), caseContentPage.getCaseTitle(), caseContentPage.getCaseName());
        caseContentPage.scrollToContentCase(caseContentPage.getCaseImage());
        Case contentCase = new Case(caseContentPage.getCaseSecondImage(caseContentPage.getCaseImage()),
                caseContentPage.getCaseSecondTitle(caseContentPage.getCaseImage()), caseContentPage.getCaseSecondName(caseContentPage.getCaseImage()));
        System.out.println(expectedCase.getImage() + " " + expectedCase.getName() + " " + expectedCase.getTitle());
        System.out.println(contentCase.getImage() + " " + contentCase.getName() + " " + contentCase.getTitle());
        Assert.assertEquals(expectedCase.getImage(),contentCase.getImage());
        Assert.assertEquals(expectedCase.getName(),contentCase.getName());
        Assert.assertEquals(expectedCase.getTitle(),contentCase.getTitle());
    }
}

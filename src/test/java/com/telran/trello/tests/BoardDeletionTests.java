package com.telran.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().login();
        }
    }

    @Test
    public void testBoardDeletionFromHeader() throws InterruptedException {
        int before = app.getBoard().getBoardsCount();
        System.out.println(before);
        app.getBoard().clickOnBoard();

        if (!app.getBoard().isElementPresent(By.cssSelector(".board-menu-header-title"))) {
            app.getBoard().click(By.cssSelector(".js-show-sidebar"));
            app.getBoard().clickOnThreePoints();
            app.getBoard().closeBoard();
            app.getBoard().closeAgreeButton();
            app.getBoard().pause(5000);
            app.getHeader().returnToHomePage();
        } else {
            app.getBoard().clickOnThreePoints();
            app.getBoard().closeBoard();
            app.getBoard().closeAgreeButton();
            app.getBoard().pause(5000);
            app.getHeader().returnToHomePage();
        }

        int after = app.getBoard().getBoardsCount();
        System.out.println(after);
        Assert.assertEquals(after, before - 1);
    }

    @Test
    public void testFirstBoardDeletion1() throws InterruptedException {
        app.getBoard().clickOnBoard();
        app.getBoard().clickOnThreePoints();
        app.getBoard().closeBoard();
        app.getBoard().closeAgreeButton();
        app.getBoard().permanentlyDeleteBoard();
        app.getHeader().returnToHomePage();
        app.getBoard().pause(10000);
    }

}

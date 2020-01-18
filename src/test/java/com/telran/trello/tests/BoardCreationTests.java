package com.telran.trello.tests;

import com.telran.trello.model.BoardData;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().login();
        }
    }

    @Test
    public void testBoardCreationFromHeader() throws InterruptedException {
        int before = app.getBoard().getBoardsCount();
        app.getHeader().clickOnPlusButton();
        app.getBoard().selectCreateBoardFromDropDown();
        app.getBoard().fillBoardForm(new BoardData("qa22" + System.currentTimeMillis()));
        app.getBoard().confirmBoardCreation();
        app.getBoard().pause(5000);
        app.getHeader().returnToHomePage();

        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }

    @Test
    public void testBoardCreationFromHomePage() throws InterruptedException {
        app.getBoard().clickOnCreateButton();
        app.getBoard().fillBoardForm(new BoardData("qa22" + System.currentTimeMillis()));
        app.getBoard().confirmBoardCreation();
        app.getBoard().pause(5000);
        app.getHeader().returnToHomePage();
    }

    @AfterClass
    public void postActions() throws InterruptedException {
        int boardsCount = app.getBoard().getBoardsCount();
        while (boardsCount > 4) {
            app.getBoard().deleteBoard();
            boardsCount = app.getBoard().getBoardsCount();
        }
    }


}
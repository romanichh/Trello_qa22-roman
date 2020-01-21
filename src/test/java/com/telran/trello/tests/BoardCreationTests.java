package com.telran.trello.tests;

import com.telran.trello.model.BoardData;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> boardList() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/boardsPositiveCsv.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new BoardData().setBoardName(split[0])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().login();
        }
    }

    @Test(dataProvider = "boardList")
    public void testBoardCreationFromHeaderFromCSV(BoardData board) throws InterruptedException {
        int before = app.getBoard().getBoardsCount();
        app.getHeader().clickOnPlusButton();
        app.getBoard().selectCreateBoardFromDropDown();
        app.getBoard().fillBoardForm(board);
        app.getBoard().confirmBoardCreation();
        app.getBoard().pause(5000);
        app.getHeader().returnToHomePage();

        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }

    @Test
    public void testBoardCreationFromHeader() throws InterruptedException {
        int before = app.getBoard().getBoardsCount();
        app.getHeader().clickOnPlusButton();
        app.getBoard().selectCreateBoardFromDropDown();
        app.getBoard().fillBoardForm(new BoardData().setBoardName("qa22" + System.currentTimeMillis()));
        app.getBoard().confirmBoardCreation();
        app.getBoard().pause(5000);
        app.getHeader().returnToHomePage();

        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }

    @Test
    public void testBoardCreationFromHomePage() throws InterruptedException {
        app.getBoard().clickOnCreateButton();
        app.getBoard().fillBoardForm(new BoardData().setBoardName("qa22" + System.currentTimeMillis()));
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
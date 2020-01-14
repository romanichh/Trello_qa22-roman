package com.telran.trello.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {
    HeaderHelper header = new HeaderHelper(wd);

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void clickOnCreateButton() {
        click(By.cssSelector(".board-tile.mod-add"));

    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void fillBoardForm(String boardName) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), boardName);
    }

    public void selectCreateBoardFromDropDown() {
        click(By.xpath("//span[@name='board']/..//p"));
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public void closeAgreeButton() {
        click(By.cssSelector("[value='Close']"));
    }

    public void closeBoard() {
        click(By.xpath("//*[@class='board-menu-navigation-item-link js-close-board']"));
    }

    public void clickOnThreePoints() {
        click(By.xpath("//*[@class='icon-sm icon-overflow-menu-horizontal board-menu-navigation-item-link-icon']"));
    }

    public void clickOnBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li[1]"));
    }

    public void deleteBoard() throws InterruptedException {
        clickOnBoard();
        clickOnThreePoints();
        closeBoard();
        closeAgreeButton();
        pause(5000);
        header.returnToHomePage();
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirmCloseBoard();
    }

    public void confirmCloseBoard() {
        click(By.cssSelector(".js-confirm[type='submit']"));
    }



}

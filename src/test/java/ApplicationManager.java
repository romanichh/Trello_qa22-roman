import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    WebDriver wd;

    public void init() {
        String browser = System.getProperty("browser", BrowserType.CHROME);
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
    }

    public void stop() {
        wd.quit();
    }

    public void maximize() {
        wd.manage().window().maximize();
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void pause(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public void fillLoginForm(String user, String pwd) throws InterruptedException {
        //username
        type(By.id("user"), user);
        pause(3000);
        click(By.id("login"));
        //email
        type(By.id("username"), "romich87@gmail.com");
        click(By.id("login-submit"));
        //password
        type(By.id("password"), pwd);
        click(By.id("login-submit"));
        pause(20000);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void confirmLogin() {
        click(By.id("login"));
    }

    public void clickLoginLink() throws InterruptedException {
        maximize();
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isAvatarPresentOnHeader() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void login() throws InterruptedException {
        clickLoginLink();
        fillLoginForm("romich87", "romanich1987");
        Assert.assertTrue(isAvatarPresentOnHeader());
    }

    public void returnToHomePage() throws InterruptedException {
        click(By.name("house"));
        click(By.name("house"));
        pause(10000);
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

    public void clickOnPlusButton() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));

    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public void logout() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
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
        returnToHomePage();
    }

    public void clickLaterButton() {
        click(By.cssSelector("[data-test-id='show-later-button']"));
    }

    public int getTeamsCount() {
        return wd.findElements(By.cssSelector("[data-test-id^=home-team-tab-section]")).size();
    }

    public void submitTeamCreation() {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }

    public void closeInviteToTheTeamForm() {
        click(By.cssSelector("[name='close']"));
    }

    public void fillTeamCreationForm(String teamName, String teamDescr) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.cssSelector("[id$=description]"), teamDescr);
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public void submitDeletion() {
        click(By.cssSelector("[value='Delete Forever']"));
    }

    public void clickOnDeleteTeamButton() {
        click(By.xpath("//*[@class='quiet-button']"));
    }

    public void clickOnTeamSettings() {
        click(By.cssSelector("[class^=icon-gear]"));
    }

    public void clickOnTheTeam() {
        click(By.cssSelector("[data-test-id^=home-team-tab-section]"));
    }

    public void changeTeamName() {
        click(By.cssSelector("[name='displayName']"));
        wd.findElement(By.cssSelector("[name='displayName']")).clear();
        wd.findElement(By.cssSelector("[name='displayName']")).sendKeys("Test");
        //click on save button
        click(By.cssSelector(".primary.wide.js-submit-profile"));
    }

    public void clickOnEditTeamProfileButton() {
        click(By.cssSelector(".js-edit-profile"));
    }

    private String getText(By Text) {
        return wd.findElement(Text).getText();
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirmCloseBoard();
    }

    public void confirmCloseBoard() {
        click(By.cssSelector(".js-confirm[type='submit']"));
    }

    public void clickOnCreateButton() {
        click(By.cssSelector(".board-tile.mod-add"));

    }

    @AfterClass
    public void postActions() throws InterruptedException {
        int boardsCount = getBoardsCount();
        while (boardsCount > 4) {
            deleteBoard();
            boardsCount = getBoardsCount();
        }
    }
}

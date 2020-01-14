import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.isAvatarPresentOnHeader()) {
            app.login();
        }
    }

    @Test
    public void testBoardDeletionFromHeader() throws InterruptedException {
        int before = app.getBoardsCount();
        System.out.println(before);
        app.clickOnBoard();

        if (!app.isElementPresent(By.cssSelector(".board-menu-header-title"))) {
            app.click(By.cssSelector(".js-show-sidebar"));
            app.clickOnThreePoints();
            app.closeBoard();
            app.closeAgreeButton();
            app.pause(5000);
            app.returnToHomePage();
        } else {
            app.clickOnThreePoints();
            app.closeBoard();
            app.closeAgreeButton();
            app.pause(5000);
            app.returnToHomePage();
        }

        int after = app.getBoardsCount();
        System.out.println(after);
        Assert.assertEquals(after, before - 1);
    }

    @Test
    public void testFirstBoardDeletion1() throws InterruptedException {
        app.clickOnBoard();
        app.clickOnThreePoints();
        app.closeBoard();
        app.closeAgreeButton();
        app.permanentlyDeleteBoard();
        app.returnToHomePage();
        app.pause(10000);
    }

}

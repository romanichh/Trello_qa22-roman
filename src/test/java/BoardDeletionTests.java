import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            login();
        }
    }

    @Test
    public void testBoardDeletionFromHeader() throws InterruptedException {
        int before = getBoardsCount();
        System.out.println(before);
        clickOnBoard();

        if (!isElementPresent(By.cssSelector(".board-menu-header-title"))) {
            click(By.cssSelector(".js-show-sidebar"));
            clickOnThreePoints();
            closeBoard();
            closeAgreeButton();
            pause(5000);
            returnToHomePage();
        } else {
            clickOnThreePoints();
            closeBoard();
            closeAgreeButton();
            pause(5000);
            returnToHomePage();
        }

        int after = getBoardsCount();
        System.out.println(after);
        Assert.assertEquals(after, before - 1);
    }

    @Test
    public void testFirstBoardDeletion1() throws InterruptedException {
        clickOnBoard();
        clickOnThreePoints();
        closeBoard();
        closeAgreeButton();
        permanentlyDeleteBoard();
        returnToHomePage();
        pause(10000);
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirmCloseBoard();
    }

    public void confirmCloseBoard() {
        click(By.cssSelector(".js-confirm[type='submit']"));
    }
}

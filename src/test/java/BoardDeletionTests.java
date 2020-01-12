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
        if (!isElementPresent(By.xpath("//*[@class='board-header-btn hide js-map-btn']"))) {
            clickOnThreePoints();
            closeBoard();
            closeAgreeButton();
            pause(5000);
            returnToHomePage();
        }
        if (isElementPresent(By.xpath("//*[@class='board-header-btn hide js-map-btn']"))) {
            click(By.cssSelector(".board-header-btn.mod-show-menu.js-show-sidebar"));
            closeBoard();
            closeAgreeButton();
            pause(5000);
            returnToHomePage();
        }


        int after = getBoardsCount();
        System.out.println(after);
        Assert.assertEquals(after, before - 1);
    }
}

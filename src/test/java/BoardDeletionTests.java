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
//        clickOnShowMenuButton();
        clickOnThreePoints();
        closeBoard();
        closeAgreeButton();
        pause(5000);
        returnToHomePage();

        int after = getBoardsCount();
        System.out.println(after);
        Assert.assertEquals(after, before - 1);
    }

    //    public void clickOnShowMenuButton() {
//        click(By.xpath("//*[@class='board-header-btn mod-show-menu js-show-sidebar']"));
//    }

}
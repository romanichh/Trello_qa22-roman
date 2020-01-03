import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            login();
        }
    }

    @Test
    public void testBoardCreationFromHeader() throws InterruptedException {
        int before = getBoardsCount();
        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        fillBoardForm("qa22" + System.currentTimeMillis());
        confirmBoardCreation();
        pause(5000);
        returnToHomePage();

        int after = getBoardsCount();
        Assert.assertEquals(after, before + 1);
    }


}
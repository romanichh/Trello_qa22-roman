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
        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        fillBoardForm("qa22" + System.currentTimeMillis());
        confirmBoardCreation();
        pause(5000);
        returnToHomePage();
    }


}
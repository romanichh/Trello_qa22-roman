import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase2 {
    @BeforeMethod
    public void Preconditions() throws InterruptedException {
        if (isAvatarPresentOnHeader()) {
            createBoard();
        }
    }

    public void createBoard() throws InterruptedException {
        if (isAvatarPresentOnHeader()) {
            click(By.cssSelector(".board-tile.mod-add"));

            wd.findElement(By.cssSelector("[data-test-id='create-board-title-input']")).sendKeys("Test");

            click(By.xpath("//*[@title='green']"));
            click(By.cssSelector("[data-test-id='create-board-submit-button']"));
            Thread.sleep(5000);
            click(By.cssSelector("[data-test-id='header-member-menu-button']"));
            click(By.cssSelector("[data-test-id='header-member-menu-logout']"));

        }
    }


    @Test
    public void testLogin() throws InterruptedException {
        //clickLogin
        clickLoginLink();
        fillLoginForm("romich87", "romanich1987");
        Assert.assertTrue(isAvatarPresentOnHeader());
    }

    @Test
    public void testLoginAgain() throws InterruptedException {
        //clickLogin
        clickLoginLink();
        fillLoginForm("romich87", "romanich1987");
        Assert.assertTrue(isAvatarPresentOnHeader());
    }


}

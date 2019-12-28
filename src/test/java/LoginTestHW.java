import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase2 {
    @BeforeMethod
    public void ensurePreconditions() {
        if (isAvatarPresentOnHeader()) {
            logout();
        }
    }

    public void logout() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
    }

    @Test
    public void testLogin() throws InterruptedException {
        //clickLogin
        clickLoginLink();
        fillLoginForm("romich87", "romanich1987");
        Assert.assertTrue(isAvatarPresentOnHeader());
    }


    @Test(enabled = false)
    public void negativeTestLogin() throws InterruptedException {
        //clickLogin
        clickLoginLink();
        fillLoginForm("romich87", "romanich19");
        pause(8000);
        Assert.assertTrue(isErrorPresent());
        Assert.assertTrue(!isAvatarPresentOnHeader());
    }

    public boolean isErrorPresent() {
        return isElementPresent(By.id("login-error"));
    }


    @Test
    public void testLoginAgain() throws InterruptedException {
        //clickLogin
        clickLoginLink();
        fillLoginForm("romich87", "romanich1987");
        Assert.assertTrue(isAvatarPresentOnHeader());
    }

}



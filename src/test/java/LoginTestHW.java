import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (isAvatarPresentOnHeader()) {
            logout();
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



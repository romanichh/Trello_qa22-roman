import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase2 {

    @Test
    public void testLogin() throws InterruptedException {
        //clickLogin
        clickLoginLink();
        fillLoginForm();
        Assert.assertTrue(isAvatarPresentOnHeader());
    }

}



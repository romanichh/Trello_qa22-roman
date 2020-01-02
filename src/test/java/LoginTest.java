import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() throws InterruptedException {
        clickLoginLink();
    }
}

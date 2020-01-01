import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void testLogin() throws InterruptedException {
        clickLoginLink();
    }

    public void clickLoginLink() throws InterruptedException {
        maximize();
        click(By.cssSelector("[href='/login']"));
        type(By.id("user"), "romich87");
        pause(5000);

        if (wd.findElement(By.id("password")).isDisplayed()){
            //fill password
            type(By.id("password"), "romanich1987");
        }
        click(By.id("login"));
        if (isElementPresent(By.id("login-submit"))){
            click(By.id("login-submit"));

            type(By.id("username"), "romich87@gmail.com");
            click(By.id("login-submit"));
            type(By.id("password"), "romanich1987");
            click(By.id("login-submit"));
            pause(20000);
        }
    }


}

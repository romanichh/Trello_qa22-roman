import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.isAvatarPresentOnHeader()) {
            app.login();
        }
    }

    @Test
    public void modificationTeamName() throws InterruptedException {
        app.clickOnTheTeam();
        app.clickOnTeamSettings();
        app.clickOnEditTeamProfileButton();
        app.changeTeamName();
        app.returnToHomePage();
//        clickOnTheTeam();
//        clickOnTeamSettings();
//        String name = getText(By.cssSelector(".u-inline"));
//        System.out.println(name);

    }


}

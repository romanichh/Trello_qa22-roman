import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.isAvatarPresentOnHeader()) {
            app.login();
        }
    }

    @Test
    public void teamCreationTestFromHeader() throws InterruptedException {
        int countCountbefore = app.getTeamsCount();
        app.clickOnPlusButton();
        app.selectCreateTeamFromDropDown();
        app.fillTeamCreationForm("teamName", "teamDescr");
        app.submitTeamCreation();
//        if (isElementPresent(By.cssSelector("[name='close']"))) {
//            closeInviteToTheTeamForm();
//        }
        app.clickLaterButton();
        int TeamCountAfter = app.getTeamsCount();
        app.returnToHomePage();
        Assert.assertEquals(TeamCountAfter, countCountbefore + 1);
        app.pause(5000);
    }

}

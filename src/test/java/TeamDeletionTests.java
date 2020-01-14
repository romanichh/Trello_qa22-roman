import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.isAvatarPresentOnHeader()) {
            app.login();
        }
    }


    @Test
    public void deletionBoardTests() {
        int countCountbefore = app.getTeamsCount();
        app.clickOnTheTeam();
        app.clickOnTeamSettings();
        app.clickOnDeleteTeamButton();
        app.submitDeletion();
        int TeamCountAfter = app.getTeamsCount();
        Assert.assertEquals(TeamCountAfter, countCountbefore - 1);
    }


}

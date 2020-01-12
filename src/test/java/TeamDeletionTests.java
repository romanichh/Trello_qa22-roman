import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            login();
        }
    }


    @Test
    public void deletionBoardTests() {
        int countCountbefore = getTeamsCount();
        clickOnTheTeam();
        clickOnTeamSettings();
        clickOnDeleteTeamButton();
        submitDeletion();
        int TeamCountAfter = getTeamsCount();
        Assert.assertEquals(TeamCountAfter, countCountbefore - 1);
    }


}

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            login();
        }
    }

    @Test
    public void teamCreationTestFromHeader() throws InterruptedException {
        int countCountbefore = getTeamsCount();
        clickOnPlusButton();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("teamName", "teamDescr");
        submitTeamCreation();
//        if (isElementPresent(By.cssSelector("[name='close']"))) {
//            closeInviteToTheTeamForm();
//        }
        clickLaterButton();
        int TeamCountAfter = getTeamsCount();
        returnToHomePage();
        Assert.assertEquals(TeamCountAfter, countCountbefore + 1);
        pause(5000);
    }

}

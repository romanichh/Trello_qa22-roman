import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            login();
        }
    }

    @Test
    public void modificationTeamName() throws InterruptedException {
        clickOnTheTeam();
        clickOnTeamSettings();
        clickOnEditTeamProfileButton();
        changeTeamName();
        returnToHomePage();
//        clickOnTheTeam();
//        clickOnTeamSettings();
//        String name = getText(By.cssSelector(".u-inline"));
//        System.out.println(name);

    }

    public void changeTeamName() {
        click(By.cssSelector("[name='displayName']"));
        wd.findElement(By.cssSelector("[name='displayName']")).clear();
        wd.findElement(By.cssSelector("[name='displayName']")).sendKeys("Test");
        //click on save button
        click(By.cssSelector(".primary.wide.js-submit-profile"));
    }

    public void clickOnEditTeamProfileButton() {
        click(By.cssSelector(".js-edit-profile"));
    }

    private String getText(By Text) {
        return wd.findElement(Text).getText();
    }


}

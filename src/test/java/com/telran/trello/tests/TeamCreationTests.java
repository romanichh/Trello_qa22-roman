package com.telran.trello.tests;

import com.telran.trello.model.TeamData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {


    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().login();
        }
    }

    @Test(dataProvider = "validTeamsCSV", dataProviderClass = DataProviders.class)
    public void teamCreationTestFromHeaderCSV(TeamData team) throws InterruptedException {
        int countCountBefore = app.getTeam().getTeamsCount();
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(team);
        app.getTeam().submitTeamCreation();
        app.getTeam().clickLaterButton();
        app.getHeader().returnToHomePage();
        int TeamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(TeamCountAfter, countCountBefore + 1);
        app.getTeam().pause(5000);
    }

    @Test(dataProvider = "validTeams", dataProviderClass = DataProviders.class)
    public void teamCreationTestFromHeaderWithDP(String teamName, String teamDescr) throws InterruptedException {
        int countCountBefore = app.getTeam().getTeamsCount();
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(new TeamData().withTeamName(teamName).withTeamDescr(teamDescr));
        app.getTeam().submitTeamCreation();
        app.getTeam().clickLaterButton();
        app.getHeader().returnToHomePage();
        int TeamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(TeamCountAfter, countCountBefore + 1);
        app.getTeam().pause(5000);
    }

    @Test
    public void teamCreationTestFromHeader() throws InterruptedException {
        int countCountBefore = app.getTeam().getTeamsCount();
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(new TeamData().withTeamName("teamName").withTeamDescr("teamDescr"));
        app.getTeam().submitTeamCreation();
        app.getTeam().clickLaterButton();
        app.getHeader().returnToHomePage();
        int TeamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(TeamCountAfter, countCountBefore + 1);
        app.getTeam().pause(5000);
    }

    @Test
    public void teamCreationTestFromHeaderWhithNameOnly() throws InterruptedException {
        int countCountBefore = app.getTeam().getTeamsCount();
        app.getHeader().clickOnPlusButton();
        app.getTeam().selectCreateTeamFromDropDown();
        app.getTeam().fillTeamCreationForm(new TeamData().withTeamName("teamName"));
        app.getTeam().submitTeamCreation();
        app.getTeam().clickLaterButton();
        app.getHeader().returnToHomePage();
        int TeamCountAfter = app.getTeam().getTeamsCount();
        Assert.assertEquals(TeamCountAfter, countCountBefore + 1);
        app.getTeam().pause(5000);
    }

}

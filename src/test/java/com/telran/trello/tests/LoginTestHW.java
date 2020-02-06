package com.telran.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().logout();
        }
    }

    @Test
    public void testLogin() throws InterruptedException {
        //clickLogin
        app.getSession().clickLoginLink();
        app.getSession().fillLoginForm("romich87", "romanich1987");
        app.getSession().pause(20000);
        Assert.assertTrue(app.getSession().isAvatarPresentOnHeader());
    }

    @Test
    public void testLoginAgain() throws InterruptedException {
        //clickLogin
        app.getSession().clickLoginLink();
        app.getSession().fillLoginForm("romich87", "romanich1987");
        Assert.assertTrue(app.getSession().isAvatarPresentOnHeader());
    }

}



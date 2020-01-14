package com.telran.trello.tests;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(enabled = false)
    public void testLogin() throws InterruptedException {
        app.getSession().clickLoginLink();
    }
}

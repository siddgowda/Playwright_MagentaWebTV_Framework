package com.qa.magenta.tests;

import com.qa.magenta.AppConstants.AppConstants;
import com.qa.magenta.base.BaseTest;
import com.qa.magenta.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MagentaLoginPageTest extends BaseTest {


    @Test(priority = 1)
    public void loginPageNavigationTest() throws InterruptedException {
        loginpage = homepage.navigateToLoginPage();
        String loginpagetitle = loginpage.getLoginPageTitle();
        Assert.assertEquals(loginpagetitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void VerifyEnteredUserName() throws InterruptedException {
       Boolean VerifyEnteredUserName =  loginpage.enterUserName(prop.getProperty("username"));
       Assert.assertTrue(VerifyEnteredUserName);
    }
}

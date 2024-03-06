package com.qa.magenta.tests;

import com.microsoft.playwright.Page;
import com.qa.magenta.AppConstants.AppConstants;
import com.qa.magenta.base.BaseTest;
import com.qa.magenta.factory.PlaywrightFactory;
import com.qa.magenta.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MagentaHomePageTest extends BaseTest {

    @Test(priority = 0)
    public void homePageTitleTest()
    {
        //logger.info("homePageTitleTest Started");
        String actualTitle = homepage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
    }

    @Test(priority = 1)
    public void homePageURLTest()
    {
        //logger.info("homePageURLTest Started");
        String actualURL = homepage.getHomePageURL();
        Assert.assertEquals(actualURL, prop.getProperty("url").trim());
    }

    @Test(priority = 2)
    public void verifyClickOnSportTest(){
        //logger.info("verifyClickOnSportTest Started");
        String sportURL = homepage.clickOn_Sport();
        Assert.assertEquals(sportURL,"https://web.magentatv.de/sport" );
    }


}

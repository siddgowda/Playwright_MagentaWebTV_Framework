package com.qa.magenta.base;

import com.microsoft.playwright.Page;
import com.qa.magenta.factory.PlaywrightFactory;
import com.qa.magenta.pages.HomePage;
import com.qa.magenta.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;

    protected Properties prop;

    protected HomePage homepage;
    protected LoginPage loginpage;
    //public Logger logger;


    @BeforeTest
    public void setUp() throws IOException {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();

        page = pf.initBrowser(prop);
        homepage = new HomePage(page);
        //logger = LogManager.getLogger(this.getClass());
    }


    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }
}

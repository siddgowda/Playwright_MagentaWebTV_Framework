package com.qa.magenta.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    // 1. String locators

    private String menu_TvProgram = "TV-Programm";  ////a[@title="TV-Programm"]
    private String menu_Megathek = "Megathek";
    private String menu_Film = "Film";
    private String menu_Sport = "#MENU-TEXT-6";
    private String  loininLink = "#MENU-LOGIN";

    //2 . page constructor
    public HomePage(Page page) {
        this.page = page;
    }

    //3. page action/methods

    public String getHomePageTitle() {
        String title = page.title();
        System.out.println("Magenta home page title " + title);
        return title;
    }

    public String getHomePageURL() {
        String url =  page.url();
        System.out.println("Magenta home page URL " + url);
        return url;
    }

    public String clickOn_Sport() {
        page.locator(menu_Sport).click();
        String url =  page.url();
        System.out.println("Magenta sport page url " + url);
        return url;
    }

    public LoginPage navigateToLoginPage() throws InterruptedException // Page chaining concept, lining the loginpage from home page
                                              // becaue the login link is exists in home page
    {
        page.click(loininLink);
        Thread.sleep(5000);
        return new LoginPage(page);
    }

}

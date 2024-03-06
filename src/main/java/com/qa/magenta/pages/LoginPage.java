package com.qa.magenta.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private String username = "#username";
    private String password = "#pw_pwd";
    private String weiterbutton = "#pw_submit";
    private String loginbutton = "//button[@id=\"pw_submit\"]";
    private String verifyUserName = "Telekom Login Passwort eingeben";


    public LoginPage(Page page)
    {
        this.page = page;
    }

    //page actions

    public String getLoginPageTitle()
    {
        String loginTitle = page.title();
        return loginTitle;
    }

    public boolean enterUserName(String getUserName) throws InterruptedException {
        Thread.sleep(5000);
        page.fill(username,getUserName);
        page.click(weiterbutton);
        String verifyEnterUserName = page.getByText(verifyUserName).textContent();
        if(verifyEnterUserName.equals(verifyUserName))
        {
            return true;
        }
        return false;
    }
}

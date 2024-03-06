package com.qa.magenta.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;

    BrowserContext browserContext;

    static Page  page;

    Properties prop;

    //To pass any browser
    public Page initBrowser(Properties prop) {

        String browserName = prop.getProperty("browser").trim();

        System.out.println("Browser name is " + browserName);

        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
                break;

            default:
                break;
        }

        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));

        page = browserContext.newPage();

        page.navigate(prop.getProperty("url").trim());

        page.locator("//button[contains(text(),'Alle akzeptieren')]").click();

        return page; // Retrning the page, because method is Page class.

    }
    /*
    This method is used to initialize propertis from config class
     */

    public Properties init_prop() throws IOException {

        FileInputStream ip = new FileInputStream("./resources/config/config.properties");
        prop = new Properties();
        prop.load(ip);
        return prop;

    }

    /**
     * take screenshot
     *
     */

    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        //getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));

        byte[] buffer = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        String base64Path = Base64.getEncoder().encodeToString(buffer);

        return base64Path;
    }
}

package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public Page page;
    private Playwright playwright;
    private Browser browser;
@BeforeMethod
    public void setUp(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://think-and-get-it-frontend.onrender.com/home");
    }

//@AfterClass
//    public void close(){
//        page.pause();
//        browser.close();
//        playwright.close();
//    }
}

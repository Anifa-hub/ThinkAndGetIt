package base;

import Page.Login;
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

    protected static final String BASE_URL = "https://think-and-get-it-frontend.onrender.com";
    protected static final String EMAIL = "admin@thinkandgetit.com";
    protected static final String PASSWORD = "Admin@123456";

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.setDefaultTimeout(60000);
        page.navigate(BASE_URL, new Page.NavigateOptions().setTimeout(90000));

        if (autoLogin()) {
            new Login(page).login(EMAIL, PASSWORD);
        }
    }

    protected boolean autoLogin() {
        return true;
    }

@AfterClass
   public void close(){
       page.close();
       browser.close();
       playwright.close();
   }
}

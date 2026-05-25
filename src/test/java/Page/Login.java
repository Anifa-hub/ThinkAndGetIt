package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.regex.Pattern;


public class Login {
    Page page;

    public Login(Page page) {
        this.page = page;
    }

    String loginUrl = "https://think-and-get-it-frontend.onrender.com/login";
    String emailInput = "input[type='email']";
    String passwordInput = "input[type='password']";
    String signInButton = "button[type='submit']";
    String heading = "h1";
    String toastMessage = "[data-rht-toaster] div";
    String registerLink = "a[href='/register']";
    String accountMenu = "header div.relative.group";

    public void openLoginPage() {
        page.navigate(loginUrl, new Page.NavigateOptions().setTimeout(60000));
        page.locator(emailInput).waitFor();
    }

    public void enterEmail(String email) {
        page.fill(emailInput, email);
    }

    public void enterPassword(String password) {
        page.fill(passwordInput, password);
    }

    public void clickSignIn() {
        page.click(signInButton);
    }

    public void login(String email, String password) {
        openLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
        page.waitForURL(Pattern.compile("/home"),
                new Page.WaitForURLOptions().setTimeout(60000));
    }

    public Locator getHeading() {
        return page.locator(heading);
    }

    public Locator getToastMessage() {
        return page.locator(toastMessage).first();
    }

    public void clickRegisterLink() {
        page.click(registerLink);
    }
    public Locator getAccountMenu() {
        return page.locator(accountMenu);
    }
}

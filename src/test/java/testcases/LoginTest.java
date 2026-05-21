package testcases;

import Page.Login;
import base.BaseTest;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Override
    protected boolean autoLogin() {
        return false;
    }

    @Test
    public void testValidLogin() {
        Login login = new Login(page);
        login.login(EMAIL, PASSWORD);
        assertThat(login.getAccountMenu()).isVisible();
    }

    @Test
    public void testInvalidLogin() {
        Login login = new Login(page);
        login.openLoginPage();
        login.enterEmail("wrong@example.com");
        login.enterPassword("WrongPassword123");
        login.clickSignIn();

        // invalid credentials keep the user on the login page
        assertThat(page).hasURL(Pattern.compile("/login"));
    }
}

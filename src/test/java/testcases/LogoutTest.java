package testcases;

import Page.Logout;
import base.BaseTest;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {

        Logout logout = new Logout(page);
        logout.logout();

        assertThat(logout.getSignInButton()).isVisible();
    }
}

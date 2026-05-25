package testcases;

import Page.Logout;
import base.BaseTest;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
        // BaseTest already signed us in — just sign out.
        Logout logout = new Logout(page);
        logout.logout();

        // signing out brings back the "Sign in" button
        assertThat(logout.getSignInButton()).isVisible();
    }
}

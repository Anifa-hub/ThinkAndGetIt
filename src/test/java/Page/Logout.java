package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * Page object for the logout flow.
 * Signing out is done from the header user menu — a hover dropdown that
 * is shown only while a user is signed in.
 */
public class Logout {
    Page page;

    public Logout(Page page) {
        this.page = page;
    }

    String userMenuTrigger = "header div.relative.group button.btn-icon";
    String signOutButton = "header div.relative.group button.text-brand-red";
    // After signing out the app redirects to "/", which has no <header>.
    String signInButton = "a[href='/login']";

    /** Hovers the header user menu so its dropdown becomes visible. */
    public void openUserMenu() {
        page.hover(userMenuTrigger);
    }

    public void clickSignOut() {
        page.click(signOutButton);
    }

    /** Opens the user menu, signs the current user out, and waits for the
     *  signed-out state to render. */
    public void logout() {
        openUserMenu();
        clickSignOut();
        page.locator(signInButton).waitFor();
    }

    /** The header "Sign in" button — visible only when signed out. */
    public Locator getSignInButton() {
        return page.locator(signInButton);
    }
}

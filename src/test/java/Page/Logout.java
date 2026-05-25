package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class Logout {
    Page page;

    public Logout(Page page) {
        this.page = page;
    }

    String userMenuTrigger = "header div.relative.group button.btn-icon";
    String signOutButton = "header div.relative.group button.text-brand-red";

    String signInButton = "a[href='/login']";

    public void openUserMenu() {
        page.hover(userMenuTrigger);
    }

    public void clickSignOut() {
        page.click(signOutButton);
    }


    public void logout() {
        openUserMenu();
        clickSignOut();
        page.locator(signInButton).waitFor();
    }
    public Locator getSignInButton() {
        return page.locator(signInButton);
    }
}

package Page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ShopNow {
    Page page;
    String shopNowButton = "a.btn-primary.glow-red";
    String sort = "select.input.cursor-pointer";


    public ShopNow(Page page){
        this.page = page;
    }
    public void clickShopNow(){
        page.click(shopNowButton);
    }
    public void selectOPtions(String value){
            page.locator(sort).waitFor();
            page.selectOption(sort,value);
    }
    public Locator getSortDropdown() {
        return page.locator(sort);
    }
}

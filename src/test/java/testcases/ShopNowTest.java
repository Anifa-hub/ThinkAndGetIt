package testcases;

import Page.ShopNow;
import base.BaseTest;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ShopNowTest extends BaseTest {
    @Test
    public void testSorting(){
        ShopNow shopNow = new ShopNow(page);
        shopNow.clickShopNow();
        shopNow.selectOPtions("Newest");
            assertThat(shopNow.getSortDropdown()).hasValue("newest");
        shopNow.selectOPtions("Most Popular");
            assertThat(shopNow.getSortDropdown()).hasValue("popular");
        shopNow.selectOPtions("Price: Low → High");
            assertThat(shopNow.getSortDropdown()).hasValue("price_asc");
        shopNow.selectOPtions("Price: High → Low");
            assertThat(shopNow.getSortDropdown()).hasValue("price_desc");
        shopNow.selectOPtions("Top Rated");
            assertThat(shopNow.getSortDropdown()).hasValue("rating");

    }
}

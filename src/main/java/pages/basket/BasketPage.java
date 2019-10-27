package pages.basket;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.commons.TopMenuPage;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
        menu = new TopMenuPage(driver);
    }

    private TopMenuPage menu;

    public TopMenuPage getMenu() {
        return menu;
    }
}

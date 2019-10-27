package pages.commons;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.products.ListOfProductsPage;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
        popularProducts = new ListOfProductsPage(driver);
        menu = new TopMenuPage(driver);
    }

    private ListOfProductsPage popularProducts;
    private TopMenuPage menu;

    public ListOfProductsPage getProductContainer() {
        return popularProducts;
    }

    public TopMenuPage getMenu() {
        return menu;
    }
}

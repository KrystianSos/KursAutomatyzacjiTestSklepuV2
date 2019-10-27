package pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class TopMenuPage extends BasePage {
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cart-products-count")
    private WebElement cartQuantity;

    public int getCartQuantity(){

        return Integer.parseInt(cartQuantity
                .getText()
                .replace("(","")
                .replace(")",""));

    }
}

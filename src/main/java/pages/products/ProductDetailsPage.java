package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//span[@itemprop='price']")
    private WebElement price;

    @FindBy(css = "h1")
    private WebElement name;

    @FindBy(id = "quantity_wanted")
    private WebElement quantity;

    @FindBy(className = "add-to-cart")
    private WebElement addToCart;

    public String getName(){
        return name.getText();
    }


}

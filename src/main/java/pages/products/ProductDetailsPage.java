package pages.products;

import models.Order;
import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.math.BigDecimal;

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

    public BigDecimal getPrice(){
        return new BigDecimal(price.getText().replace("$",""));
    }

    public void setQuantity(int quantity){
        this.quantity.sendKeys(String.valueOf(quantity)); //rzutowanie nie stringa
    }

    public int getQuantity(){
        return Integer.parseInt(quantity.getAttribute("value"));
    }

    public void addProductToBasket(Order order){
        Product product = new Product(getName(), getPrice(), getQuantity());
        order.addProduct(product);
        click(addToCart);
        visibilityOf(By.id("myModalLabel"));
    }

}

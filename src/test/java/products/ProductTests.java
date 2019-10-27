package products;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.commons.MainPage;
import pages.products.ProductMiniaturePage;

import java.math.BigDecimal;
import java.util.List;

public class ProductTests extends BaseTest {

    @Test
    public void displayProductsWithPricesOver20Usd() {
        MainPage mainPage = new MainPage(getDriver());
        List<ProductMiniaturePage> allProducts = mainPage.getProductContainer().getProducts();

        for (ProductMiniaturePage product : allProducts) {
            if(product.getPrice().compareTo(new BigDecimal(20)) > 0){
                System.out.println(product.getName());
            }
        }
    }
}

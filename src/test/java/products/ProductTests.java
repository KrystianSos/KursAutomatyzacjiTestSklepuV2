package products;

import base.BaseTest;
import org.testng.Assert;
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

    @Test
    public void displayAllDetailsOfDiscountedProducts() {
        MainPage mainPage = new MainPage(getDriver());
        List<ProductMiniaturePage> allProducts = mainPage.getProductContainer().getProducts();
        for (ProductMiniaturePage product : allProducts) {
            if(product.getPrice().compareTo(new BigDecimal(20)) > 0){
                if(product.isDiscounted()){
                    System.out.println(product.toString());
                }
            }
        }

    }

    @Test
    public void displayDiscountedPrices(){
        MainPage mainPage = new MainPage(getDriver());
        List<ProductMiniaturePage> allProducts = mainPage.getProductContainer().getProducts();
        for (ProductMiniaturePage product : allProducts) {
            if(product.isDiscounted()){
                BigDecimal expectedPrice = product.getPriceBeforeDiscount()
                        .multiply(new BigDecimal(1)
                                .subtract(product.getDiscountValue()))
                        .stripTrailingZeros();
                System.out.println("I'm checking now: " + product.getName());
                Assert.assertEquals(expectedPrice.compareTo(product.getPrice().stripTrailingZeros()),0, " failed for product" + product.getName());
            }
        }
    }
}

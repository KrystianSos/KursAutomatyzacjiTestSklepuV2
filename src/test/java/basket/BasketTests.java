package basket;

import base.BaseTest;
import models.Order;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.basket.BasketPage;
import pages.commons.MainPage;
import pages.products.ProductDetailsPage;

import java.util.Random;

public class BasketTests extends BaseTest {

    @Test
    public void basketFlow() {

        Order expectedOrder = new Order();

        MainPage mainPage = new MainPage(getDriver());
        mainPage.getProductContainer().getRandomProduct().open();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(getDriver());
        productDetailsPage.setQuantity(new Random().nextInt(5) + 1);
        productDetailsPage.addProductToBasket(expectedOrder);

        getDriver().get("http://5.196.7.235/cart?action=show");//otwieramy koszyk, żeby było szybciej bo mało czasu;
        BasketPage basketPage = new BasketPage(getDriver());
        int expectedCartQuantity = expectedOrder.getTotalQuantity();
        int actualQuantityValue = basketPage.getMenu().getCartQuantity();
        Assert.assertEquals(actualQuantityValue, expectedCartQuantity);
    }

}

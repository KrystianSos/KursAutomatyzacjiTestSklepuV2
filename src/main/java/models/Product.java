package models;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;

    public int getQuantity() {
        return quantity;
    }

    private int quantity;

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    private BigDecimal totalPrice;

    public Product(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        updatePrice();
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
        updatePrice();
    }

    private void updatePrice() {
        totalPrice = price.multiply(new BigDecimal(quantity));
    }


    public String getName() {
        return name;
    }
}

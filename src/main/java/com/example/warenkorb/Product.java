package com.example.warenkorb;

import java.math.BigDecimal;

public class Product {
    private String Name;
    private int id;
    private int price;
    private BigDecimal stock;
    private String unit;

    public void setName(String productName) {
        this.Name = productName;
    }

    public String getName() {
        return this.Name;
    }

    public void setId(int productId) {
        this.id = productId;
    }

    public int getId() {
        return this.id;
    }

    public void setPrice(int productPrice) {
        this.price = productPrice;
    }

    public int getPrice() {
        return this.price;
    }

    public void setStock(BigDecimal productStock) {
        this.stock = productStock;
    }

    public BigDecimal getStock() {
        return this.stock;
    }

    public void setUnit(String productUnit) {
        this.unit = productUnit;
    }

    public String getUnit() {
        return this.unit;
    }

    @Override
    public String toString() {
        return this.Name;
    }
}

package com.example.warenkorb;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private int quantity;
    private double amount;

    public OrderItem(Product p) {

        this.quantity = 1;
        this.amount = p.getPrice();
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static void main(String[] args) {
        List<OrderItem> orderedItems = new ArrayList<>();


        Product p = new Product();
        p.setPrice((int) 10.0);

        OrderItem i = new OrderItem(p);
        orderedItems.add(i);


        OrderItem firstItem = orderedItems.get(0);
        System.out.println("Quantity: " + firstItem.getQuantity());
        System.out.println("Amount: " + firstItem.getAmount());
    }
}

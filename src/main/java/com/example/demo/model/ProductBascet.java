package com.example.demo.model;

public class ProductBascet {
    private long id;
    private int amount;
    private Product product;
    private Order order;

    protected ProductBascet(){}

    public ProductBascet(int amount, Product product, Order order){
        this.amount = amount;
        this.product = product;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

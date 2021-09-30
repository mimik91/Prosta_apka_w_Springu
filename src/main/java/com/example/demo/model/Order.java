package com.example.demo.model;

import java.time.LocalDate;
import java.util.Set;

public class Order {
    private long id;
    private LocalDate date;
    private Set<ProductBascet> productBascets;

    protected Order() {
    }

    public Order(LocalDate date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<ProductBascet> getProductBascets() {
        return productBascets;
    }

    public void setProductBascets(Set<ProductBascet> productBascets) {
        this.productBascets = productBascets;
    }
}

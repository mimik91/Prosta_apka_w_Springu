package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Set;

public class Product {
    private long id;
    private String name;
    private BigDecimal price;
    private Category category;
    private Set<Tag> tags;
    private Set<ProductBascet> productBascets;

    protected Product(){}

    public Product(String name, BigDecimal price, Category category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<ProductBascet> getProductBascets() {
        return productBascets;
    }

    public void setProductBascets(Set<ProductBascet> productBascets) {
        this.productBascets = productBascets;
    }
}

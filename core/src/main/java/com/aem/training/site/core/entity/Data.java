package com.aem.training.site.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown =true)
public class Data  {
    List<HeaderProductEntity> products;

    public List<HeaderProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<HeaderProductEntity> products) {
        this.products = products;
    }
}

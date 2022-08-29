package com.example.onlineaplication.ejb.product.service;

import com.example.onlineaplication.ejb.product.Products;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ProductServiceLocal {

    void create(Products products);

    void edit(Products products);

    void remove(Products products);

    Products find(Object id);

    List<Products> findAll();

    void invalidateCache();
}

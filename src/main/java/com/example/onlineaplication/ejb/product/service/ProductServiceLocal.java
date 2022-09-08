package com.example.onlineaplication.ejb.product.service;

import com.example.onlineaplication.ejb.product.Product;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ProductServiceLocal {

    void create(Product product);

    void edit(Product product);

    void remove(Product product);

    Product find(Object id);

    List<Product> findAll();

    void invalidateCache();
}

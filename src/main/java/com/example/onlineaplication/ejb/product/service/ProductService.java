package com.example.onlineaplication.ejb.product.service;

import com.example.onlineaplication.AbstractService;
import com.example.onlineaplication.ejb.product.Products;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ProductService extends AbstractService<Products> implements ProductServiceLocal {

    @PersistenceContext(unitName = "aplicationPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public ProductService() {
        super(Products.class);
    }

    @Override
    public void invalidateCache() {
        entityManager.getEntityManagerFactory().getCache().evictAll();
    }
}

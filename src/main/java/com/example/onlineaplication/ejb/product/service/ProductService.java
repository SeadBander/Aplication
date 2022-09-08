package com.example.onlineaplication.ejb.product.service;

import com.example.onlineaplication.AbstractService;
import com.example.onlineaplication.ejb.product.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class ProductService extends AbstractService<Product> implements ProductServiceLocal {

    @PersistenceContext(unitName = "aplicationPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public ProductService() {
        super(Product.class);
    }

    @Override
    public void invalidateCache() {
        entityManager.getEntityManagerFactory().getCache().evictAll();
    }

}

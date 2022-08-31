package com.example.onlineaplication.ejb.product.service;

import com.example.onlineaplication.AbstractService;
import com.example.onlineaplication.ejb.product.Products;
import com.example.onlineaplication.ejb.user.Users;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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


    @Override
    public List<Products> findByUserId(Users user) {
        List<Products> products = null;
            Query query = entityManager.createNamedQuery("Products.findByUserId")
                    .setParameter("applicant", user);
            products = (List<Products>) query.getResultList();
            return products;

    }
}

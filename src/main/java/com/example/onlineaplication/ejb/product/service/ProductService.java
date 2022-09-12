package com.example.onlineaplication.ejb.product.service;

import com.example.onlineaplication.AbstractService;
import com.example.onlineaplication.ejb.product.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.logging.Logger;

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

    public Product findByProductName(String productName) {
        Product product = null;
        try {
            Query query = entityManager.createNamedQuery("Products.findByProductName");
            query.setParameter("productName", product);
            product = (Product) query.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            Logger.getLogger(getClass().getName()).info("Pogresan productName: " + e.getMessage());
        }
        return product;
    }
}

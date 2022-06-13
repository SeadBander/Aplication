package com.example.onlineaplication.ejb.aplikacija;

import com.example.onlineaplication.controller.AbstractService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class AplikacijaService extends AbstractService<Aplikacija> implements AplikacijaServiceLocal {

    @PersistenceContext(unitName = "bankaPU")
    private EntityManager entityManager;

    public AplikacijaService() {
        super(Aplikacija.class);
    }
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void invalidateCache() {
        entityManager.getEntityManagerFactory().getCache().evictAll();
    }
}

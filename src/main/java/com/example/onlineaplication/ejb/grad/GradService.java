package com.example.onlineaplication.ejb.grad;

import com.example.onlineaplication.ejb.AbstractService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class GradService extends AbstractService<Grad> implements GradServiceLocal {

    @PersistenceContext(unitName = "bankaPU")
    private EntityManager entityManager;

    public GradService() {
        super(Grad.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Grad> findAll() {
        Query query = entityManager.createNamedQuery("Grad.findAll");
        List<Grad> gradovi = query.getResultList();
        return gradovi;
    }
}

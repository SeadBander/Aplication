package com.example.onlineaplication.ejb.town.service;

import com.example.onlineaplication.ejb.town.Town;
import com.example.onlineaplication.AbstractService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class TownService extends AbstractService<Town> implements TownServiceLocal {

    @PersistenceContext(unitName = "aplicationPU")
    private EntityManager entityManager;

    public TownService() {
        super(Town.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Town> findAll() {
        Query query = entityManager.createNamedQuery("Town.findAll");
        List<Town> towns = query.getResultList();
        return towns;
    }
}

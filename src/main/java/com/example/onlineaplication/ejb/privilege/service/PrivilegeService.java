package com.example.onlineaplication.ejb.privilege.service;

import com.example.onlineaplication.AbstractService;
import com.example.onlineaplication.ejb.privilege.Privilege;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PrivilegeService extends AbstractService<Privilege> implements PrivilegeServiceLocal {

    @PersistenceContext(unitName = "aplicationPU")
    private EntityManager entityManager;


    public PrivilegeService() {
        super(Privilege.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}

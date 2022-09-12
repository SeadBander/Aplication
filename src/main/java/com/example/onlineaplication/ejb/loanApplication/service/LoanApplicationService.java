package com.example.onlineaplication.ejb.loanApplication.service;

import com.example.onlineaplication.AbstractService;
import com.example.onlineaplication.ejb.loanApplication.LoanApplication;
import com.example.onlineaplication.ejb.user.Users;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class LoanApplicationService extends AbstractService<LoanApplication> implements LoanApplicationServiceLocal{

    @PersistenceContext(unitName = "aplicationPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public LoanApplicationService() {
        super(LoanApplication.class);
    }

    @Override
    public void invalidateCache() {
        entityManager.getEntityManagerFactory().getCache().evictAll();
    }

    @Override
    public List<LoanApplication> findByUserId(Users user) {
        List<LoanApplication> loanApplications = null;

        try{
            Query query = entityManager.createNamedQuery("LoanApplication.findByUserId")
                    .setParameter("userId", user);
            loanApplications = (List<LoanApplication>) query.getResultList();
            return loanApplications;

        }catch (NonUniqueResultException | NoResultException e){
            Logger.getLogger("APPLICATION BY USERID QUERY").log(Level.INFO,e.getMessage());
        }
        return loanApplications;
    }
}

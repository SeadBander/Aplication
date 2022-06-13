package com.example.onlineaplication.ejb.klijenti;

import com.example.onlineaplication.controller.AbstractService;
import com.example.onlineaplication.controller.ModelPrijave;
import com.example.onlineaplication.controller.ModelRegistracije;
import com.example.onlineaplication.ejb.grad.Grad;
import com.example.onlineaplication.ejb.grad.GradServiceLocal;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

import java.util.logging.Logger;

@Stateless
public class KlijentiService extends AbstractService<Klijenti> implements KlijentiServiceLocal {

    @PersistenceContext(unitName = "bankaPU")
    private EntityManager entityManager;

    @Inject
    private Pbkdf2PasswordHash pbkdf2PasswordHash;

    @Inject
    private GradServiceLocal gradServiceLocal;

    public KlijentiService() {
        super(Klijenti.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Klijenti findByUsername(String username) {
        Klijenti klijenti = null;
        try {
            Query query = entityManager.createNamedQuery("Klijenti.findByUsername");
            query.setParameter("username", username);
            klijenti = (Klijenti) query.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            Logger.getLogger(getClass().getName()).info("Pogresan username: " + e.getMessage());
        }
        return klijenti;
    }

    @Override
    public Klijenti registracija(ModelRegistracije modelRegistracije) {
        Klijenti klijenti = findByUsername(modelRegistracije.getUsername());
        if (klijenti == null) {
            klijenti = new Klijenti();
            klijenti.setIme(modelRegistracije.getIme());
            klijenti.setPrezime(modelRegistracije.getPrezime());
            klijenti.setSpol(modelRegistracije.getSpol());
            klijenti.setTelefon(modelRegistracije.getTelefon());
            klijenti.setJmbg(modelRegistracije.getJmbg());
            Grad grad = gradServiceLocal.find(modelRegistracije.getGradId());
            klijenti.setIdGrad(grad);
            klijenti.setEmail(modelRegistracije.getEmail());
            klijenti.setUsername(modelRegistracije.getUsername());
            String hashedPassword = pbkdf2PasswordHash.generate(modelRegistracije.getPlainPassword().toCharArray());
            klijenti.setPassword(hashedPassword);
            create(klijenti);
        }
        return klijenti;
    }

    @Override
    public Klijenti login(ModelPrijave modelPrijave) {
        Klijenti klijenti = null;
        try {
            Query query = entityManager.createNamedQuery("Klijenti.findByUsername");
            query.setParameter("username", modelPrijave.getUsername());
            klijenti = (Klijenti) query.getSingleResult();
            if(!pbkdf2PasswordHash.verify(modelPrijave.getPlainPassword().toCharArray(), klijenti.getPassword())){
                throw new NoResultException("Pogresan password");
            }
        } catch (NonUniqueResultException | NoResultException e) {
            Logger.getLogger(getClass().getName()).info("Pogresan username: " + e.getMessage());
        }
        return klijenti;
    }

    @Override
    public Klijenti update(ModelRegistracije modelRegistracije) {
        return null;
    }
}

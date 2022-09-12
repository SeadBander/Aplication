package com.example.onlineaplication.ejb.user.service;

import com.example.onlineaplication.AbstractService;
import com.example.onlineaplication.controller.login.LogInModel;
import com.example.onlineaplication.controller.registracija.SignUpModel;
import com.example.onlineaplication.ejb.privilege.Privilege;
import com.example.onlineaplication.ejb.privilege.service.PrivilegeServiceLocal;
import com.example.onlineaplication.ejb.town.Town;
import com.example.onlineaplication.ejb.town.service.TownServiceLocal;
import com.example.onlineaplication.ejb.user.Users;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;


import java.util.logging.Logger;

@Stateless
public class UserService extends AbstractService<Users> implements UserServiceLocal {

    @PersistenceContext(unitName = "aplicationPU")
    private EntityManager entityManager;

    @Inject
    private Pbkdf2PasswordHash pbkdf2PasswordHash;

    @Inject
    private TownServiceLocal townServiceLocal;

    @Inject
    private PrivilegeServiceLocal privilegeServiceLocal;

    public UserService() {
        super(Users.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Users login(LogInModel logInModel) {
        Users user = null;
        try {
            Query query = entityManager.createNamedQuery("Users.findByUsername");
            query.setParameter("username", logInModel.getUsername());
            user = (Users) query.getSingleResult();
            if(!pbkdf2PasswordHash.verify(logInModel.getPassword().toCharArray(), user.getPassword())){
                throw new NoResultException("Pogresan password");
            }
        } catch (NonUniqueResultException | NoResultException e) {
            Logger.getLogger(getClass().getName()).info("Pogresan username: " + e.getMessage());
        }
        return user;
    }

    @Override
    public Users findByUsername(String username) {
        Users user = null;
        try {
            Query query = entityManager.createNamedQuery("Users.findByUsername");
            query.setParameter("username", username);
            user = (Users) query.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            Logger.getLogger(getClass().getName()).info("Pogresan username: " + e.getMessage());
        }
        return user;
    }

    @Override
    public Users signUp(SignUpModel signUpModel) {
        Users user = findByUsername(signUpModel.getUsername());
        if (user == null) {
            user = new Users();
            user.setName(signUpModel.getName());
            user.setSurname(signUpModel.getSurname());
            user.setJmbg(signUpModel.getJmbg());
            user.setEmail(signUpModel.getEmail());
            user.setUsername(signUpModel.getUsername());
            String hashedPassword = pbkdf2PasswordHash.generate(signUpModel.getPassword().toCharArray());
            user.setPassword(hashedPassword);

            Town town = townServiceLocal.find(signUpModel.getTownId());
            user.setTownId(town);

            Privilege privilege = privilegeServiceLocal.find(Privilege.USER_PRIVILEGE);
            user.setPrivilegeId(privilege);
            create(user);
        }
        return user;
    }
}
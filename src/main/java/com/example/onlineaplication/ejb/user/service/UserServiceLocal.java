package com.example.onlineaplication.ejb.user.service;

import com.example.onlineaplication.controller.login.LogInModel;
import com.example.onlineaplication.controller.registracija.SignUpModel;
import com.example.onlineaplication.ejb.user.Users;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface UserServiceLocal {

    void create(Users user);

    void edit(Users user);

    void remove(Users user);

    Users find(Object id);

    List<Users> findAll();

    Users login(LogInModel logInModel);

    Users findByUsername(String username);

    Users signUp (SignUpModel signUpModel);
}

package com.example.onlineaplication.controller.registracija;

import com.example.onlineaplication.ejb.user.Users;
import com.example.onlineaplication.ejb.user.service.UserServiceLocal;

public class SignUpController {
        private final UserServiceLocal userServiceLocal;
        private final SignUpModel signUpModel;
        public SignUpController (UserServiceLocal userServiceLocal, SignUpModel signUpModel){
            this.userServiceLocal = userServiceLocal;
            this.signUpModel = signUpModel;
        }
    public boolean usernameZauzeto() {
        Users user = userServiceLocal.findByUsername(signUpModel.getUsername());
        return user != null;
    }
    public boolean ispravnaRegistracija() {
        return !signUpModel.getName().isEmpty()
                && !signUpModel.getSurname().isEmpty()
                && !signUpModel.getJmbg().isEmpty()
                && !signUpModel.getEmail().isEmpty()
                && !signUpModel.getUsername().isEmpty()
                && !signUpModel.getPassword().isEmpty();
    }
}

package com.example.onlineaplication.ejb.klijenti;

import com.example.onlineaplication.controller.login.ModelPrijave;
import com.example.onlineaplication.controller.registracija.ModelRegistracije;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface KlijentiServiceLocal {

    void create(Klijenti klijenti);

    void edit(Klijenti klijenti);

    void remove(Klijenti klijenti);

    Klijenti find(Object id);

    List<Klijenti> findAll();

    Klijenti findByUsername(String username);

    Klijenti registracija(ModelRegistracije modelRegistracije);

    Klijenti login(ModelPrijave modelPrijave);

    Klijenti update(ModelRegistracije modelRegistracije);
}

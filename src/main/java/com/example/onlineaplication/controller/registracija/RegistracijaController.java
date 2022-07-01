package com.example.onlineaplication.controller.registracija;

import com.example.onlineaplication.ejb.klijenti.Klijenti;
import com.example.onlineaplication.ejb.klijenti.KlijentiServiceLocal;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegistracijaController {

        private final KlijentiServiceLocal klijentiServiceLocal;
        private final ModelRegistracije modelRegistracije;

    public boolean usernameZauzeto() {
        Klijenti klijenti = klijentiServiceLocal.findByUsername(modelRegistracije.getUsername());
        return klijenti != null;
    }

    public boolean ispravnaRegistracija() {
        return !modelRegistracije.getIme().isEmpty()
                && !modelRegistracije.getPrezime().isEmpty()
                && !modelRegistracije.getTelefon().equals(null)
                && !modelRegistracije.getJmbg().equals(null)
                && !modelRegistracije.getGrad().isEmpty()
                && !modelRegistracije.getEmail().isEmpty()
                && !modelRegistracije.getUsername().isEmpty()
                && !modelRegistracije.getPlainPassword().isEmpty();

    }
}

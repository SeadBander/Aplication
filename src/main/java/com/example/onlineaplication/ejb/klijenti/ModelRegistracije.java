package com.example.onlineaplication.ejb.klijenti;

import com.example.onlineaplication.ejb.adresa.Adresa;
import com.example.onlineaplication.ejb.grad.Grad;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ModelRegistracije {

    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String spol;
    private Integer telefon;
    private Integer jmbg;
    private String grad;
    private String email;
    private String username;
    private String plainPassword;

    public Integer getGradId() {
        if (grad.contains("[")) {
            String gradIdText =grad.substring(grad.indexOf("[") + 1, grad.indexOf("]"));
            return Integer.parseInt(gradIdText);
        } else {
            return Integer.parseInt(grad);
        }
    }
}

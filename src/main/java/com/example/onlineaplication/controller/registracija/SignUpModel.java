package com.example.onlineaplication.controller.registracija;


public class SignUpModel {

    private String name;
    private String surname;
    private String jmbg;
    private String email;
    private String username;
    private String password;
    private String town;

    public SignUpModel() {

    }

    public SignUpModel(String name, String surname, String jmbg, String email, String username, String password, String town) {
        this.name = name;
        this.surname = surname;
        this.jmbg = jmbg;
        this.email = email;
        this.username = username;
        this.password = password;
        this.town = town;
    }


    public Integer getTownId() {

            return Integer.parseInt(town);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}

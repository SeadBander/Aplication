package com.example.onlineaplication.ejb.aplikacija;

import jakarta.ejb.Local;

import java.util.List;

@Local
public interface AplikacijaServiceLocal {

    void create(Aplikacija aplikacija);
    void edit(Aplikacija aplikacija);
    void remove(Aplikacija aplikacija);

    Aplikacija find(Object id);
    List<Aplikacija> findAll();

}

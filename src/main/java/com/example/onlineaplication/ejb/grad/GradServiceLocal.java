package com.example.onlineaplication.ejb.grad;

import jakarta.ejb.Local;

import java.util.List;

@Local
public interface GradServiceLocal {

    void create(Grad grad);

    void edit(Grad grad);

    void remove(Grad grad);

    Grad find(Object id);

    List<Grad> findAll();

}

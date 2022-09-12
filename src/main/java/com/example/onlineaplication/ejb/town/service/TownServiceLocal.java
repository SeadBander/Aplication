package com.example.onlineaplication.ejb.town.service;

import com.example.onlineaplication.ejb.town.Town;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface TownServiceLocal {

    void create(Town town);

    void edit(Town town);

    void remove(Town town);

    Town find(Object id);

    List<Town> findAll();

}

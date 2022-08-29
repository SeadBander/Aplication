package com.example.onlineaplication.ejb.privilege.service;

import com.example.onlineaplication.ejb.privilege.Privilege;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface PrivilegeServiceLocal {

    void create(Privilege privilege);

    void edit(Privilege privilege);

    void remove(Privilege privilege);

    Privilege find(Object id);

    List<Privilege> findAll();
}

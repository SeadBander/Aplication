package com.example.onlineaplication.ejb.loanApplication.service;

import com.example.onlineaplication.ejb.loanApplication.LoanApplication;
import com.example.onlineaplication.ejb.user.Users;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface LoanApplicationServiceLocal {

    void create(LoanApplication loanApplication);

    void edit(LoanApplication loanApplication);

    void remove(LoanApplication loanApplication);

    LoanApplication find(Object id);

    List<LoanApplication> findAll();

    List<LoanApplication> findByUserId(Users user);

    void invalidateCache();
}

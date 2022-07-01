package com.example.onlineaplication.controller.login;

import com.example.onlineaplication.ejb.klijenti.Klijenti;
import com.example.onlineaplication.ejb.klijenti.KlijentiServiceLocal;
import com.example.onlineaplication.sesija.KlijentiSesija;
import com.example.onlineaplication.sesija.Smjernice;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginDispetcherServlet", urlPatterns = {"/login"})
public class LoginDispetcherServlet extends HttpServlet {

    @Inject
    private KlijentiServiceLocal klijentiServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelPrijave modelPrijave = new ModelPrijave();
        modelPrijave.setUsername(request.getParameter("username"));
        modelPrijave.setPlainPassword(request.getParameter("password"));
        Klijenti klijenti = klijentiServiceLocal.login(modelPrijave);
        if (klijenti != null) {
            KlijentiSesija.KLIJENT.addToSession(klijenti, request);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Smjernice.DASHBOARD_ACCESS);
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher req = request.getRequestDispatcher(Smjernice.AUTHENTICATION);
            req.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            processRequest(request, response);
    }
}

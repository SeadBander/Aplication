package com.example.onlineaplication.controller;

import com.example.onlineaplication.ejb.grad.Grad;
import com.example.onlineaplication.ejb.grad.GradServiceLocal;
import com.example.onlineaplication.sesija.Smjernice;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegistracijaDispatcherServlet", value = "/registracija")
public class RegistracijaDispatcherServlet extends HttpServlet {

    @Inject
    private GradServiceLocal gradServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Grad> gradList = gradServiceLocal.findAll();
        request.setAttribute("gradovi", gradList);
        request.setAttribute("message", "");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Smjernice.REGISTRATION);
        requestDispatcher.include(request, response);
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

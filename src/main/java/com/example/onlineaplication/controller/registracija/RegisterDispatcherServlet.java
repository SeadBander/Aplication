package com.example.onlineaplication.controller.registracija;

import com.example.onlineaplication.ejb.grad.Grad;
import com.example.onlineaplication.ejb.grad.GradServiceLocal;
import com.example.onlineaplication.ejb.klijenti.Klijenti;
import com.example.onlineaplication.ejb.klijenti.KlijentiServiceLocal;
import com.example.onlineaplication.sesija.Smjernice;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegisterDispatcherServlet", value = "/registracija")
public class RegisterDispatcherServlet extends HttpServlet {

    @Inject
    private KlijentiServiceLocal klijentiServiceLocal;

    @Inject
    private GradServiceLocal gradServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelRegistracije modelRegistracije = ModelRegistracije.builder()
                .ime(request.getParameter("ime"))
                .prezime(request.getParameter("prezime"))
                .telefon(Integer.valueOf(request.getParameter("telefon")))
                .jmbg(Integer.valueOf(request.getParameter("jmbg")))
                .email(request.getParameter("email"))
                .username(request.getParameter("username"))
                .plainPassword(request.getParameter("password"))
                .grad(request.getParameter("grad"))
                .build();
        RegistracijaController controller = new RegistracijaController(klijentiServiceLocal, modelRegistracije);
        if (controller.ispravnaRegistracija()) {
            if (controller.usernameZauzeto()) {
                request.setAttribute("message", String.format("Username '%s' je zauzet", modelRegistracije.getUsername()));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(Smjernice.REGISTRATION);
                requestDispatcher.include(request, response);
            } else {
                Klijenti klijenti = klijentiServiceLocal.registracija(modelRegistracije);
                List<Grad> gradList = gradServiceLocal.findAll();
                request.setAttribute("gradovi", gradList);
                if (klijenti != null) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher(Smjernice.AUTHENTICATION);
                    requestDispatcher.include(request, response);
                } else {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher(Smjernice.REGISTRATION);
                    requestDispatcher.include(request, response);
                }
            }
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Smjernice.REGISTRATION);
            requestDispatcher.include(request, response);
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

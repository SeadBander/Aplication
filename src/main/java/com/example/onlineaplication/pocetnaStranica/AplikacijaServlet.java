package com.example.onlineaplication.pocetnaStranica;

import com.example.onlineaplication.ejb.aplikacija.Aplikacija;
import com.example.onlineaplication.ejb.aplikacija.AplikacijaServiceLocal;
import com.example.onlineaplication.sesija.KlijentiSesija;
import com.example.onlineaplication.sesija.Smjernice;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AplikacijaServlet", value = "/aplikacija")
public class AplikacijaServlet extends HttpServlet {

    @Inject
    private AplikacijaServiceLocal aplikacijaServiceLocal;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            aplikacijaServiceLocal.pogresniPodaci();
            List<Aplikacija> aplikacije = aplikacijaServiceLocal.findAll();
            request.setAttribute("aplikacije", aplikacije);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Smjernice.APLIKACIJA);
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

package com.example.onlineaplication.ejb.aplikacija;

import com.example.onlineaplication.ejb.klijenti.Klijenti;
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

@WebServlet(name = "AzurirajAplikaciju", urlPatterns = {"/izmjeni"})
public class AzurirajAplikaciju extends HttpServlet {


    @Inject
    private AplikacijaServiceLocal aplikacijaServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

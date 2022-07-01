package com.example.onlineaplication.ejb.aplikacija;

import com.example.onlineaplication.ejb.klijenti.Klijenti;
import com.example.onlineaplication.ejb.proizvodi.Proizvodi;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "DodajAplikaciju", urlPatterns = {"/dodaj"})
public class DodajAplikaciju extends HttpServlet {

    @Inject
    private AplikacijaServiceLocal aplikacijaServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vrstaProizvoda = request.getParameter("vrstaProizvoda");
        String iznos = request.getParameter("iznos");

        Klijenti klijenti = KlijentiSesija.KLIJENT.getFromSession(request);
        Aplikacija aplikacija = new Aplikacija();
        aplikacija.setProizvodi(vrstaProizvoda);
        aplikacija.setProizvodi(iznos);
        aplikacija.setIdKlijenta(klijenti);
        aplikacijaServiceLocal.create(aplikacija);

        List<Aplikacija> aplikacije = aplikacijaServiceLocal.findAll();
        request.setAttribute("aplikacije", aplikacije);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Smjernice.APLIKACIJA);
        requestDispatcher.include(request, response);
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

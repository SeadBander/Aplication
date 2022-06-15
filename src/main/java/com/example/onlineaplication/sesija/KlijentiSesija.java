package com.example.onlineaplication.sesija;

import com.example.onlineaplication.ejb.klijenti.Klijenti;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Logger;

public enum KlijentiSesija {

    KLIJENT("SESSION_KEY");

    private String sessionKey;

    private KlijentiSesija(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void addToSession(Klijenti klijenti, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute(sessionKey) == null) {
            session.setAttribute(sessionKey, klijenti);
        }
    }

    public Klijenti getFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Klijenti) session.getAttribute(sessionKey);
    }

    public void invalidateSession(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("registracija.jsp");
        } catch (IOException ex) {
            Logger.getLogger(KlijentiSesija.class.getName()).info(ex.getMessage());
        }
    }
}

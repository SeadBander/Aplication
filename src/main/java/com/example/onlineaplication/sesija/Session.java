package com.example.onlineaplication.sesija;


import com.example.onlineaplication.ejb.user.Users;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public enum Session {

    USERS("SESSION_KEY");

    private String sessionKey;

    private Session(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void addToSession(Users user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute(sessionKey) == null) {
            session.setAttribute(sessionKey, user);
        }
    }
    public Users getFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Users) session.getAttribute(sessionKey);
    }

}

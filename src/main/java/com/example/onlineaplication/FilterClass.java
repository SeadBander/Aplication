package com.example.onlineaplication;

import com.example.onlineaplication.ejb.user.Users;
import com.example.onlineaplication.sesija.Session;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebFilter( urlPatterns = { "/jsp/*", "/UserServlet", "/ProductServlet" })
public class FilterClass implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Users sessionUser = Session.USERS.getFromSession(request);
        if (sessionUser == null) {
            response.sendRedirect(request.getContextPath() + "/ToLogInServlet");
        } else {
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires","0");
            filterChain.doFilter(request, response);
        }
    }
}
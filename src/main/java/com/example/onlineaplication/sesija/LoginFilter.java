package com.example.onlineaplication.sesija;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/aplikacija/*"})
public class LoginFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("LoginFilter inicijaliziran");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();
        this.context.log("Trazeni resurs:" + uri);

        HttpSession session = req.getSession(false);
        res.sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/login");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

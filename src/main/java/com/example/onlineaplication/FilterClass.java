package com.example.onlineaplication;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


@WebFilter( urlPatterns = { "/jsp/*", "/BookServlet", "/NoteServlet", "/UserServlet", "/SearchServlet" })
public class FilterClass implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }
}

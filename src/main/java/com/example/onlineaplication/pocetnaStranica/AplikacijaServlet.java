package com.example.onlineaplication.pocetnaStranica;

import com.example.onlineaplication.ejb.user.service.UserServiceLocal;
import com.example.onlineaplication.paths.Paths;
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
    private UserServiceLocal userServiceLocal;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.APLICATION);
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

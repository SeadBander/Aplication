package com.example.onlineaplication.controller.registracija;

import com.example.onlineaplication.ejb.town.Town;
import com.example.onlineaplication.ejb.town.service.TownServiceLocal;
import com.example.onlineaplication.paths.Paths;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ToSignUpServlet", value = "/ToSignUpServlet")
public class ToSignUpServlet extends HttpServlet {

    @Inject
    private TownServiceLocal townServiceLocal;

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Town> towns = townServiceLocal.findAll();
        request.setAttribute("towns", towns);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.SIGNUP);
            requestDispatcher.forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}

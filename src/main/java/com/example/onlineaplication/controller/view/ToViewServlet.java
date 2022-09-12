package com.example.onlineaplication.controller.view;

import com.example.onlineaplication.ejb.product.service.ProductServiceLocal;
import com.example.onlineaplication.ejb.user.service.UserServiceLocal;
import com.example.onlineaplication.paths.Paths;
import com.example.onlineaplication.sesija.Session;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "ToViewServlet", value = "/ToViewServlet")
public class ToViewServlet extends HttpServlet {


    @Inject
    private ProductServiceLocal productServiceLocal;

    @Inject
    private UserServiceLocal userServiceLocal;

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String privilegeName = Session.USERS.getFromSession(request).getPrivilegeId().getName();

            if (privilegeName.equalsIgnoreCase("admin")) {
                RequestDispatcher toView = request.getRequestDispatcher(Paths.ADMINVIEW);
                toView.forward(request, response);
            } else {
                RequestDispatcher toView = request.getRequestDispatcher(Paths.USERVIEW);
                toView.forward(request, response);
            }
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

package com.example.onlineaplication.controller.login;

import com.example.onlineaplication.ejb.user.Users;
import com.example.onlineaplication.ejb.user.service.UserServiceLocal;
import com.example.onlineaplication.paths.Paths;
import com.example.onlineaplication.sesija.Session;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginDispatcherServlet", value = "/LoginDispatcherServlet")
public class LoginDispatcherServlet extends HttpServlet {

    @Inject
    private UserServiceLocal userServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LogInModel loginModel = new LogInModel();
        loginModel.setUsername(request.getParameter("username"));
        loginModel.setPassword(request.getParameter("password"));
        Users user = userServiceLocal.login(loginModel);
        if (user != null) {
            Session.USERS.addToSession(user, request);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.TOVIEW);
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.TOLOGIN);
            requestDispatcher.forward(request, response);
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

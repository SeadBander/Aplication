package com.example.onlineaplication.controller.view;

import com.example.onlineaplication.ejb.user.Users;
import com.example.onlineaplication.ejb.user.service.UserServiceLocal;
import com.example.onlineaplication.paths.Paths;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {

    @Inject
    private UserServiceLocal userServiceLocal;

    private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {

            List<Users> users = userServiceLocal.findAll();
            request.setAttribute("lista", users);

            Users user = (Users) userServiceLocal.findByUsername(request.getParameter("finduser"));
            request.setAttribute("findeduser",user);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.USERS);
            requestDispatcher.forward(request, response);

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
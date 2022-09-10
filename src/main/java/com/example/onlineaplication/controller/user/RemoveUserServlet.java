package com.example.onlineaplication.controller.user;

import com.example.onlineaplication.ejb.user.Users;
import com.example.onlineaplication.ejb.user.service.UserServiceLocal;
import com.example.onlineaplication.paths.Paths;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "RemoveUserServlet", value = "/RemoveUserServlet")
public class RemoveUserServlet extends HttpServlet {

    @Inject
    private UserServiceLocal userServiceLocal;

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer userId = Integer.parseInt(request.getParameter("userid"));

            Users removeUser = userServiceLocal.find(userId);
            userServiceLocal.remove(removeUser);


            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.USERSERVLET);
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


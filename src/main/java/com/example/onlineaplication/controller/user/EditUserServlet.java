package com.example.onlineaplication.controller.user;

import com.example.onlineaplication.ejb.privilege.Privilege;
import com.example.onlineaplication.ejb.privilege.service.PrivilegeServiceLocal;
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

@WebServlet(name = "EditUserServlet", value = "/EditUserServlet")
public class EditUserServlet extends HttpServlet {

    @Inject
    private UserServiceLocal userServiceLocal;
    @Inject
    private PrivilegeServiceLocal privilegeServiceLocal;

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        Integer privilegeId = Integer.parseInt(request.getParameter("privilegeradio"));
        Integer userId = Integer.parseInt(request.getParameter("userid"));

            Users editedUser = userServiceLocal.find(userId);
            Privilege privilege = privilegeServiceLocal.find(privilegeId);

            editedUser.setUsername(request.getParameter("username"));
            editedUser.setEmail(request.getParameter("email"));
            editedUser.setJmbg(request.getParameter("jmbg"));
            editedUser.setPrivilegeId(privilege);
            userServiceLocal.edit(editedUser);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.USERSERVLET);
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


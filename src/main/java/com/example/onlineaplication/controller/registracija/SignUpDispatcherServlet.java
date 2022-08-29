package com.example.onlineaplication.controller.registracija;

import com.example.onlineaplication.ejb.town.Town;
import com.example.onlineaplication.ejb.town.service.TownServiceLocal;
import com.example.onlineaplication.ejb.user.Users;
import com.example.onlineaplication.ejb.user.service.UserServiceLocal;
import com.example.onlineaplication.paths.Paths;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SignUpDispatcherServlet", value = "/SignUpDispatcherServlet")
public class SignUpDispatcherServlet extends HttpServlet {

    @Inject
    private UserServiceLocal userServiceLocal;
    @Inject
    private TownServiceLocal townServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Town> towns = townServiceLocal.findAll();
        request.setAttribute("towns", towns);
        SignUpModel signUpModel = new SignUpModel();

                signUpModel.setName(request.getParameter("name"));
                signUpModel.setSurname(request.getParameter("surname"));
                signUpModel.setJmbg(request.getParameter("jmbg"));
                signUpModel.setEmail(request.getParameter("email"));
                signUpModel.setUsername(request.getParameter("username"));
                signUpModel.setPassword(request.getParameter("password"));
                signUpModel.setTown(request.getParameter("town"));

        SignUpController controller = new SignUpController(userServiceLocal, signUpModel);
        if (controller.ispravnaRegistracija()) {
            if (controller.usernameZauzeto()) {
                request.setAttribute("message", String.format("Username '%s' je zauzet", signUpModel.getUsername()));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.SIGNUP);
                requestDispatcher.include(request, response);
            } else {
                Users user = userServiceLocal.signUp(signUpModel);

                if (user != null) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.TOLOGIN);
                    requestDispatcher.include(request, response);
                } else {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.SIGNUP);
                    requestDispatcher.include(request, response);
                }
            }
        } else {
            request.setAttribute("message", String.format("Popuniti sva polja !!!"));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.SIGNUP);
            requestDispatcher.include(request, response);
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

package com.example.onlineaplication.controller.login;

import com.example.onlineaplication.paths.Paths;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ToLogInServlet", value = "/ToLogInServlet")
public class ToLogInServlet extends HttpServlet {

    private void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.LOGIN);
            requestDispatcher.forward(request,response);

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

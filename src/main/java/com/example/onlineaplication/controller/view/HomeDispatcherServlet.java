package com.example.onlineaplication.controller.view;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.onlineaplication.paths.Paths;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "HomeDispatcherServlet", value = "/HomeDispatcherServlet")
public class HomeDispatcherServlet extends HttpServlet {


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.HOME);
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

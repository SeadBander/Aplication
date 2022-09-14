package com.example.onlineaplication.controller.aplication;

import com.example.onlineaplication.ejb.loanApplication.LoanApplication;
import com.example.onlineaplication.ejb.loanApplication.service.LoanApplicationServiceLocal;
import com.example.onlineaplication.ejb.product.Product;
import com.example.onlineaplication.ejb.product.service.ProductServiceLocal;
import com.example.onlineaplication.ejb.user.Users;
import com.example.onlineaplication.ejb.user.service.UserServiceLocal;
import com.example.onlineaplication.paths.Paths;
import com.example.onlineaplication.sesija.Session;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "EditAppServlet", value = "/EditAppServlet")
public class EditAppServlet extends HttpServlet {

    @Inject
    private LoanApplicationServiceLocal loanApplicationServiceLocal;
    @Inject
    private ProductServiceLocal productServiceLocal;

    @Inject
    private UserServiceLocal userServiceLocal;
    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        Integer appId = Integer.parseInt(request.getParameter("id"));

        try {
            LoanApplication appToChange = loanApplicationServiceLocal.find(appId);
            Integer productId = Integer.parseInt(request.getParameter("productId"));
            Product product = productServiceLocal.find(productId);
            appToChange.setProductId(product);

            appToChange.setAmount(request.getParameter("amount"));

            Integer userId = Integer.parseInt(request.getParameter("userId"));
            Users users = userServiceLocal.find(userId);
            appToChange.setUserId(users);

            loanApplicationServiceLocal.edit(appToChange);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.LOANAPPLICATIONSERVLET);
            requestDispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            Logger.getLogger("EDIT REQUEST SERVLET").log(Level.INFO, e.getMessage());

        }
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
package com.example.onlineaplication.controller.aplication;

import com.example.onlineaplication.ejb.loanApplication.LoanApplication;
import com.example.onlineaplication.ejb.loanApplication.service.LoanApplicationServiceLocal;
import com.example.onlineaplication.ejb.product.Product;
import com.example.onlineaplication.ejb.product.service.ProductServiceLocal;
import com.example.onlineaplication.paths.Paths;
import com.example.onlineaplication.sesija.Session;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "EditProductServlet", value = "/EditProductServlet")
public class EditProductServlet extends HttpServlet {

    @Inject
    private LoanApplicationServiceLocal loanApplicationServiceLocal;

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        Integer productId = Integer.parseInt(request.getParameter("productid"));
        String privilegeName = Session.USERS.getFromSession(request).getPrivilegeId().getName();
        try {
            if (privilegeName.equalsIgnoreCase("admin")) {
                LoanApplication productToChange = loanApplicationServiceLocal.find(productId);
                productToChange.setAmount(request.getParameter("amount"));
                loanApplicationServiceLocal.edit(productToChange);
            } else {

                LoanApplication productToChange = loanApplicationServiceLocal.find(productId);
                productToChange.setAmount(request.getParameter("amount"));
                loanApplicationServiceLocal.edit(productToChange);
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.PRODUCTSERVLET);
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            Logger.getLogger("EDIT PRODUCT SERVLET").log(Level.INFO, e.getMessage());

        }
    }
}
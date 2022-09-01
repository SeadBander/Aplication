package com.example.onlineaplication.controller.aplication;

import com.example.onlineaplication.ejb.product.Products;
import com.example.onlineaplication.ejb.product.service.ProductServiceLocal;
import com.example.onlineaplication.ejb.user.Users;
import com.example.onlineaplication.paths.Paths;
import com.example.onlineaplication.sesija.Session;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {

    @Inject
    private ProductServiceLocal productServiceLocal;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String privilegeName = Session.USERS.getFromSession(request).getPrivilegeId().getName();

        if (privilegeName.equalsIgnoreCase("admin")) {

            List<Products> allProducts = productServiceLocal.findAll();
            request.setAttribute("productlist", allProducts);

            if (request.getParameter("findproduct") == null) {

                Products products = productServiceLocal.find(1);
                request.setAttribute("findedproduct", products);
            } else {
                Integer productId = Integer.parseInt(request.getParameter("findproduct"));
                Products products = productServiceLocal.find(productId);
                request.setAttribute("findedproduct", products);
            }

            RequestDispatcher toView = request.getRequestDispatcher(Paths.ADMINPRODUCT);
            toView.forward(request, response);
        } else {

            Users userInSession = Session.USERS.getFromSession(request);
            List<Products> productsList = (List<Products>) productServiceLocal.findByUserId(userInSession);
            request.setAttribute("productlist", productsList);

            RequestDispatcher toView = request.getRequestDispatcher(Paths.USERPRODUCT);
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

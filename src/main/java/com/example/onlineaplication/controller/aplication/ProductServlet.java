package com.example.onlineaplication.controller.aplication;

import com.example.onlineaplication.ejb.product.Products;
import com.example.onlineaplication.ejb.product.service.ProductServiceLocal;
import com.example.onlineaplication.paths.Paths;
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
        productServiceLocal.invalidateCache();
        List<Products> products = productServiceLocal.findAll();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.APLICATION);
        requestDispatcher.include(request, response);
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

package com.example.onlineaplication.controller.product;

import com.example.onlineaplication.ejb.product.Product;
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

    private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {

        List<Product> products = productServiceLocal.findAll();
        request.setAttribute("productlist", products);

        Product product = (Product) productServiceLocal.findByProductName(request.getParameter("findproduct"));
        request.setAttribute("findedproduct",product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.PRODUCTS);
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
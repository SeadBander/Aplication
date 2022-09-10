package com.example.onlineaplication.controller.product;

import com.example.onlineaplication.ejb.privilege.Privilege;
import com.example.onlineaplication.ejb.privilege.service.PrivilegeServiceLocal;
import com.example.onlineaplication.ejb.product.Product;
import com.example.onlineaplication.ejb.product.service.ProductServiceLocal;
import com.example.onlineaplication.ejb.user.Users;
import com.example.onlineaplication.ejb.user.service.UserServiceLocal;
import com.example.onlineaplication.paths.Paths;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditProductServlet", value = "/EditProductServlet")
public class EditProductServlet extends HttpServlet {
    @Inject
    private PrivilegeServiceLocal privilegeServiceLocal;

    @Inject
    private ProductServiceLocal productServiceLocal;
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        Integer privilegeId = Integer.parseInt(request.getParameter("privilegeradio"));
        Integer productId = Integer.parseInt(request.getParameter("productid"));

        Product editedProduct = productServiceLocal.find(productId);
        Privilege privilege = privilegeServiceLocal.find(privilegeId);

        editedProduct.setProductName(request.getParameter("productname"));
        productServiceLocal.edit(editedProduct);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Paths.PRODUCTSERVLET);
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


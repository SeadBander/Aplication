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
import java.util.List;

@WebServlet(name = "LoanApplicationServlet", value = "/LoanApplicationServlet")
public class LoanApplicationServlet extends HttpServlet {

    @Inject
    private LoanApplicationServiceLocal loanApplicationServiceLocal;

    @Inject
    private ProductServiceLocal productServiceLocal;
    @Inject
    private UserServiceLocal userServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String privilegeName = Session.USERS.getFromSession(request).getPrivilegeId().getName();


        if (privilegeName.equalsIgnoreCase("admin")) {

            List<LoanApplication> allApps = loanApplicationServiceLocal.findAll();
            request.setAttribute("applist", allApps);


            if (request.getParameter("findapp") == null){

                List<LoanApplication> loanApplicationList = loanApplicationServiceLocal.findAll();
                request.setAttribute("applist", loanApplicationList);


            } else {
                Integer appId = Integer.parseInt(request.getParameter("findapp"));
                LoanApplication loanApplication = loanApplicationServiceLocal.find(appId);
                request.setAttribute("findedapp",loanApplication);
            }

            RequestDispatcher toView = request.getRequestDispatcher(Paths.ADMINPRODUCT);
            toView.forward(request, response);
        } else {

            Users userInSession = Session.USERS.getFromSession(request);

            List<LoanApplication> appList = loanApplicationServiceLocal.findByUserId(userInSession);
            request.setAttribute("applist", appList);

            List<Product> productList = productServiceLocal.findAll();
            request.setAttribute("productlist", productList);


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

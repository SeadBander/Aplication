package com.example.onlineaplication.controller.aplication;

import com.example.onlineaplication.ejb.loanApplication.LoanApplication;
import com.example.onlineaplication.ejb.loanApplication.service.LoanApplicationServiceLocal;
import com.example.onlineaplication.paths.Paths;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "RemoveAppServlet", value = "/RemoveAppServlet")
public class RemoveAppServlet extends HttpServlet {

    @Inject
    private LoanApplicationServiceLocal loanApplicationServiceLocal;


    private void processRequest(HttpServletRequest request,HttpServletResponse response){

        Integer id = Integer.parseInt(request.getParameter("id"));

        try{
            LoanApplication removeApp = loanApplicationServiceLocal.find(id);
            loanApplicationServiceLocal.remove(removeApp);

            RequestDispatcher toView = request.getRequestDispatcher(Paths.LOANAPPLICATIONSERVLET);
            toView.forward(request,response);

        }catch (ServletException | IOException e){
            Logger.getLogger("REMOVE PRODUCT SERVLET").log(Level.INFO,e.getMessage());
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

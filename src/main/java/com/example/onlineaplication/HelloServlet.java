package com.example.onlineaplication;

import java.io.*;
import java.util.List;

import com.example.onlineaplication.ejb.klijenti.Klijenti;
import com.example.onlineaplication.ejb.klijenti.KlijentiServiceLocal;
import jakarta.inject.Inject;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Inject
    private KlijentiServiceLocal klijentiServiceLocal;
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        List<Klijenti> klijentiList = klijentiServiceLocal.findAll();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<ul>");
        klijentiList.forEach(klijenti->{
            out.println("<li>"+klijenti.getIme()+"</li>");
        });
        out.println("</ul>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
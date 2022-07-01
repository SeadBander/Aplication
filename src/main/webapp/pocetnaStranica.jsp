<%@ page import="com.example.onlineaplication.ejb.klijenti.Klijenti" %>
<%@ page import="com.example.onlineaplication.sesija.KlijentiSesija" %><%--
  Created by IntelliJ IDEA.
  User: SEJO
  Date: 28-Jun-22
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="pocetnaStranica.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
            crossorigin="anonymous"></script>
    <title>Dobrodosli</title>
</head>
<body>


<%
    Klijenti klijenti = KlijentiSesija.KLIJENT.getFromSession(request);
%>

<div style="padding: 20px">
    <ul class="topnav">
        <li><a href="${pageContext.request.contextPath}/dashboardAccess">Pocetna stranica</a></li>
        <li><a href="${pageContext.request.contextPath}/aplikacija">Aplikacija</a></li>
        <li><a href="${pageContext.request.contextPath}/updateKorisnika">Pristupni podaci</a></li>
        <li class="right"><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
    </ul>

    <h2 class="card-header text-center font-weight-bold text-uppercase py-4">Bank Online Application platformu</h2>
    <h3 class="card-header text-center font-weight-bold py-4">Ovdje mozete aplicirati online za bankarski proizvod prema Vasim potrebama</h3>

    <div class="responsive">
        <div class="gallery">
            <a target="_blank"
               href="css/slika4.jpg">
                <img src="css/slika2.jpg"
                     alt="Cinque Terre" width="600" height="400">
            </a>
        </div>
    </div>
</div>
</body>
</html>

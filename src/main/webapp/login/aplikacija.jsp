<%@ page import="com.example.onlineaplication.ejb.klijenti.Klijenti" %>
<%@ page import="com.example.onlineaplication.sesija.KlijentiSesija" %><%--
  Created by IntelliJ IDEA.
  User: SEJO
  Date: 12-Jun-22
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Online aplikacija</title>
    <link rel="stylesheet" type="text/css" href="login/aplikacija.css">

</head>
<body>

<div style="padding: 20px">
    <ul class="topnav">
        <li><a href="${pageContext.request.contextPath}/dashboardAccess">Home</a></li>
        <li class="right"><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
    </ul>
</div>


</body>

</html>

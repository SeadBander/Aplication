<%@ page import="com.example.onlineaplication.ejb.town.Town" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
</head>
<body>
<%
    List<Town> towns = (List<Town>) request.getAttribute("towns");
%>
<div style="padding:20px">
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">Registration</h3>
    <form action="SignUpDispatcherServlet" method="post" style="border:1px solid #ccc; padding: 20px;">

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="name" >Name :</label>
                <input id="name" class="form-control" required="true" type="text" name="name"><br/>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="surname" >Surname :</label>
                <input id="surname" class="form-control" required="true" type="text" name="surname"><br/>
            </div>
        </div>
        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="jmbg" >JMBG :</label>
                <input id="jmbg" class="form-control" required="true" type="text" name="jmbg"><br/>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="email">Email :</label>
                <input id="email" class="form-control" required="true" type="text" name="email"><br/>
            </div>
        </div>
        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="username">Username :</label>
                <input id="username" class="form-control" required="true" type="text" name="username"><br/>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="password">Password :</label>
                <input id="password" class="form-control" required="true" type="password" name="password"><br/>
            </div>
        </div>
        <div class="col-md-4">
            <div class="form-outline">
                <label class="input-group-text">Town:</label>
                    <select class="form-control" required="true" name="town" id="r8">
                        <%
                            for (Town town : towns) {
                        %>
                        <option value=<%=town.getId()%>>
                            <%=town.getName()%>
                        </option>
                        <%}%>
                    </select><br/><br/>
            </div>
        </div>


        <div class="col-md-4">
            <button type="submit" class="btn btn-light btn-block mb-4" style="color: blue">Registuj se</button>
        </div>

        <p class="paragraph" >Vec ste registrovani? Idi na <a class="paragraph" href="${pageContext.request.contextPath}/ToLogInServlet">Login page</a></p>
        <p class="paragraph"> Nazad na <a class="paragraph" href="${pageContext.request.contextPath}/HomeDispatcherServlet">Home</a></p>

    </form>
</div>
</body>
</html>

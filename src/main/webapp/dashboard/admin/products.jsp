<%@ page import="java.util.List" %>
<%@ page import="com.example.onlineaplication.ejb.product.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Online Aplikacija - admin</title>
</head>
<body>
<jsp:include page="adminnav.jsp"></jsp:include>
<div  class="table-responsive" style="margin: 30px">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Product Name</th>

        </tr>
        </thead>
        <%
            List<Product> products = (List<Product>) request.getAttribute("productlist");
            for(Product product : products){
        %>
        <tbody>

        <tr>
            <td><%=product.getId()%></td>
            <td><%=product.getProductName()%></td>

        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>

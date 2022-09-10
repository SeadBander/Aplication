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
<div style="margin: 20px">

    <h4>Find product :</h4>
    <form class="d-flex p-3 bg-light w-50" method="post" action="ProductServlet">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="findproduct">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
</div>

<%
    Product product = (Product) request.getAttribute("findedproduct");
%>
<div style="margin: 20px">
    <form class="p-3 bg-light" method="post" action="">
        <div class="row mb-3">
            <label  class="col-sm-2 col-form-label">ProductId</label>
            <div class="col-sm-2">
                <input name="productid" type="text" class="form-control" value="<%= product != null ?product.getId():""%>" readonly>
            </div>
        </div>
        <div class="row mb-3">
            <label  class="col-sm-2 col-form-label">Product Name</label>
            <div class="col-sm-2">
                <input name="productname" type="text" class="form-control" value="<%= product != null ?product.getProductName(): ""%>">
            </div>
        </div>

        <fieldset class="row mb-3">

            <legend class="col-form-label col-sm-2 pt-0">Privilege</legend>

            <div class="col-sm-2">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="privilegeradio"  value="2">
                    <label class="form-check-label" > User </label>
                </div>
            </div>
            <div class="col-sm-2">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="privilegeradio"  value="1" checked>
                    <label class="form-check-label" > Admin </label>
                </div>
            </div>
        </fieldset>

        <button  type="submit" class="btn btn-primary" onclick="form.action = 'EditProductServlet';">Edit</button>
        <button  type="submit" class="btn btn-primary" onclick="form.action = 'RemoveProductServlet';">Remove</button>
    </form>
</div>
</body>
</html>

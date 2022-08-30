<%@ page import="java.util.List" %>
<%@ page import="com.example.onlineaplication.ejb.product.Products" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Aplication</title>
</head>
<body  class="d-flex flex-column min-vh-100">
<jsp:include page="adminnav.jsp"></jsp:include>

<div  class="table-responsive" style="margin: 30px">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Product Id</th>
            <th scope="col">Product Name</th>
            <th scope="col">Amount</th>
            <th scope="col">Aplicant</th>

        </tr>
        </thead>
        <%
            List<Products> productsList = (List<Products>) request.getAttribute("productlist");
            for (Products products : productsList) { %>
        <tbody>
        <tr>
            <td><%=products.getId()%></td>
            <td><%=products.getProductName()%></td>
            <td><%=products.getAmount()%></td>
            <td><%=products.getApplicant()%></td>

        </tr>
        <%}%>

        </tbody>
    </table>
</div>
<p style="color: red; text-align: center"><%=request.getAttribute("message")==null?"":request.getAttribute("message")%></p>


<div style="margin: 20px">

    <h4>Find product :</h4>
    <form class="d-flex p-3 bg-light w-50" method="post" action="ProductServlet">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="findProduct">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
</div>

<%
    Products products = (Products) request.getAttribute("findProduct");
%>
<div style="margin: 20px">
    <form class="p-3 bg-light" method="post" action="">

        <div class="row mb-3">
            <label  class="col-sm-2 col-form-label" hidden>Product Id</label>
            <div class="col-sm-2">
                <input name="productid" type="text" class="form-control" value="<%= products != null ?products.getId():""%>" hidden>
            </div>
        </div>
        <div class="row mb-3">
            <label  class="col-sm-2 col-form-label" hidden>Product Name</label>
            <div class="col-sm-2">
                <input name="productname" type="text" class="form-control" value="<%= products != null ?products.getProductName():""%>" hidden>
            </div>
        </div>
        <div class="row mb-3">
            <label  class="col-sm-2 col-form-label">Amount</label>
            <div class="col-sm-2">
                <input name="amount" type="text" class="form-control" value="<%= products != null ?products.getAmount(): ""%>">
            </div>
        </div>
        <div class="row mb-3">
            <label  class="col-sm-2 col-form-label" hidden>Aplicant</label>
            <div class="col-sm-2">
                <input name="userid" type="text" class="form-control" value="<%= products != null ?products.getApplicant():""%>" hidden>
            </div>
        </div>

        </fieldset>

        <button  type="submit" class="btn btn-primary" onclick="form.action = 'EditProductServlet';">Edit</button>
        <button  type="submit" class="btn btn-primary" onclick="form.action = 'RemoveProductServlet';">Remove</button>
    </form>
</div>
</div>
</body>
</html>

<%@ page import="java.util.List" %>
<%@ page import="com.example.onlineaplication.ejb.product.Product" %>
<%@ page import="com.example.onlineaplication.ejb.product.Product" %>
<%@ page import="com.example.onlineaplication.ejb.loanApplication.LoanApplication" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Aplication</title>
</head>
<body  class="d-flex flex-column min-vh-100">
<jsp:include page="usernav.jsp"></jsp:include>

<div  class="table-responsive" style="margin: 30px">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Product</th>
            <th scope="col">Amount</th>
        </tr>
        </thead>
        <%
            List<LoanApplication> productList = (List<LoanApplication>) request.getAttribute("productlist");
            for (LoanApplication product : productList) { %>
        <tbody>
        <tr>
            <td><%=product.getId()%></td>
            <td><%=product.getProductName()%></td>
            <td><%=product.getAmount()%></td>

        </tr>
        <%}%>

        </tbody>
    </table>
</div>
<div style="margin: 20px">
    <h4>Find product :</h4>
    <form class="d-flex p-3 bg-light w-50" method="post" action="LoanApplicationServlet">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="findproduct">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
</div>

<%
    LoanApplication loanApplication = (LoanApplication) request.getAttribute("findedproduct");
%>
<div style="margin: 20px">
    <form class="p-3 bg-light" method="post" action="">

        <div class="row mb-3">
            <label  class="col-sm-2 col-form-label" >Id</label>
            <div class="col-sm-2">
                <input name="id" type="text" class="form-control" value="<%= loanApplication != null ?loanApplication.getId():""%>" readonly>
            </div>
        </div>
        <%
            List<Product> products = (List<Product>) request.getAttribute("productlist");
        %>
        <div class="input-group mb-3" style="margin-top: 10px">
            <label class="input-group-text" >Products</label>
            <select name="productid" class="form-select w-50" >
                <option  selected>Choose...</option>
                <%
                    for(Product product :products ){
                %>
                <option  value=<%=product.getId()%>><%=product.getProductName()%></option>
                <%}%>
            </select>
        </div>

        <div class="row mb-3">
            <label  class="col-sm-2 col-form-label">Amount</label>
            <div class="col-sm-2">
                <input name="amount" type="text" class="form-control" value="<%= loanApplication != null ?loanApplication.getAmount(): ""%>">
            </div>
        </div>

        </fieldset>
        <button  type="submit" class="btn btn-primary" onclick="form.action = 'AddAppServlet';">Add</button>
        <button  type="submit" class="btn btn-primary" onclick="form.action = 'EditAppServlet';">Edit</button>
        <button  type="submit" class="btn btn-primary" onclick="form.action = 'RemoveAppServlet';">Remove</button>
    </form>
</div>
</body>
</html>

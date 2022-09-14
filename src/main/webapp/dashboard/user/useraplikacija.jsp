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
            <th scope="col">User</th>
        </tr>
        </thead>
        <%
            List<LoanApplication> applist = (List<LoanApplication>) request.getAttribute("applist");
            for (LoanApplication app : applist) { %>
        <tbody>
        <tr>
            <td><%=app.getId()%></td>
            <td><%=app.getProductId().getProductName()%></td>
            <td><%=app.getAmount()%></td>
            <td><%=app.getUserId()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>

<div style="margin: 20px">
    <form class="p-3 bg-light" method="post" action="">

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
                <input name="amount" type="text" class="form-control">
            </div>
        </div>


        </fieldset>
        <button  type="submit" class="btn btn-primary" onclick="form.action = 'AddAppServlet';">Add</button>

    </form>
</div>
</body>
</html>

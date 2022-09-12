<%@ page import="java.util.List" %>
<%@ page import="com.example.onlineaplication.ejb.loanApplication.LoanApplication" %>
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
            <th scope="col">Id</th>
            <th scope="col">ProductId</th>
            <th scope="col">Amount</th>
            <th scope="col">UserId</th>

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
    <h4>Find product :</h4>
    <form class="d-flex p-3 bg-light w-50" method="post" action="LoanApplicationServlet">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="findapp">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
</div>

<%
    LoanApplication loanApplication = (LoanApplication) request.getAttribute("findedapp");
%>
<div style="margin: 20px">
    <form class="p-3 bg-light" method="post" action="">
        <div class="row mb-3">
            <label  class="col-sm-2 col-form-label" >Id</label>
            <div class="col-sm-2">
                <input name="id" type="text" class="form-control" value="<%= loanApplication != null ?loanApplication.getId():""%>" readonly>
            </div>
        </div>
        <div class="row mb-3">
            <label  class="col-sm-2 col-form-label" >Product</label>
            <div class="col-sm-2">
                <input name="productId" type="text" class="form-control" value="<%= loanApplication != null ?loanApplication.getProductId():""%>" >
            </div>
        </div>
        <div class="row mb-3">
            <label  class="col-sm-2 col-form-label">Amount</label>
            <div class="col-sm-2">
                <input name="amount" type="text" class="form-control" value="<%= loanApplication != null ?loanApplication.getAmount(): ""%>">
            </div>
        </div>
        <div class="row mb-3">
            <label  class="col-sm-2 col-form-label" >User</label>
            <div class="col-sm-2">
                <input name="userId" type="text" class="form-control" value="<%= loanApplication != null ?loanApplication.getUserId():""%>" >
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

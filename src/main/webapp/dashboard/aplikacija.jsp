<%@ page import="com.example.onlineaplication.ejb.user.Users" %>
<%@ page import="com.example.onlineaplication.sesija.Session" %>
<%@ page import="com.example.onlineaplication.ejb.loanApplication.LoanApplication" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.onlineaplication.ejb.loanApplication.LoanApplication" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/loanApplication.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
            crossorigin="anonymous"></script>
    <title>Aplikacija</title>

</head>
<body>

<div class="card">
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">
        Aplikacije
    </h3>
    <div style="padding: 20px">
        <%
            LoanApplication edit = (LoanApplication) request.getAttribute("edit");
            String action = edit == null ? "add" : "edit";

            String buttonText = edit == null ? "add" : "edit";
            List<LoanApplication> aplikacije = (List<LoanApplication>) request.getAttribute("aplikacije");
        %>
        <form action="<%=action%>" method="post" class="row g-3 needs-validation" novalidate>
            <div class="col-md-4">
                <div class="form-outline">
                    <label class="form-label" for="products">Products</label>
                    <input type="text" id="products"
                           class="form-control" name="products"
                           value="<%=edit != null ? edit.getProducts() : ""%>"/>
                </div>
            </div>

            <input name="proizvodId" type="hidden" value="<%=edit != null ? edit.getProductId() : ""%>" />
            <div class="col-8" style="padding: 20px;">
                <button class="btn btn-primary" type="submit"><%=buttonText%></button>
                <button class="btn btn-link" type="button" onclick="location.href = '${pageContext.request.contextPath}/ToViewServlet';">Nazad</button>
            </div>
        </form>
    </div>



    <div class="card-body" style="padding: 20px;">
        <div id="table" class="table-editable">
                    <span class="table-add float-right mb-3 mr-2">
                        <a href="#!" class="text-success"><i class="fas fa-plus fa-2x" aria-hidden="true"></i></a>
                    </span>
            <table class="table table-bordered table-responsive-md table-striped text-center">
                <thead>
                <tr>
                    <th class="text-center">Edit</th>
                    <th class="text-center">Remove</th>
                    <th class="text-center">Add</th>
                    <th class="text-center">Products</th>
                    <th class="text-center">Users</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (LoanApplication loanApplication : aplikacije) {
                %>
                <tr>
                    <td>
                                    <span class="table-remove">
                                        <form action="EditProductServlet" method="POST">
                                            <button type="submit" class="btn btn-primary btn-rounded btn-sm my-0">
                                                Edit
                                            </button>
                                            <input name="id" type="hidden" value="<%=loanApplication.getProducts()%>"/>
                                        </form>

                                    </span>
                    </td>
                    <td>

                        <span class="table-remove">
                                        <form action="RemoveProductServlet" method="POST">
                                            <button type="submit" class="btn btn-danger btn-rounded btn-sm my-0">
                                                Remove
                                            </button>
                                            <input name="id" type="hidden" value="<%=loanApplication.getProducts()%>"/>
                                        </form>
                                    </span>

                    </td>
                    <td>
                                    <span class="table-remove">
                                        <form action="AddProductServlet" method="POST">
                                            <button type="submit" class="btn btn-danger btn-rounded btn-sm my-0">
                                                Add
                                            </button>
                                            <input name="id" type="hidden" value="<%=loanApplication.getProducts()%>"/>
                                        </form>
                                    </span>
                    </td>
                    <td  class="pt-3-half" contenteditable="true"><%=loanApplication.getProducts()%></td>

                    <td  class="pt-3-half" contenteditable="true"><%=loanApplication.getUserId()%></td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>

</html>

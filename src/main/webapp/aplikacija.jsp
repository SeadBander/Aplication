<%@ page import="com.example.onlineaplication.ejb.klijenti.Klijenti" %>
<%@ page import="com.example.onlineaplication.sesija.KlijentiSesija" %>
<%@ page import="com.example.onlineaplication.ejb.aplikacija.Aplikacija" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="aplikacija.css">
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
            Aplikacija uredi = (Aplikacija) request.getAttribute("uredi");
            String action = uredi == null ? "dodaj" : "azuriraj";

            String buttonText = uredi == null ? "Dodaj" : "Azuriraj";
            List<Aplikacija> aplikacije = (List<Aplikacija>) request.getAttribute("aplikacije");
        %>
        <form action="<%=action%>" method="post" class="row g-3 needs-validation" novalidate>
            <div class="col-md-4">
                <div class="form-outline">
                    <label class="form-label" for="proizvod">Proizvod</label>
                    <input type="text" id="proizvod"
                           class="form-control" name="proizvod"
                           value="<%=uredi != null ? uredi.getProizvodi() : ""%>"/>
                </div>
            </div>

            <input name="proizvodId" type="hidden" value="<%=uredi != null ? uredi.getIdProizvoda() : ""%>" />
            <div class="col-8" style="padding: 20px;">
                <button class="btn btn-primary" type="submit"><%=buttonText%></button>
                <button class="btn btn-link" type="button" onclick="location.href = '${pageContext.request.contextPath}/dashboardAccess';">Nazad</button>
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
                    <th class="text-center">Izmjeni</th>
                    <th class="text-center">Izbrisi</th>
                    <th class="text-center">Dodaj</th>
                    <th class="text-center">Proizvod</th>
                    <th class="text-center">Korisnik</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Aplikacija aplikacija : aplikacije) {
                %>
                <tr>
                    <td>
                                    <span class="table-remove">
                                        <form action="uredi" method="POST">
                                            <button type="submit" class="btn btn-primary btn-rounded btn-sm my-0">
                                                Uredi
                                            </button>
                                            <input name="proizvodId" type="hidden" value="<%=aplikacija.getIdProizvoda()%>"/>
                                        </form>

                                    </span>
                    </td>
                    <td>

                        <span class="table-remove">
                                        <form action="izbrisi" method="POST">
                                            <button type="submit" class="btn btn-danger btn-rounded btn-sm my-0">
                                                Izbrisi
                                            </button>
                                            <input name="proizvodId" type="hidden" value="<%=aplikacija.getIdProizvoda()%>"/>
                                        </form>
                                    </span>

                    </td>
                    <td>
                                    <span class="table-remove">
                                        <form action="izbrisi" method="POST">
                                            <button type="submit" class="btn btn-danger btn-rounded btn-sm my-0">
                                                Dodaj
                                            </button>
                                            <input name="proizvodId" type="hidden" value="<%=aplikacija.getIdProizvoda()%>"/>
                                        </form>
                                    </span>
                    </td>
                    <td  class="pt-3-half" contenteditable="true"><%=aplikacija.getProizvodi()%></td>

                    <td  class="pt-3-half" contenteditable="true"><%=aplikacija.getIdKlijenta()%></td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>

</html>

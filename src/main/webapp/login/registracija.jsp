<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registracija</title>
    <link rel="stylesheet" type="text/css" href="registracija.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
</head>
<body>

<form action="login.jsp" method="post" style="border:1px solid #ccc; padding: 20px;">
<section class="h-100 bg-dark">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card card-registration my-4">
                    <div class="row g-0">
                        <div class="col-xl-6 d-none d-xl-block">
                            <img src="/css/slika1.jpg"
                                 alt="Sample photo" class="img-fluid"
                                 style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
                        </div>
                        <div class="col-xl-6">
                            <div class="card-body p-md-5 text-black">
                                <h3 class="mb-5 text-uppercase">REGISTRACIJA</h3>

                                <div class="row">
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <input type="text" id="form3Example1m" class="form-control form-control-lg" />
                                            <label class="form-label" for="form3Example1m">Ime</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <input type="text" id="form3Example1n" class="form-control form-control-lg" />
                                            <label class="form-label" for="form3Example1n">Prezime</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <input type="text" id="form3Example1o" class="form-control form-control-lg" />
                                            <label class="form-label" for="form3Example1o">Telefon</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <input type="text" id="form3Example1p" class="form-control form-control-lg" />
                                            <label class="form-label" for="form3Example1p">JMBG</label>
                                        </div>
                                    </div>

                                </div>
                                <div class="col-md-4">
                                    <div class="form-outline">
                                        <label class="form-label" for="grad">Town: </label>
                                        <select id="grad" class="form-control" required="true" name="grad">
                                            <c:forEach items="${gradList}" var="grad">
                                                <option>${grad}</option>
                                            </c:forEach>
                                        </select><br/><br/>
                                    </div>
                                </div>


                                <div class="form-outline mb-4">
                                    <input type="text" id="form3Example97" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example97">Email</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="username" id="form3Example98" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example98">Username</label>
                                </div>

                                <div class="form-outline mb-4">
                                    <input type="password" id="form3Example99" class="form-control form-control-lg" />
                                    <label class="form-label" for="form3Example99">Password</label>
                                </div>

                                <div class="d-flex justify-content-end pt-3">
                                    <button type="button" class="btn btn-light btn-lg" onclick="location.href = 'login.jsp'">Nazad na login stranicu</button>
                                    <button type="button" class="btn btn-warning btn-lg ms-2" >Registuj se!</button>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</form>
</body>
</html>
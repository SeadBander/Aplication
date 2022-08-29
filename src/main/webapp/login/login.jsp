<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
            crossorigin="anonymous"></script>
    <title>LOGIN</title>
</head>
<body>
<div>
    <section class="background-radial-gradient overflow-hidden">
        <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                    <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                        Dobrodosli <br />
                        <span style="color: hsl(218, 81%, 75%)">Molim vas unesite Vase pristupne podatke</span>
                    </h1>
                    <h3 class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
                        Ukoliko niste registrovani pristupite linku za registraciju
                    </h3>
                </div>
                <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>
                    <div class="card bg-glass">
                        <div class="card-body px-4 py-5 px-md-5">
                            <form action="LoginDispatcherServlet" method="post" class="login-form">
                                <div class="form-outline mb-4">
                                    <label for="username" class="text-uppercase">Username</label>
                                    <input id="username" name="username" type="text" class="form-control" placeholder="Username">
                                </div>
                                <div class="form-outline mb-4">
                                    <label for="password" class="text-uppercase">Password</label>
                                    <input id="password" name="password" type="password" class="form-control" placeholder="password">
                                </div>
                                <button type="submit" class="btn btn-primary btn-block mb-4">
                                    Login
                                </button>
                            </form>
                            <p class="paragraph" > Zelis se <a class="paragraph" href="${pageContext.request.contextPath}/ToSignUpServlet">registrovati?</a></p>
                            <p class="paragraph"> Nazad na <a class="paragraph" href="${pageContext.request.contextPath}/HomeDispatcherServlet">Home</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>

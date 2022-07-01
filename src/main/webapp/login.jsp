<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="login.css">
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
                        Dobrodosli na <br />
                        <span style="color: hsl(218, 81%, 75%)">Bank Online Application platformu</span>
                    </h1>
                    <h3 class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
                        Ovdje mozete aplicirati online za bankarski proizvod prema Vasim potrebama
                    </h3>
                </div>
                <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>
                    <div class="card bg-glass">
                        <div class="card-body px-4 py-5 px-md-5">
                            <form action="ulaz" method="post" class="login-form">
                                <div class="form-outline mb-4">
                                    <input type="text" id="form3Example3" class="form-control" />
                                    <label class="form-label" for="form3Example3">Username</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="password" id="form3Example4" class="form-control" />
                                    <label class="form-label" for="form3Example4">Password</label>
                                </div>
                                <button type="submit" class="btn btn-primary btn-block mb-4">
                                    Login
                                </button>
                                <div class="text-center">
                                    <a href="registracija" class="btn btn-link"> Registuj se!!!</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>

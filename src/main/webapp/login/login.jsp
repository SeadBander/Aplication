<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="login.css">
    <title>Login</title>
</head>
<body>

<section class="login-block">
    <div class="container">
        <img src="css/slika2.jpg" alt="OnlineAplication" class="avatar">
        <div class="row">
            <div class="col-md-4 login-sec">
                <h1 style="color: aliceblue ">Dobrodošli na Bank Online Application platformu</h1>
                <h2 style="color: burlywood">Ovdje možete aplicirati online za bankarski proizvod prema Vašim potrebama</h2>

                <form action="ulaz" method="post" class="login-form">
                    <div class="form-group">
                        <label for="username" class="text-uppercase">Username</label>
                        <input id="username" name="username" type="text" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="password" class="text-uppercase">Password</label>
                        <input id="password" name="password" type="password" class="form-control" placeholder="">
                    </div>

                    <div style="margin-bottom: 20px">
                        <button type="submit" class="btn  btn-info btn-lg btn-block">Login</button>
                    </div>
                    <a href="login/registracija.jsp" class="btn btn-link">
                        Registuj se !!!
                    </a>
                </form>
            </div>

            </div>
        </div>
    </div>
</section>

</body>
</html>


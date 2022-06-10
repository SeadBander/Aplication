<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registracija</title>
    <link rel="stylesheet" type="text/css" href="registracija.css">
</head>
<body>
<div style="padding:20px">
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">Registracija korisnika</h3>

    <!-- Form input fields -->
    <form action="register" method="post" style="border:1px solid #ccc; padding: 20px;">

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="name" id="fn">Name :</label>
                <input id="name" class="form-control" required="true" type="text" name="name"><br/>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="surname" id="ln">Surname :</label>
                <input id="surname" class="form-control" required="true" type="text" name="surname"><br/>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="username">Username :</label>
                <input id="username" class="form-control" required="true" type="text" name="username"><br/>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="password">Password :</label>
                <input id="password" class="form-control" required="true" type="password" name="password"><br/>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="email">Email :</label>
                <input id="email" class="form-control" required="true" type="text" name="email"><br/>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="contact">Contact :</label>
                <input id="contact" class="form-control" required="true" type="text" name="contact"><br/>
            </div>
        </div>
        <div class="col-md-6">
            <button class="col-md-8 btn btn-info" type="submit" value="Submit">Registruj se</button>
            <button class="col-md-8 btn btn-link" type="button" onclick="location.href = 'login.jsp';">Nazad na
                login stranicu
            </button>
        </div>
    </form>
</div>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registracija</title>
    <link rel="stylesheet" type="text/css" href="login/registracija.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
</head>
<body>
<div style="padding:20px">
    <h3 class="container">Registracija korisnika</h3>

    <form action="registracija" method="post" style="border:1px solid #ccc; padding: 20px;">

        <div class="container">
                <label class="form-label" for="name" id="fn">Ime :</label>
                <input id="name" class="form-control" required="true" type="text" name="name"><br/>
        </div>

        <div class="container">
                <label class="form-label" for="surname" id="ln">Prezime :</label>
                <input id="surname" class="form-control" required="true" type="text" name="surname"><br/>
        </div>

        <div class="container">
                <label class="form-label" for="spol" id="lp">Spol :</label>
                <input id="spol" class="form-control" required="true" type="text" name="spol"><br/>
        </div>

        <div class="container">
                <label class="form-label" for="jmbg" id="lm">JMBG :</label>
                <input id="jmbg" class="form-control" required="true" type="text" name="jmbg"><br/>
        </div>

        <div class="container">
                <label class="form-label" for="email">Email :</label>
                <input id="email" class="form-control" required="true" type="text" name="email"><br/>
        </div>

        <div class="container">
                <label class="form-label" for="username">Username :</label>
                <input id="username" class="form-control" required="true" type="text" name="username"><br/>
        </div>

        <div class="container">
                <label class="form-label" for="password">Password :</label>
                <input id="password" class="form-control" required="true" type="password" name="password"><br/>
        </div>

        <div class="container">
                <label class="form-label" for="grad">Grad :</label>
                <input id="grad" class="form-control" required="true" type="text" name="grad"><br/>

        </div>

        <div class="col-md-6">
            <button class="col-md-8 btn btn-info" type="submit" value="Submit">Registruj se</button>
            <button class="col-md-8 btn btn-link" type="button" onclick="location.href = 'login.jsp'">Nazad na login stranicu</button>
        </div>
    </form>
</div>
</body>
</html>


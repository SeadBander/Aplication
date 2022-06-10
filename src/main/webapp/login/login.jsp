<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/login.css">
    <title>Login</title>
</head>
<body>
<form>
    <div class="imgcontainer">
        <h1 style="color: aliceblue ">Dobrodošli na Bank Online Application platformu</h1>
        <h2 style="color: burlywood">Ovdje možete aplicirati online za bankarski proizvod prema Vašim potrebama</h2>
    </div>
    <div class="container">
    <img src="../css/slika2.jpg" alt="OnlineAplication" class="avatar">
    </div>

    <div class="login">
                <label id="username" for="username"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required>
                <label id="password" for="password"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" required>
                <button type="submit" class="submit-button">Log in</button>
    </div>
    <a href="registracija.jsp" style="color: white" >
        REGISTUJ SE!
    </a>
</form>
</body>
</html>


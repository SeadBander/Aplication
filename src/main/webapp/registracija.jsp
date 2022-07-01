<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="registracija.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
    <title>Registracija</title>
</head>
<body>
<section class="intro">
    <div class="bg-image h-130" style="background-image: url('css/slika2.jpg');">
        <div class="mask d-flex align-items-center h-130">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12 col-md-10 col-lg-7 col-xl-6">
                        <div class="card mask-custom">
                            <div class="card-body p-5 text-black">
                                <div class="my-4">
                                    <h1 class="text-center mb-5">Registracija</h1>
                                    <form>
                                        <div class="row">
                                            <div class="col-12 col-md-6 mb-4">
                                                <div class="form-outline form-white">
                                                    <input type="text" id="form3Example1" class="form-control form-control-lg" />
                                                    <label class="form-label" for="form3Example1">Ime</label>
                                                </div>
                                            </div>
                                            <div class="col-12 col-md-6 mb-4">
                                                <div class="form-outline form-white">
                                                    <input type="text" id="form3Example2" class="form-control form-control-lg" />
                                                    <label class="form-label" for="form3Example2">Prezime</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-12 col-md-6 mb-4">
                                                <div class="form-outline form-white">
                                                    <input type="text" id="form3Example3" class="form-control form-control-lg" />
                                                    <label class="form-label" for="form3Example3">Broj telefona</label>
                                                </div>
                                            </div>
                                            <div class="col-12 col-md-6 mb-4">
                                                <div class="form-outline form-white">
                                                    <input type="text" id="form3Example4" class="form-control form-control-lg" />
                                                    <label class="form-label" for="form3Example4">JMBG</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-outline form-white mb-4">
                                            <input type="email" id="form3Example5" class="form-control form-control-lg" />
                                            <label class="form-label" for="form3Example5">Email</label>
                                        </div>
                                        <div class="form-outline form-white mb-4">
                                            <input type="text" id="form3Example6" class="form-control form-control-lg" />
                                            <label class="form-label" for="form3Example6">Username</label>
                                        </div>
                                        <div class="form-outline form-white mb-4">
                                            <input type="password" id="form3Example7" class="form-control form-control-lg" />
                                            <label class="form-label" for="form3Example7">Password</label>
                                        </div>
                                        <div class="form-outline form-white mb-4">
                                                <label class="form-label" for="form3Example8">Town: </label>
                                                <select id="form3Example8" class="form-control form-control-lg" required="true" name="grad">
                                                    <c:forEach items="${gradovi}" var="grad">
                                                        <option>${grad}</option>
                                                    </c:forEach>
                                                </select><br/><br/>
                                        </div>
                                        <button type="submit" class="btn btn-light btn-block mb-4" style="color: blue">Registuj se</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
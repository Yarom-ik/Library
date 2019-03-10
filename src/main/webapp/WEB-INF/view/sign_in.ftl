<html>
<head>
    <title>Бибилиотека</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<#--<style>-->
<#--body{-->
<#--padding:20px;-->
<#--}-->
<#--</style>-->
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
    <a class="navbar-brand" href="#">
        <img src="https://cdn.fishki.net/upload/post/2017/03/19/2245758/tn/02-funny-cat-wallpapercat-wallpaper.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
        Электронная библиотека УОР</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Каталог книг </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Выдача книг </a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Читатели
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Список читателей</a>
                    <a class="dropdown-item" href="#">Another action</a>

                </div>
            </li>
            <li>
            <#--<#if role??>-->
            <#--${auth}-->
            <#--${role}-->
            <#--</#if>-->


                <a href="/logout" class="btn btn-primary btn-lg " tabindex="-1" role="button" aria-disabled="true">Logout</a>

            </li>

        </ul>

    </div>
</nav>

<form action="/login/process" method="post" >
    <div class="container col-md-2 mt-5">
        <div class="form-group" >
            <label for="exampleInputEmail1">Login</label>
            <input type="text" name="login" class="form-control" id="exampleInputLogin" aria-describedby="emailHelp" placeholder="Введите логин">

        </div>
        <div class="form-group">
            <label for="exampleInputPassword">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword" placeholder="Пароль">
        </div>

        <button type="submit" class="btn btn-primary">Войти</button>
    </div>
</form>
<#if error??>
<p>Ошибка авторизации </p>
</#if>




<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>


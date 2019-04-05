<html>
<head>
    <title>Бибилиотека</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

    <!-- Custom styles for this template -->
    <link href="/resources/css/floating-labels.css" rel="stylesheet">
</head>
<body>

        <form class="form-signin" action="/login/process" method="post">
            <div class="text-center mb-4">
                <img class="mb-4" src="/resources/image/logo.png" alt="" width="72" height="72">
                <h1 class="h3 mb-3 font-weight-normal">Библиотека "ГрГУОР"</h1>
                <p>Для входа в систему введите логин и пароль, если требуется проверить задолженность по книгам - нажмите проверить задолженность </p>
            </div>

            <div class="form-label-group">
                <input type="text" name="login" id="exampleInputLogin" class="form-control" placeholder="Введите логин" required autofocus>
                <label for="inputEmail">Логин</label>
            </div>

            <div class="form-label-group">
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Введите пароль" required>
                <label for="inputPassword">Пароль</label>
            </div>
        <#if error??>
        <div class="alert alert-danger" role="alert">
            Ошибка авторизации!
        </div>
        </#if>

            <button class="btn btn-lg btn-success btn-block" type="submit">Войти</button>
            <#--<button class="btn btn-lg btn-primary btn-block" type="submit">Проверить задолженность</button>-->
            <a href="/checkReadersBooks" data-turbolinks="false" class="btn btn-lg btn-primary btn-block" role="button" >Проверить задолженность</a>
            <p class="mt-5 mb-3 text-muted text-center">&copy; 2019</p>
        </form>

</body>
</html>


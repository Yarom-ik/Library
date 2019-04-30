<html>
<head>
    <title>Восстановление пароля</title>
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

    <script type="text/javascript" src="/resources/js/jquery-3.3.1.min.js"></script>
    <script src="/resources/js/jquery.maskedinput.min.js"></script>
</head>
<body>

        <form class="form-signin" action="/sendEmail" method="post">
            <div class="text-center mb-4">
                <img class="mb-4" src="/resources/image/logo.png" alt="" width="72" height="72">
                <h1 class="h3 mb-3 font-weight-normal">Библиотека "ГрГУОР"</h1>
                <p>Для восстановления пароля введите свой логин, пароль для доступа к сайту будет отправлен на Ваш email </p>
            </div>

        <#if registationMessage?has_content>
            <div class="alert alert-info" role="alert">
            ${registationMessage} <a href="/">Войти</a>
            </div>
        </#if>

            <div class="form-label-group">
                <input type="text" name="login" id="exampleInputLogin" class="form-control ${(loginError??)?string('is-invalid', '')}"
                       value="<#if login??>${login}</#if>" placeholder="Введите логин" required autofocus>
                <label for="inputLogin">Логин</label>
            <#if loginError??>
                <div class="invalid-feedback">
                ${loginError}
                </div>
            </#if>
            </div>


            <button class="btn btn-lg btn-success btn-block" type="submit">Отправить</button>
            <a class="btn btn-lg btn-primary btn-block" href="/" role="button">Отмена</a>

            <p class="mt-5 mb-3 text-muted text-center">&copy; 2019</p>
        </form>

</body>
</html>


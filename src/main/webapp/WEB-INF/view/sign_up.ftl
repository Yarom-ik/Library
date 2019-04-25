<html>
<head>
    <title>Регистрация</title>
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

        <form class="form-signin" action="/sign_up" method="post">
            <div class="text-center mb-4">
                <img class="mb-4" src="/resources/image/logo.png" alt="" width="72" height="72">
                <h1 class="h3 mb-3 font-weight-normal">Библиотека "ГрГУОР"</h1>
                <p>Для регистрации введите следующие данные </p>
            </div>

            <div class="form-label-group">
                <input type="text" name="login" id="exampleInputLogin" class="form-control ${(loginError??)?string('is-invalid', '')}"
                       value="<#if userNew??>${userNew.login}</#if>" placeholder="Введите логин" required autofocus>
                <label for="inputLogin">Логин</label>
            <#if loginError??>
                <div class="invalid-feedback">
                ${loginError}
                </div>
            </#if>
            </div>

            <div class="form-label-group">
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Введите пароль" required>
                <label for="inputPassword">Пароль</label>
            </div>
            <div class="form-label-group">
                <input type="email" name="email" id="inputEmail" class="form-control ${(emailError??)?string('is-invalid', '')}"
                       value="<#if userNew??>${userNew.email}</#if>" placeholder="Введите email" required>
                <label for="inputEmail">Email</label>
            <#if emailError??>
                <div class="invalid-feedback">
                ${emailError}
                </div>
            </#if>
            </div>
            <div class="form-label-group">
                <input type="text" name="firstName" id="inputFirstName" class="form-control ${(firstNameError??)?string('is-invalid', '')}"
                       value="<#if readerNew??>${readerNew.firstName}</#if>" placeholder="Введите Фамилию" required >
                <label for="inputFirstName">Фамилия</label>
            <#if firstNameError??>
                <div class="invalid-feedback">
                ${firstNameError}
                </div>
            </#if>
            </div>
            <div class="form-label-group">
                <input type="text" name="lastName" id="inputLastName" class="form-control ${(lastNameError??)?string('is-invalid', '')}"
                       value="<#if readerNew??>${readerNew.lastName}</#if>"  placeholder="Введите логин" required autofocus>
                <label for="inputLastName">Имя</label>
            <#if lastNameError??>
                <div class="invalid-feedback">
                ${lastNameError}
                </div>
            </#if>
            </div>
            <div class="form-label-group">
                <input type="text" name="middleName" id="inputMiddleName" class="form-control ${(middleNameError??)?string('is-invalid', '')}"
                       value="<#if readerNew??>${readerNew.middleName}</#if>" placeholder="Введите логин" required autofocus>
                <label for="inputMiddleName">Отчество</label>
            <#if middleNameError??>
                <div class="invalid-feedback">
                ${middleNameError}
                </div>
            </#if>
            </div>
            <div class="form-label-group">
                <input type="text" name="telephone" id="inputTelephone" class="form-control ${(telephoneError??)?string('is-invalid', '')}"
                       value="<#if readerNew??>${readerNew.telephone}</#if>" placeholder="Введите логин" >
                <label for="inputTelephone">Телефон</label>
            <#if telephoneError??>
                <div class="invalid-feedback">
                ${telephoneError}
                </div>
            </#if>
            </div>

            <script>
                //    запрет ввода пробелов
                $('input').keyup(function(){
                    str = $(this).val()
                    str = str.replace(/\s/g,'')
                    $(this).val(str)
                });
                $(function() {
                    //задание масски ввода телефона
                    $("#inputTelephone").mask("375(99)999-99-99");

                });
            </script>

        <#if RegistationOK??>
        <div class="alert alert-success" role="alert">
            Регистрация прошла успешно! <a href="/">Войти</a>
        </div>
        </#if>

            <button class="btn btn-lg btn-success btn-block" type="submit">Зарегистрироваться</button>
            <#--<button class="btn btn-lg btn-primary btn-block" type="submit">Проверить задолженность</button>-->

            <p class="mt-5 mb-3 text-muted text-center">&copy; 2019</p>
        </form>

</body>
</html>


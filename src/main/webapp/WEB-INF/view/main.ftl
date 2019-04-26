<#include "security.ftl">
<#macro main title>
<html>
<head>
    <title>${title}</title>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS, js -->
    <#--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">-->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <!--Turbolinks-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/turbolinks/5.2.0/turbolinks.js"></script>

    <script type="text/javascript" src="/resources/js/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

    <script src="/resources/js/bootstrap3-typeahead.js"></script>
    <script src="/resources/js/jquery.maskedinput.min.js"></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    <style>
        .btn-circle {
            width: 18px;
            height: 18px;
            border-radius: 35px;
            text-align: center;
            padding-left: 0;
            padding-right: 0;
            font-size: 7px;
            white-space: normal; /* восстанавливаем свойству значение по умолчанию */
        }
        .btn-table {
            width: 25px;
            height: 25px;
            text-align: center;
            padding-left: 0;
            padding-right: 0;
            font-size: 11px;
            white-space: normal; /* восстанавливаем свойству значение по умолчанию */
        }
        .layer {
            width: 190px; /* Ширина блока */
            height: 300px; /* Высота блока */
            padding: 10px; /* Поля вокруг текста */
            overflow: auto;
        }
        /*.give {*/
            /*margin-left: 20;*/
            /*overflow: auto;*/
        /*}*/
        /*futer*/
        .footer {
            background-color: #f5f5f5;
        }

    </style>
</head>
<body class="d-flex flex-column h-100">

<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })
</script>

<div>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #f5f5f5;">

    <a class="navbar-brand" href="/books">
        <img src="/resources/image/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
        Электронная библиотека УОР</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <#if isReader || isAdmin || isLibrary>
            <li class="nav-item">
                <a class="nav-link" href="/books">Каталог книг </a>
            </li>
            </#if>
            <#if isAdmin || isLibrary>
            <li class="nav-item ">
                <a class="nav-link" href="/orders">Выдача книг </a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/readers">Читатели </a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Редактор
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item btn" href="/bookAdd">Добавить книгу</a>
                    <a class="dropdown-item btn" role="button" href="/categoryes" >Категори</a>
                    <a class="dropdown-item btn" role="button"  href="/readerAdd">Добавить читателя</a>
                </div>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/statistic">Статистика </a>
            </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/admin">Панель администратора</a>
                </li>
            </#if>
            <#if isReader>
                <li class="nav-item">
                    <a class="nav-link" href="/checkReadersBooks">Взятые книги</a>
                </li>
            </#if>

        </ul>

        <#--отображаем зарегистрированного пользователя-->
        <div class="nav-item dropdown">
            <a class="nav-item nav-link dropdown-toggle mr-md-2" style="color: #a4a4a4" href="#"  data-toggle="dropdown"> <img src="/resources/image/profle.png">
                ${nameUserLogin}</a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="bd-versions">
                <a class="dropdown-item btn" href="/editPassword"> Изменить пароль</a>
             </div>
        </div>
        <a href="/logout" class="btn btn-outline-secondary btn-sm" tabindex="-1" role="button" aria-disabled="true">Выход</a>
    </div>

</nav>
</div>

<div class="container-fluid">
    <div class="row">
        <#--<div class="col-md-2"> <#include "contentLeft.ftl"/></div>-->
            <div class="col-md-2"> <@contentLeft/></div>
        <div class="col-md-10"> <@content/> </div>
    </div>
</div>

<footer class="footer mt-auto py-2">
    <div class="container" style="width: auto; max-width: fit-content; padding: 0 15px;">
        <span class="text-muted">2019 Библиотека УО "ГрГУОР"</span>
    </div>
</footer>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<#--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>-->



</body>
</html>
</#macro>
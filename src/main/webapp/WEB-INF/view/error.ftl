<html>
<head>
    <title>Ошибка</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


</head>
<body>

<main role="main" class="container ">
    <div class="jumbotron text-center">
        <img class="mb-4" src="/resources/image/error.png" alt="" width="100" height="100">
        <h1>ОШИБКА!</h1>
        <p class="lead">что-то сломалось...</p>
    <#if message?has_content>
        <p class="lead">Сообщение: ${message}</p>
    </#if>
        <a class="btn btn-lg btn-primary" href="/books" role="button">На главную &raquo;</a>
    </div>
</main>

<#--<form class="form-signin">-->
    <#--<div class="text-center mb-4">-->
        <#--<img class="mb-4" src="/resources/image/error.png" alt="" width="100" height="100">-->
        <#--<h1 class="h3 mb-3 font-weight-normal">ОШИБКА!</h1>-->
        <#--<p>что-то сломалось... </p>-->
    <#--</div>-->

    <#--<div class="form-label-group">-->
        <#--<h6>Сообщение:</h6>-->
    <#--<#if message?has_content>-->
        <#--<p>${message}</p>-->
    <#--</#if>-->
    <#--</div>-->

    <#--<a href="/books" class="btn btn-lg btn-primary btn-block" role="button" >На главную</a>-->

<#--</form>-->

</body>
</html>









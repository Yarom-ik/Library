<html>
<head>
    <title>Бибилиотека</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        body {
            display: block;
        }
    </style>

    <!-- Custom styles for this template -->
    <link href="/resources/css/floating-labels.css" rel="stylesheet">
</head>
<body>

<form class="form-signin" action="/login/process" method="post">
    <div class="text-center mb-4">
        <img class="mb-4" src="/resources/image/error.png" alt="" width="100" height="100">
        <h1 class="h3 mb-3 font-weight-normal">ОШИБКА!</h1>
        <p>что-то сломалось... </p>
    </div>

    <div class="form-label-group">
        <h6>Сообщение:</h6>
    <#if message?has_content>
        <p>${message}</p>
    </#if>
    </div>

    <a href="/books" class="btn btn-lg btn-primary btn-block" role="button" >На главную</a>

</form>

</body>
</html>









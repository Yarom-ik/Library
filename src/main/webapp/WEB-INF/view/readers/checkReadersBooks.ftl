<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Проверка взятых книг</title>
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
<body class="d-flex flex-column h-100">
<header>
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #f5f5f5;">

        <a class="navbar-brand" href="/books">
            <img src="/resources/image/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
            Электронная библиотека УОР</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

    </nav>
</header>
<br>

<main role="main" class="flex-shrink-0">
    <div class="container">
        <div class="card text-center">
            <div class="card-header">
                <h6>Проверка взятых книг</h6>
            </div>
            <div class="card-body">
            <#--<h5 class="card-title">Специальный заголовок</h5>-->
                <p class="card-text">Для поиска введите свою фамилию, имя и отчество </p>
                <form method="get" action="/checkReadersBooks">
                    <div class="input-group">
                        <input type="text" name="fio" value="<#if fio??>${fio}</#if>" class="form-control ${(fioError??)?string('is-invalid', '')}"
                               placeholder="Введите фио" aria-label="Recipient's username" aria-describedby="button-addon2" required>
                        <span class="form-control-clear glyphicon glyphicon-remove form-control-feedback hidden"></span>
                        <div class="input-group-append">
                            <button class="btn btn-outline-success" type="submit" role="button" id="button-addon2">Проверить</button>
                        </div>
                    <#if fioError??>
                        <div class="invalid-feedback">
                        ${fioError}
                        </div>
                    </#if>
                    </div>
                </form>
            </div>
        <#if booksNotFinish?has_content>
            <div class="container mb-3">
                <a href="/checkReadersBooks" class="btn btn-outline-primary" role="button">Очистить параметры поиска</a>
            </div>
            <div class="container">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">№</th>
                        <th scope="col">Название</th>
                        <th scope="col">Автор</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#global num=0>
                        <#list booksNotFinish as book>
                            <#global num = num+1>
                        <tr>
                            <th scope="row">#{num }</th>
                            <td>${book.catalogBooks.name}</td>
                            <td>${book.catalogBooks.author.authorName}</td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </#if>
        </div>
    <#if status?has_content>
        <div class="alert alert-secondary alert-dismissible fade show" role="alert">
        ${status}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
    </div>
</main>

<footer class="footer mt-auto py-3">
    <div class="container" style="width: auto; max-width: fit-content;">
        <span class="text-muted">Place sticky footer content here.</span>
    </div>
</footer>

<#--<script src="/resources/js/jquery-3.3.1.slim.min.js"></script>-->
<#--<script src="/resources/js/bootstrap.min.js"></script>-->
</body>
</html>
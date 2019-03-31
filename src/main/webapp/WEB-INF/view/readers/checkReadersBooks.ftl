<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Проверка взятых книг</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <#--<script src="/resources/js/jquery-3.3.1.slim.min.js"></script>-->
    <#--<script src="/resources/js/bootstrap.min.js"></script>-->

    <#--<script src="https://raw.githubusercontent.com/gesquive/bootstrap-add-clear/v1.0.7/bootstrap-add-clear.js"></script>-->
    <#--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
    <style>
        .clear-input > span {
            position: absolute;
            right: 24px;
            top: 10px;
            height: 14px;
            margin: auto;
            font-size: 14px;
            cursor: pointer;
            color: #AAA;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #f5f5f5;">

    <a class="navbar-brand" href="/books">
        <img src="/resources/image/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
        Электронная библиотека УОР</a>
</nav>
<br>

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


<script>
    function $(document).ready(function() {
        $(".clear-input>span").click(function(){
           $(this).prev().val('').focus();
        });
    });
</script>

</body>
</html>
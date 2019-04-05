<html>
<head>
    <body>
<br>

<ul class="list-group">
    <li class="list-group-item list-group-item-secondary">Читатель:</li>

        <#if reader?has_content>
            <li class="list-group-item"> ${reader.lastName} ${reader.firstName}</li>


        <#else><li class="list-group-item"> Читатель не выбран</li>
        </#if>
    <a href="/readers" class="btn btn-primary">Изменить читателя</a>

</ul>

<br>
<ul class="list-group">
    <li class="list-group-item list-group-item-secondary">Книги к выдаче:</li>
        <#if basket?has_content>
            <#list basket?keys as back>
                <li class="list-group-item">${back.name}</li>
            </#list>
        <#else ><li class="list-group-item">Нет книг</li>
        </#if>


    <a href="/orders" class="btn btn-primary">Выдача книг</a>
</ul>
<br>

    </body>
</head>
</html>


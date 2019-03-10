<#include "main.ftl"/>
<@main title="Читатели"/>
<#macro content>
<br>
<form method="get" action="/readers">
    <div class="btn-group ">
        <button type="submit" class="btn btn-primary" name="action" value="А">А</button>
        <button type="submit" class="btn btn-primary" name="action" value="Б">Б</button>
        <button type="submit" class="btn btn-primary" name="action" value="В">В</button>
        <button type="submit" class="btn btn-primary" name="action" value="Г">Г</button>
        <button type="submit" class="btn btn-primary" name="action" value="Д">Д</button>
        <button type="submit" class="btn btn-primary" name="action" value="Е">Е</button>
        <button type="submit" class="btn btn-primary" name="action" value="Ё">Ё</button>
        <button type="submit" class="btn btn-primary" name="action" value="Ж">Ж</button>
        <button type="submit" class="btn btn-primary" name="action" value="З">З</button>
        <button type="submit" class="btn btn-primary" name="action" value="И">И</button>
        <button type="submit" class="btn btn-primary" name="action" value="К">К</button>
        <button type="submit" class="btn btn-primary" name="action" value="Л">Л</button>
        <button type="submit" class="btn btn-primary" name="action" value="М">М</button>
        <button type="submit" class="btn btn-primary" name="action" value="Н">Н</button>
        <button type="submit" class="btn btn-primary" name="action" value="О">О</button>
        <button type="submit" class="btn btn-primary" name="action" value="П">П</button>
        <button type="submit" class="btn btn-primary" name="action" value="Р">Р</button>
        <button type="submit" class="btn btn-primary" name="action" value="С">С</button>
        <button type="submit" class="btn btn-primary" name="action" value="Т">Т</button>
        <button type="submit" class="btn btn-primary" name="action" value="У">У</button>
        <button type="submit" class="btn btn-primary" name="action" value="Ф">Ф</button>
        <button type="submit" class="btn btn-primary" name="action" value="Х">Х</button>
        <button type="submit" class="btn btn-primary" name="action" value="Ц">Ц</button>
        <button type="submit" class="btn btn-primary" name="action" value="Ч">Ч</button>
        <button type="submit" class="btn btn-primary" name="action" value="Ш">Ш</button>
        <button type="submit" class="btn btn-primary" name="action" value="Щ">Щ</button>
        <button type="submit" class="btn btn-primary" name="action" value="Ы">Ы</button>
        <button type="submit" class="btn btn-primary" name="action" value="Э">Э</button>
        <button type="submit" class="btn btn-primary" name="action" value="Ю">Ю</button>
        <button type="submit" class="btn btn-primary" name="action" value="Я">Я</button>
    </div>
</form>

<form method="get" action="/readers">
    <div class="input-group ">
        <input type="text" name="fio" class="form-control col-md-5" placeholder="Введите фио" aria-label="Recipient's username" aria-describedby="button-addon2">
        <div class="input-group-append">
            <button class="btn btn-primary" type="submit" id="button-addon2">Найти</button>
        </div>
    </div>
</form>

    <#if error??>
    <div class="alert alert-warning" role="alert">
        Ошибка поиска введите нужные параметры через пробел
    </div>
    <#else >

Найдено читателей: ${count}

<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })
</script>


<table class="table table-hover table-sm">
    <thead class="thead-light">
    <tr>
        <th ></th>
        <th >Фамилия</th>
        <th >Имя</th>
        <th >Отчество</th>
        <th>Телефон</th>

    </tr>
    </thead>
    <tbody>
        <#list readers as reader>
        <tr>
            <td>
                <a class="btn btn-outline-info btn-sm btn-table " role="button" href="/readerInfo/${reader.idReader}" data-toggle="tooltip" data-placement="top" title="Полная иформация о читателе"><img src="/resources/image/lupa.png"></a>
                <a class="btn btn-outline-info btn-sm btn-table " role="button"  href="/addToReader/${reader.idReader}"data-toggle="tooltip" data-placement="top" title="Выбрать к выдаче"><img src="/resources/image/ryka.png"></a>
            </td>

            <td > ${reader.firstName}</a></td>
            <td>${reader.lastName}</td>
            <td>${reader.middleName}</td>
            <td>${reader.telephone}</td>

        </tr>
        </#list>
    </tbody>
</table>

    <#if countFindReaders gt 7>
        <#assign
        totalPages = countFindReaders
        pageNumber = activePage

        head = (pageNumber > 4)?then([1, -1], [1, 2, 3])
        tail = (pageNumber < totalPages - 3)?then([-1, totalPages], [totalPages - 2, totalPages - 1, totalPages])
        bodyBefore = (pageNumber > 4 && pageNumber < totalPages - 1)?then([pageNumber - 2, pageNumber - 1], [])
        bodyAfter = (pageNumber > 2 && pageNumber < totalPages - 3)?then([pageNumber + 1, pageNumber + 2], [])

        body = head + bodyBefore + (pageNumber > 3 && pageNumber < totalPages - 2)?then([pageNumber], []) + bodyAfter + tail
        >
    <#else>
        <#assign body = 1..countFindReaders>
    </#if>
<ul class="pagination">
    <li class="page-item disabled">
        <a class="page-link" href="#" tabindex="-1">Страницы</a>
    </li>
    <#list body as p>
        <#if p == activePage>
            <li class="page-item active"><a class="page-link" href="/readers?page=${p}">${p}</a></li>
        <#elseif p == -1>
            <li class="page-item disabled"><a class="page-link">...</a></li>
        <#else>
            <li class="page-item"><a class="page-link" href="/readers?page=${p}">${p}</a></li>
        </#if>
    </#list>

</ul>
    </#if>
</#macro>
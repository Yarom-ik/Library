<#include "main.ftl"/>
<@main title="Выдача"/>
<#macro content>
<br>
<div class="card">
    <h6 class="card-header">Выдача книг</h6>
    <div class="card-body">
        <#if basket?has_content>
            <#if reader?has_content>
                <h6> Читатель: <a class="btn btn-outline-info btn-sm btn-table " role="button" href="/readerInfo/#{reader.idReader}" data-toggle="tooltip" data-placement="top" title="Полная иформация о читателе"><img src="/resources/image/lupa.png"></a> ${reader.firstName} ${reader.lastName} ${reader.middleName}</h6>
            <#else><div class="alert alert-warning" role="alert"><h6>Читатель не выбран</h6></div>
            </#if>

            <p>Книг к выдаче: ${count}</p>
            <form method="post" action="/orderCol/">
                <table class="table table-hover table-sm">
                    <thead class="thead-light">
                    <tr>
                        <th></th>
                        <th >Название</th>
                        <th >Автор</th>
                        <th>Инвентарный номер</th>
                        <th scope="col">Количество</th>
                        <th scope="col">Выдать</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list basket as key,value>
                        <tr>
                            <td>
                                <a class="btn btn-outline-info btn-sm btn-table " role="button" href="/bookInfo/#{key.id}" data-toggle="tooltip" data-placement="top" title="Полная иформация о книге"><img src="/resources/image/lupa.png"></a>
                                <a class="btn btn-outline-info btn-sm btn-table " role="button" href="/clearBasketId/#{key.id}" data-toggle="tooltip" data-placement="top" title="Удалить из выдачи"><img src="/resources/image/delete.png"></a>
                            </td>
                            <td > ${key.name}</a></td>
                            <td>${key.author.authorName}</td>
                            <td>#{key.invNum}</td>
                            <td>${key.countBook}</td>
                            <td class="text-center"><a href="/orderMin/#{key.id}" class="btn btn-outline-danger btn-sm btn-circle" role="button"><img src="/resources/image/minus.png"></a>
                            ${value}
                                <a href="/orderPlus/#{key.id}" class="btn btn-outline-success btn-sm btn-circle" role="button"><img src="/resources/image/plus.png"></a> </td>

                        </tr>
                        </#list>
                    </tbody>
                </table>
            </form>


            <form method="post" action="/orders">
                <button type="submit" class="btn btn-primary " <#if reader?has_content> <#else> disabled </#if> >Выдать книги</button>

                <span class="input-group-btn ">
                <a href="/clearBasket" class="btn btn-warning" role="button">Очистить</a></span>

            </form>

        <#else >
            <div class="alert alert-info" role="alert"> Нет книг к выдаче</div>
        </#if>
    </div>
</div>
    <#if error??>
    <div class="alert alert-warning" role="alert">
        Ошибка выдачи книг!
    </div>
    </#if>

    <#if ok??>
    <div class="alert alert-success" role="alert">
        Книги успешно выданы!
    </div>
    </#if>

    <#if clear??>
    <div class="alert alert-success" role="alert">
        Корзина очищена!
    </div>
    </#if>

</#macro>
<#macro contentLeft>
    <#include "contentLeft.ftl"/>
</#macro>
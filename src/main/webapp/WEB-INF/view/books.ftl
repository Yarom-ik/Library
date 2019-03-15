<#include "main.ftl"/>

<@main title="Каталог книг"/>
<#macro content>
<br>
<div class="container-fluid">
    <div class="row">
        <form method="get" action="/books">
            <div class="btn-toolbar " role="toolbar" aria-label="Toolbar with button groups">
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="А">А</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Б">Б</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="В">В</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Г">Г</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Д">Д</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Е">Е</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Ё">Ё</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Ж">Ж</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="З">З</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="И">И</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="К">К</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Л">Л</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="М">М</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Н">Н</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="О">О</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="П">П</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Р">Р</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="С">С</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Т">Т</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="У">У</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Ф">Ф</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Х">Х</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Ц">Ц</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Ч">Ч</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Ш">Ш</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Щ">Щ</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Ы">Ы</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Э">Э</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Ю">Ю</button>
                <button type="submit" class="btn btn-primary" style="border-radius: 0px !important;" name="action" value="Я">Я</button>
                </div>
        </form>
    </div>
</div>

<form method="get" action="/books">
<div class="container-fluid">
    <div class="row">
        <div class="input-group input-group col-md-8">
            <input type="text" name="find" value="<#if findNameInput??>${findNameInput}</#if>" class="form-control col-md-7" placeholder="Поиск по книгам" aria-label="Recipient's username" aria-describedby="button-addon2" required>
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect01">Поиск по:</label>
                </div>
                 <select class="custom-select  col-md-3" name="param" id="inputGroupSelect01">
                     <option <#if paramInput?? && paramInput=='name'> ${(paramInput??)?string('selected', '')}</#if> value="name">названию книги</option>
                     <option <#if paramInput?? && paramInput=='author'> ${(paramInput??)?string('selected', '')}</#if> value="author">автору</option>
                     <option <#if paramInput?? && paramInput=='category'> ${(paramInput??)?string('selected', '')}</#if> value="category">категории</option>
                     <option <#if paramInput?? && paramInput=='invNum'> ${(paramInput??)?string('selected', '')}</#if> value="invNum">инвентарному номеру</option>
                </select>
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit" id="button-addon2">Найти</button>
                </div>
        </div>
        <div class="col-md-3">
            <a role="button" href="/books.ftl" class="btn btn-primary">Сбросить параметры поиска</a>
        </div>
    </div>
</div>
</form>


<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })
</script>

    <#if books?has_content>
        Найдено книг: ${countBooks}


        <form method="get" action="/bookInfo">
            <table class="table table-hover table-sm">
                <thead class="thead-light">
                    <tr>
                        <th ></th>
                        <th >Название</th>
                        <th >Автор</th>
                        <th >Категория</th>
                        <th>Инвентарный номер</th>
                        <th scope="col">Количество</th>
                    </tr>
                </thead>
                <tbody>
                    <#list books as book>
                        <#--<tr onclick="window.location='/bookInfo/${book.id}'">-->
                        <tr>
                            <td>
                                <a class="btn btn-outline-info btn-sm btn-table " role="button" href="/bookInfo/${book.id}" data-toggle="tooltip" data-placement="top" title="Полная иформация о книге"><img src="/resources/image/lupa.png"></a>
                                <a class="btn btn-outline-info btn-sm btn-table " role="button"  href="/addToOrder/${book.id}"data-toggle="tooltip" data-placement="top" title="Добавить к выдаче"><img src="/resources/image/ryka.png"></a>
                            </td>
                            <td > ${book.name}</a></td>
                            <td><a role="button" href="/books?find=${book.author.authorName}&param=author" style="color: black" >${book.author.authorName}</a></td>
                            <td><a role="button" href="/books?find=${book.category.categoryName}&param=category" style="color: black" >${book.category.categoryName}</a></td>
                            <td>#{book.invNum}</td>
                            <td>#{book.countBook}</td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </form>

        <#if countFindBooks gt 1>
            <#if countFindBooks gt 7>
                <#assign
                totalPages = countFindBooks
                pageNumber = activePage

                head = (pageNumber > 4)?then([1, -1], [1, 2, 3])
                tail = (pageNumber < totalPages - 3)?then([-1, totalPages], [totalPages - 2, totalPages - 1, totalPages])
                bodyBefore = (pageNumber > 4 && pageNumber < totalPages - 1)?then([pageNumber - 2, pageNumber - 1], [])
                bodyAfter = (pageNumber > 2 && pageNumber < totalPages - 3)?then([pageNumber + 1, pageNumber + 2], [])

                body = head + bodyBefore + (pageNumber > 3 && pageNumber < totalPages - 2)?then([pageNumber], []) + bodyAfter + tail
                >
            <#else>
                <#assign body = 1..countFindBooks>
            </#if>
            <br>
            <div class="d-flex justify-content-center">
                <ul class="pagination">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">Страницы:</a>
                    </li>
                    <#list body as p>
                        <#if p == activePage>
                            <li class="page-item active"><a class="page-link" href="/books?page=${p}">${p}</a></li>
                        <#elseif p == -1>
                            <li class="page-item disabled"><a class="page-link">...</a></li>
                        <#else>
                            <li class="page-item"><a class="page-link" href="/books?page=${p}">${p}</a></li>
                        </#if>
                    </#list>

                        <#if countFindBooks gt 1 && countFindBooks != activePage>
                        <li class="page-item">
                            <a class="page-link" href="/books?page=${activePage+1}">Следующая</a>
                            <#else >
                            <li class="page-item disabled">
                                <a class="page-link " href="/books?page=${activePage+1}">Следующая</a>
                        </#if>
                    </li>
                </ul>
            </div>
        </#if>
        <#else>
        <div class="alert alert-secondary" role="alert">
            Ничего не найдено!
        </div>
    </#if>

</#macro>





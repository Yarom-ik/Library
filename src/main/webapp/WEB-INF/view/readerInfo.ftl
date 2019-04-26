<#include "main.ftl"/>
<@main title="Читатель"/>
<#macro content>
<br>

<table class="table table-reflow">
    <thead>
    <tr>
        <th ></th>
        <th >Фамилия</th>
        <th >Имя</th>
        <th >Отчество</th>
        <th>Телефон</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <a class="btn btn-outline-info btn-sm btn-table " role="button"  href="/addToReader/#{readerId.idReader}" data-toggle="tooltip" data-placement="top" title="Выбрать к выдаче"><img src="/resources/image/ryka.png"></a>
        <#--<a class="btn btn-outline-info btn-sm btn-table " role="button" data-toggle="modal" data-target="#exampleModalDelete" data-toggle="tooltip" data-placement="top" title="Удалить читателя"><img src="/resources/image/delete.png"></a>-->
            <a class="btn btn-outline-info btn-sm btn-table " role="button" data-toggle="modal" data-target="#exampleModalDelete" >
                <span class="tags"  data-toggle="tooltip"   data-placement="top" title="Удалить читателя">
                <img src="/resources/image/delete.png">
                </span>
            </a>
        </td>
        <td > ${readerId.firstName}</a></td>
        <td>${readerId.lastName}</td>
        <td>${readerId.middleName}</td>
        <td>${readerId.telephone}</td>
    </tr>
    </tbody>
</table>



    <#if orders?has_content>
    <div class="card">
        <div class="card-header">
            <h6> Выданные книги:</h6>
        </div>

        <form method="get" action="/readerInfo/#{readerId.idReader}">

                <div class="container my-2">
                    <#if gives?has_content>
                        <h6>Дата выдачи: ${orderActive?string["dd.MM.yyyy HH:mm"]}</h6>
                        <table class="table table-hover table-sm">
                            <thead class="thead-light">
                            <tr>
                                <td> </td>
                                <td> Книга</td>
                                <td>Автор</td>
                                <td>Инвентарный номер</td>
                                <td>Дата возврата</td>
                            </tr>
                            </thead>
                            <tbody>
                                <#list gives as give>
                                <#--<tr >-->
                                    <#if give.finished == false>
                                    <tr class="table-danger">
                                        <td><a href="/readerInfo/#{readerId.idReader}?action=#{idOrd}&returnBookId=#{give.idGive}&returnBook=true" class="btn btn-outline-danger btn-sm btn-table" id="order" data-toggle="tooltip" data-placement="top" title="Книга возвращена"><img src="/resources/image/cancel.png"></a></td>
                                        <td class="table-danger"> ${give.catalogBooks.name}</td>
                                        <td class="table-danger"> ${give.catalogBooks.author.authorName}</td>
                                        <td class="table-danger"> #{give.catalogBooks.invNum}</td>
                                    </tr>
                                    <#else >
                                    <tr class="table-success">
                                        <td><a href="/readerInfo/#{readerId.idReader}?action=#{idOrd}&returnBookId=#{give.idGive}&returnBook=false" class="btn btn-outline-success btn-sm btn-table" id="order" data-toggle="tooltip" data-placement="top" title="Книга не возвращена"><img src="/resources/image/ok.png"></a></td>
                                        <td class="table-success"> ${give.catalogBooks.name}</td>
                                        <td class="table-success"> ${give.catalogBooks.author.authorName}</td>
                                        <td class="table-success"> #{give.catalogBooks.invNum}</td>
                                        <td>${give.dataReturn?string["dd.MM.yyyy"]}</td>
                                    </tr>
                                    </#if>
                                </#list>
                            </tr>
                            </tbody>
                        </table>
                        <td><a href="/readerInfo/#{readerId.idReader}?action=#{idOrd}&returnBookAll=yes&returnBook=true" class="btn btn-primary btn-sm" id="order">Возвращены все</a></td>
                    <#else>
                        <div class="alert alert-info" role="alert">
                            Выберите дату выдачи книг
                        </div>
                    </#if>
                </div>
        </form>
    </div>
    </#if>
<!-- Modal Delete-->
<div class="modal fade" id="exampleModalDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Удаление читателя</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <h6>Вы действительно хотите удалить читателя?</h6>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Нет</button>
                <a href="/deleteReader/#{readerId.idReader}" class="btn btn-primary" role="button">Да</a>
            </div>
        </div>
    </div>
</div>
</#macro>

<#macro contentLeft>
    <#--<#include "contentLeft.ftl"/>-->
<br>
<ul class="list-group">
    <li class="list-group-item list-group-item-secondary">История выдач:</li>
    <#if orders?has_content>
    <form method="get" action="/readerInfo/#{readerId.idReader}">
    <#--<div class="btn-group-vertical ">-->
        <#list orders as order>
            <#if order.finished == false>
                <button type="submit" class="list-group-item list-group-item-danger list-group-item-action" name="action" value="#{order.idOrder}">${order.data?string["dd.MM.yyyy HH:mm"]}</button>
            <#else ><button type="submit" class="list-group-item list-group-item-success list-group-item-action" name="action" value="#{order.idOrder}">${order.data?string["dd.MM.yyyy HH:mm"]}</button>
            </#if>
        </#list>
        <#else >
            <div class="alert alert-primary" role="alert">
                Нет выданных книг!
            </div>
    </#if>
    </form>
</ul>
</#macro>
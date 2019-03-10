<#include "main.ftl"/>
<@main title="Информация"/>
<#macro content>
<br>



<#--<table class="table table-hover table-bordered">-->
    <#--<thead>-->
    <#--<tr>-->
        <#--<th scope="col">Название</th>-->
        <#--<th scope="col">Автор</th>-->
        <#--<th scope="col">Категория</th>-->
        <#--<th scope="col">Год издания</th>-->
        <#--<th scope="col">Инвентарный номер</th>-->
        <#--<th scope="col">Количество</th>-->
    <#--</tr>-->
    <#--</thead>-->
    <#--<tbody>-->

    <#--<tr>-->

           <#--<td >${book.name}</td>-->
           <#--<td>${book.author}</td>-->
            <#--<td>${book.category.name}</td>-->
           <#--<td>${book.year?c}</td>-->
           <#--<td>${book.invNum?c}</td>-->
            <#--<td>${book.countBook?c}</td>-->
       <#--</tr>-->

    <#--</tbody>-->
<#--</table>-->
<div class="card">
    <h6 class="card-header">Информация о книге</h6>
    <div class="card-body">

        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-default">Название</span>
            </div>
            <label type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">${book.name}</label>
        </div>
        <div class="input-group mb-3">
             <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-default">Автор</span>
        </div>
            <label type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">${book.author.authorName}</label>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="inputGroup-sizing-default">Категория</span>
            </div>
            <label type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">${book.category.categoryName}</label>
        </div>
        <div class="input-group mb-3">
             <div class="input-group-prepend">
                 <span class="input-group-text" id="inputGroup-sizing-default">Год издания</span>
            </div>
            <label type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">${book.year?c}</label>
        </div>
        <div class="input-group mb-3">
                <div class="input-group-prepend">
                     <span class="input-group-text" id="inputGroup-sizing-default">Инвентарный номер</span>
                </div>
                <label type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">${book.invNum?c}</label>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Количество</span>
            </div>
            <label type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">${book.countBook}</label>
        </div>


        <div class=" mb-3">
            <div >
                <#if book.countBook gt 0> <a href="/addToOrder/${book.id}" class="btn btn-primary" id="order">Добавить к выдаче</a>
                <#else> <a href="/addToOrder/${book.id}" class="btn btn-primary disabled" role="button" >Добавить к выдаче</a>
                </#if>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalEdit">Изменить </button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<form method="post" action="/editBook">
<div class="modal fade" id="exampleModalEdit" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Изменение книги</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="input-group mb-4">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default">Название</span>
                    </div>
                    <input type="hidden" class="form-control" name="id" value="${book.id}" >
                    <input type="text" class="form-control" name="name" value="${book.name}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                </div>
                <div class="input-group mb-4">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default">Автор</span>
                    </div>
                    <input type="text" class="form-control" name="author" value="${book.author.authorName}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" >Категория</label>
                    </div>
                    <select class="custom-select" type="text" name="categoryName" id="categoryName">

                        <option type="text" value="${book.category.categoryName}"selected>${book.category.categoryName}</option>

                        <#list category as cat>
                            <#if cat.categoryName != book.category.categoryName>
                                <option value="${cat.categoryName}">${cat.categoryName}</option>
                            </#if>
                        </#list>
                    </select>
                </div>

                <div class="input-group mb-4">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default">Год</span>
                    </div>
                    <input type="text" class="form-control" name="year" value="${book.year?c}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                </div>
                <div class="input-group mb-4">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default">Инвентарный номер</span>
                    </div>
                    <input type="text" class="form-control" name="invNum" value="${book.invNum?c}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                </div>
                <div class="input-group mb-4">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default">Количество</span>
                    </div>
                    <input type="text" class="form-control" name="countBook" value="${book.countBook?c}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                <button type="submit" class="btn btn-primary">Изменить</button>
            </div>
        </div>
    </div>
</div>
</form>


</#macro>





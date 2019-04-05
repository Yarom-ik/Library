<#include "main.ftl"/>
<@main title="Информация"/>
<#macro content>
<br>

<form method="post" action="/bookInfo/#{book.id}" autocomplete="off">
    <div class="card">
        <h6 class="card-header">Информация о книге</h6>
        <div class="card-body">

            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Название</span>
                </div>
                <input type="hidden" class="form-control" name="id" value="#{book.id}" >
                <input type="text" class="form-control ${(nameError??)?string('is-invalid', '')} "
                       name="name" value="${book.name}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
                <#if nameError??>
                    <div class="invalid-feedback">
                    ${nameError}
                    </div>
                </#if>
            </div>
            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Автор</span>
                </div>
                <input type="text" class="typeahead form-control ${(authorNameError??)?string('is-invalid', '')}"
                       name="authorName" value="${book.author.authorName}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
                <#if authorNameError??>
                    <div class="invalid-feedback">
                    ${authorNameError}
                    </div>
                </#if>
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
                <input type="text" class="form-control ${(yearError??)?string('is-invalid', '')}"
                       name="year" value="${book.year?c}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
                <#if yearError??>
                    <div class="invalid-feedback">
                    ${yearError}
                    </div>
                </#if>
            </div>
            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Инвентарный номер</span>
                </div>
                <input type="text" class="form-control ${(invNumError??)?string('is-invalid', '')}"
                       name="invNum" value="${book.invNum?c}" aria-label="Sizing example input" readonly aria-describedby="inputGroup-sizing-default" required>
                <#if invNumError??>
                    <div class="invalid-feedback">
                    ${invNumError}
                    </div>
                </#if>
            </div>
            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Количество</span>
                </div>
                <input type="text" class="form-control ${(countBookError??)?string('is-invalid', '')}"
                       name="countBook" value="${book.countBook?c}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
                <#if countBookError??>
                    <div class="invalid-feedback">
                    ${countBookError}
                    </div>
                </#if>
            </div>

            <div class=" mb-3">
                <div >
                    <#if book.countBook gt 0> <a href="/addToOrder/#{book.id}" class="btn btn-primary" id="order">Добавить к выдаче</a>
                    <#else> <a href="/addToOrder/#{book.id}" class="btn btn-primary disabled" role="button" >Добавить к выдаче</a>
                    </#if>
                    <button type="submit" class="btn btn-warning" >Изменить </button>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalDelete">Удалить</button>
                </div>
            </div>
        </div>
    </div>
    <#if editOK??>
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            Книга успешно изменена
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
</form>

<#--<script src="/resources/js/bootstrap3-typeahead.js"></script>-->
<script>
    var $input = $(".typeahead");
    var $dad = [];
        <#list authors as author>
        $dad.push({id:"${author.idAuthor}", name: "${author.authorName}"});
        </#list>

    $input.typeahead({
        source: $dad,
        autoSelect: true
    });
    $input.change(function() {
        var current = $input.typeahead("getActive");
        if (current) {
            // Some item from your model is active!
            if (current.name == $input.val()) {
                // This means the exact match is found. Use toLowerCase() if you want case insensitive match.
            } else {
                // This means it is only a partial match, you can either add a new item
                // or take the active if you don't want new items
            }
        } else {
            // Nothing is active so it is a new value (or maybe empty value)
        }
    });
</script>

<!-- Modal Delete-->
<div class="modal fade" id="exampleModalDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Удаление книги</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
               <h6>Вы действительно хотите удалить эту книгу?</h6>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Нет</button>
                <a href="/deleteBook/#{book.id}" class="btn btn-primary" role="button">Да</a>
            </div>
        </div>
    </div>
</div>

</#macro>
<#macro contentLeft>
    <#include "contentLeft.ftl"/>
</#macro>




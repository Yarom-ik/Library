<#include "main.ftl"/>
<@main title="Добавление книги"/>
<#macro content>

<br>

<form action="/bookAdd" method="post" autocomplete="off">
    <div class="card">
        <h6 class="card-header">Информация о книге</h6>
        <div class="card-body">


            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Название</span>
                </div>
                <input type="text" class="form-control ${(nameError??)?string('is-invalid', '')}" placeholder="Введите название книги"
                       name="name" value="<#if book??>${book.name}</#if>" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
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
                <input type="text" class="typeahead form-control ${(authorNameError??)?string('is-invalid', '')}" placeholder="Введите название автора (подсказки будут появляться автоматически)"
                       name="authorName" value="<#if author??>${author.authorName}</#if>" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
                <#if authorNameError??>
                    <div class="invalid-feedback">
                    ${authorNameError}
                    </div>
                </#if>
            </div>

            <div class="input-group mb-3 was-validated">
                <div class="input-group-prepend">
                    <label class="input-group-text" >Категория</label>
                </div>
                <select class="custom-select" type="text" name="id_Category" id="id_Category" required>
                    <option type="text" value="" selected>Выберите</option>
                    <#list category as cat>
                        <option value="${cat.id_Category}">${cat.categoryName}</option>
                    </#list>
                </select>
                <#--<div class="invalid-feedback">Выберите категорию</div>-->
            </div>

            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Год издания</span>
                </div>
                <input type="text" class="form-control ${(yearError??)?string('is-invalid', '')}" placeholder="Введите название год издания"
                       name="year" value="<#if book??>#{book.year}</#if>" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
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
                <input type="text" class="form-control ${(invNumError??)?string('is-invalid', '')}" placeholder="Введите инвентарный номер (не более 6-ти цифр)"
                       name="invNum" value="<#if book??>#{book.invNum}</#if>" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
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
                <input type="text" class="form-control ${(countBookError??)?string('is-invalid', '')}" placeholder="Введите количество книг"
                       name="countBook" value="<#if book??>#{book.countBook}</#if>" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
                <#if countBookError??>
                    <div class="invalid-feedback">
                    ${countBookError}
                    </div>
                </#if>
            </div>


            <div class="input-group ">
                    <div class="input-group-prepend">
                        <div class="">
                            <button type="submit" class="btn btn-primary" role="button" id="btn1" name="btn1" >Добавить</button>
                        </div>
                        <#if addOk??>
                            <div class="alert alert-success alert-dismissible fade show" role="alert">
                                Книга успешно добавлена
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        <script>
                            $("input").val("");
                        </script>
                        </#if>
                    </div>
            </div>
        </div>
    </div>
</form>

<#--<script src="/resources/js/jquery-3.2.1.slim.min.js"></script>-->
<#--<script src="/resources/js/popper.min.js"></script>-->
<#--<script src="/resources/js/bootstrap.min.js"></script>-->
<script src="/resources/js/bootstrap3-typeahead.js"></script>
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



</#macro>





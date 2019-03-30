<#include "main.ftl"/>
<@main title="Категории"/>
<#macro content>

<br>


<div class="card">
    <h6 class="card-header">Категории книг</h6>
<div class="card-body">
<table class="table table-hover table-sm">
    <tbody>
        <#list categoryes as category>
        <tr>
            <td>
                <button class="btn btn-outline-info btn-sm btn-table " role="button" data-toggle="modal" data-target="#modalEdit" data-category="${category.categoryName}" data-id="${category.id_Category}" >
                    <span class="tags"  data-toggle="tooltip"   data-placement="top" title="Изменить категорию">
                        <img src="/resources/image/edit.png">
                    </span>
                </button>
                <#--<a class="btn btn-outline-info btn-sm btn-table " role="button"  href="/addToOrder/${book.id}"data-toggle="tooltip" data-placement="top" title="Добавить к выдаче"><img src="/resources/image/ryka.png"></a>-->
                <#--<button type="button" class="btn btn-primary editButton" data-toggle="modal" data-target="#modalEdit" data-category="${category.categoryName}" data-id="${category.id_Category}" >Edit</button>-->
            </td>
            <td > ${category.categoryName}</td>

        </tr>
        </#list>
    </tbody>
</table>
    <button type="button" class="btn btn-primary btn" data-toggle="modal" data-target="#exampleModalAdd">
        Добавить
    </button>
</div>

</div>

<#if categoryNameError??>
<div class="alert alert-warning alert-dismissible fade show" role="alert">
    <strong>${categoryNameError},</strong> название категории не должно превышать 50-ти символов
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>
</#if>

<!-- Modal Edit -->
<form method="get" action="/categoryes/edit">
<div class="modal" id="modalEdit">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Изменение категории</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">Название:</span>
                    </div>
                    <input type="hidden" name="id_Category" class="form-control" aria-describedby="basic-addon1" >
                    <input type="text" name="categoryName" class="form-control" aria-describedby="basic-addon1" required>
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

<script>
    $('#modalEdit').on('show.bs.modal', function(e) {
        var categoryId = $(e.relatedTarget).data('id');
        var categoryName = $(e.relatedTarget).data('category');

        $(e.currentTarget).find('input[name="categoryName"]').val(categoryName);
        $(e.currentTarget).find('input[name="id_Category"]').val(categoryId);
    });
</script>


<!-- ModalAdd -->
<form method="post" action="/categoryes/add">
<div class="modal fade" id="exampleModalAdd" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Добавление категории</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">Название:</span>
                    </div>
                    <input type="text" name="categoryName"  placeholder="Введите название категории" class="form-control" aria-describedby="basic-addon1" required>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </div>
    </div>
</div>
</form>
</#macro>





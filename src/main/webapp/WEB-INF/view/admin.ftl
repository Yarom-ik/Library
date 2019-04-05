<#include "main.ftl"/>
<@main title="Панель администратора"/>
<#macro content>
<br>

<div class="card">
    <h6 class="card-header">Резервное копирование</h6>
    <div class="card-body">
        <h6 class="card-title">Скачать резервную копию:</h6>
        <form action="/backup" method="post">
            <button type="submit" class="btn btn-primary">Сделать резервную копию</button>
        </form>
        <#if statusBackup?has_content>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>ОК!</strong> ${statusBackup}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </#if>
        <#if statusBackupError?has_content>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Ошибка!</strong> ${statusBackupError}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </#if>

        <h6 class="card-title">Востановить из резервной копии:</h6>
        <form method="post" action="/admin" enctype="multipart/form-data">
            <div class="input-group col-md-5">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroupFileAddon01">Файл:</span>
                </div>
                <div class="custom-file">
                    <input type="file" name="file" class="custom-file-input" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" required>
                    <label class="custom-file-label" for="inputGroupFile04">Файл не выбран</label>
                </div>
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" role="button" type="submit" id="inputGroupFileAddon04">Загрузить</button>
                </div>
            </div>
            <script type="application/javascript">
                $('input[type="file"]').change(function(e){
                    var fileName = e.target.files[0].name;
                    $('.custom-file-label').html(fileName);
                });
            </script>
        </form>

    </div>
</div>

<#if error?has_content>${error}</#if>
</#macro>
<#macro contentLeft>
<br>

<ul class="list-group">
    <li class="list-group-item list-group-item-secondary">Информация:</li>

        <li class="list-group-item">Для сохранения резервной копии нажмите соостветствующую кнопку </li>


</ul>
</#macro>
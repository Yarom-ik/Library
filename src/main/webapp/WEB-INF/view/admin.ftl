<#include "main.ftl"/>
<@main title="Панель администратора"/>
<#macro content>
<br>

<div class="card">
    <h6 class="card-header">Резервное копирование</h6>
    <div class="card-body">
        <div class="row p-3">
        <#--<h6 class="card-title">Скачать резервную копию:</h6>-->
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

        <#--<h6 class="card-title">Востановить из резервной копии:</h6>-->
        <form method="post" action="/admin" enctype="multipart/form-data">
            <div class="input-group col-md-11">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroupFileAddon01">Востановить из резервной копии:</span>
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
</div>

<#if error?has_content>${error}</#if>
<br>
<div class="card">
    <h6 class="card-header">Управление пользователями</h6>
    <div class="card-body">
        <form method="get" action="/admin">
            <table class="table table-hover table-sm">
                <thead class="thead-light">
                <tr>
                    <th ></th>
                    <th >Логин</th>
                    <th >Пароль</th>
                    <th >Роль</th>
                    <th >ФИО</th>
                </tr>
                </thead>
                <tbody>
                    <#list usersAndRole as user>
                    <tr>
                        <td>
                            <#--<a class="btn btn-outline-info btn-sm btn-table " role="button" href="/admin/#{user.idUser}" data-toggle="tooltip" data-placement="top" title="Редактировать пользователя"><img src="/resources/image/edit.png"></a>-->
                                <a class="btn btn-outline-info btn-sm btn-table " role="button" data-toggle="modal" data-target="#userEdit"
                                   data-user="${user.login}" data-roleuser="${user.getRole().name}" >
                                <span class="tags"  data-toggle="tooltip"  data-placement="top" title="Редактировать пользователя">
                                <img src="/resources/image/edit.png">
                                </span>
                                </a>

                                <a class="btn btn-outline-info btn-sm btn-table " role="button" data-toggle="modal" data-id="#{user.idUser}" data-target="#exampleModalDelete" >
                                <span class="tags"  data-toggle="tooltip"  data-placement="top" title="Удалить пользователя">
                                <img src="/resources/image/delete.png">
                                </span>
                            </a>
                        </td>
                        <td > ${user.login}</td>
                        <td>${user.password}</td>
                        <td>${user.role.name}</td>
                        <td>${user.getReader().firstName + " "+ user.getReader().lastName  + " "+ user.getReader().middleName} </td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </form>
    </div>
</div>


<script>
    $('#exampleModalDelete').on('show.bs.modal', function(e) {
        var idUser = $(e.relatedTarget).data('id');

        $(e.currentTarget).find('input[name="id_User"]').val(idUser);
    });

</script>
<script>
    $('#userEdit').on('show.bs.modal', function(e) {
        var user = $(e.relatedTarget).data('user');
        var role = $(e.relatedTarget).data('roleuser');

        $(e.currentTarget).find('input[name="login"]').val(user);
        $(e.currentTarget).find('input[name="role"]').val(role);
    });
</script>

<!-- Modal Edit -->
<form method="post" action="/admin/edit">
    <div class="modal" id="userEdit">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Изменение роли</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1">Логин:</span>
                        </div>
                        <input type="text" name="login" readonly class="form-control" aria-describedby="basic-addon1" >
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1">Текущая роль:</span>
                        </div>
                        <input type="text" name="role" class="form-control" readonly aria-describedby="basic-addon1" required>
                    </div>


                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Новая роль</label>
                        </div>
                        <select class="custom-select" name="idRole"  id="inputGroupSelect01" required>
                            <option selected>Выберите...</option>
                            <option  value="1">admin</option>
                            <option  value="2">library</option>
                            <option  value="3">reader</option>
                        </select>
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





<!-- Modal delete -->
<form method="get" action="/admin/del/">
    <div class="modal fade" id="exampleModalDelete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Удаление пользователя</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <h6>Вы действительно хотите удалить этого пользователя?</h6>
                    <input type="hidden" name="id_User" class="form-control" aria-describedby="basic-addon1" >
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Нет</button>
                    <button type="submit" class="btn btn-primary">Да</button>
                </div>
            </div>
        </div>
    </div>
</form>

</#macro>
<#macro contentLeft>
<br>

<ul class="list-group">
    <li class="list-group-item list-group-item-secondary">Информация:</li>

        <li class="list-group-item">Для сохранения резервной копии нажмите соостветствующую кнопку </li>


</ul>
</#macro>




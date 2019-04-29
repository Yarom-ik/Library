<#include "main.ftl"/>
<@main title="Аккаунт"/>
<#macro content>
<br>

<div class="card">
    <h6 class="card-header">Пользователь</h6>
<div class="card-body">
<table class="table table-reflow">
    <thead>
    <tr>
        <th >Фамилия</th>
        <th >Имя</th>
        <th >Отчество</th>
        <th>Телефон</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${userAccount.getReader().firstName} </td>
        <td > ${userAccount.getReader().lastName}</td>
        <td>${userAccount.getReader().middleName}</td>
        <td>${userAccount.getReader().telephone}</td>
    </tr>
    </tbody>
</table>
</div>
</div>
<br>
<div class="card">
    <h6 class="card-header">Аккаунт</h6>
    <div class="card-body">
        <form action="/editProfile" method="post" autocomplete="off">

            <div class="input-group mb-2">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Email:</span>
                </div>
                <input type="hidden" value="${nameUserLogin}" name="login">
                <input type="email" id="inputEmail" class="form-control ${(emailError??)?string('is-invalid', '')}" placeholder="Введите email"
                       name="email" value="<#if userProfile??>${userProfile.email}<#else >${userAccount.email}</#if>" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
                <#if emailError??>
                    <div class="invalid-feedback">
                        ${emailError}
                    </div>
                </#if>
            </div>
            <div class="mb-4">
                <button type="submit" class="btn btn-primary btn" >
                    Изменить
                </button>
            </div>
        </form>
        <form action="/editPassword" method="post" autocomplete="off">
            <div class="input-group mb-2">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Старый пароль:</span>
                </div>
                <input type="hidden" value="${nameUserLogin}" name="login">
                <input type="password" id="inputPassword" class="form-control ${(errorVerificatePass??)?string('is-invalid', '')}" placeholder="Введите старый пароль"
                       name="password" value="<#if password??>${password}</#if>" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
                <#if errorVerificatePass??>
                    <div class="invalid-feedback">
                        Введен неправильный пароль
                    </div>
                </#if>
            </div>


            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Новый пароль:</span>
                </div>
                <input type="password" id="inputPasswordNew" class="form-control" placeholder="Введите новый пароль"
                       name="passwordNew" value="<#if passwordNew??>${passwordNew}</#if>" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
            </div>
            <div class="mb-4">
                <input type="checkbox" onclick="myFunction()">Показать пароли
            </div>
            <div class="mb-4">
                <button type="submit" class="btn btn-primary btn" >
                    Изменить
                </button>
            </div>
            <script>
                function myFunction() {
                    var x = document.getElementById("inputPassword");
                    if (x.type === "password") {
                        x.type = "text";
                    } else {
                        x.type = "password";
                    }
                    var y = document.getElementById("inputPasswordNew");
                    if (y.type === "password") {
                        y.type = "text";
                    } else {
                        y.type = "password";
                    }
                }
            </script>
        </form>
    </div>
</div>

    <#if editPasswordOkk??>
    <div class="alert alert-primary alert-dismissible fade show" role="alert">
        <strong>Данные успешно изменены!</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    </#if>

</form>
<br>
</#macro>

<#macro contentLeft>
<br>
<ul class="list-group">
    <li class="list-group-item list-group-item-secondary">Информация:</li>
    <li class="list-group-item">Здесь Вы можете изменить свой email и пароль </li>
    <li class="list-group-item">Для изменения пароля сначала введите свой старый пароль, затем новый </li>
</ul>
</#macro>
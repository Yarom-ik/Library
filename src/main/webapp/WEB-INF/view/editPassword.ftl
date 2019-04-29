<#include "main.ftl"/>
<@main title="Изменение пароля"/>
<#macro content>

<br>


<div class="card">
    <h6 class="card-header">Изменение пароля</h6>
    <div class="card-body">
            <form action="/editPassword" method="post" autocomplete="off">
                <div class="input-group mb-4">
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

<div>

</div>

    <#if editPasswordOkk??>
    <div class="alert alert-primary alert-dismissible fade show" role="alert">
        <strong>Пароль успешно изменен!</strong>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    </#if>



</form>
</#macro>
<#macro contentLeft>
<br>

<ul class="list-group">
    <li class="list-group-item list-group-item-secondary">Информация:</li>

    <li class="list-group-item">Для изменения пароля сначала введите свой старый пароль, затем новый </li>


</ul>
</#macro>




<#include "main.ftl"/>
<@main title="Добавление читателя"/>
<#macro content>

<br>

<form action="/readerAdd" method="post">
    <div class="card">
        <h6 class="card-header">Информация о читателе</h6>
        <div class="card-body">
            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Фамилия</span>
                </div>
                <input type="text" id="firstName" class="form-control ${(firstNameError??)?string('is-invalid', '')}" placeholder="Введите фамилию"
                       name="firstName" value="<#if readerNew??>${readerNew.firstName}</#if>" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
                <#if firstNameError??>
                    <div class="invalid-feedback">
                        ${firstNameError}
                    </div>
                </#if>
            </div>
            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Имя</span>
                </div>
                <input type="text" class="typeahead form-control ${(lastNameError??)?string('is-invalid', '')}" placeholder="Введите имя"
                       name="lastName" value="<#if readerNew??>${readerNew.lastName}</#if>" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
                <#if lastNameError??>
                    <div class="invalid-feedback">
                    ${lastNameError}
                    </div>
                </#if>
            </div>


            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Отчество</span>
                </div>
                <input type="text" class="form-control ${(middleNameError??)?string('is-invalid', '')}" placeholder="Введите отчество"
                       name="middleName" value="<#if readerNew??>${readerNew.middleName}</#if>" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
                <#if middleNameError??>
                    <div class="invalid-feedback">
                    ${middleNameError}
                    </div>
                </#if>
            </div>
            <div class="input-group mb-4">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Телефон</span>
                </div>
                <input type="text" class="form-control ${(telephoneError??)?string('is-invalid', '')}" placeholder="Введите телефон"
                       name="telephone"  id="index" value="<#if readerNew??>${readerNew.telephone}</#if>" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" required>
                <#if telephoneError??>
                    <div class="invalid-feedback">
                    ${telephoneError}
                    </div>
                </#if>
            </div>
            <div class="input-group ">
                    <div class="input-group-prepend">
                        <div class="">
                            <button type="submit" class="btn btn-primary" role="button" id="btn1" name="btn1" >Добавить</button>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</form>

<script>
    //    запрет ввода пробелов
    $('input').keyup(function(){
        str = $(this).val()
        str = str.replace(/\s/g,'')
        $(this).val(str)
    });
    $(function() {
        //задание масски ввода телефона
        $("#index").mask("375(99)999-99-99");

    });
</script>

<!-- Подключение библиотеку jQuery маки ввода-->
<#--<script src="/resources/js/jquery.maskedinput.min.js"></script>-->

    <#if addOk??>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        Читатель успешно добавлен
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    </#if>


</#macro>
<#macro contentLeft>
    <#include "contentLeft.ftl"/>
</#macro>




<#include "../main.ftl"/>

<@main title="Взятые книги"/>
<#macro content>
<br>

<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })
</script>

    <#if booksNotFinish?has_content>
    <table class="table table-hover table-sm">
            <thead class="thead-light">
            <tr>
                <th scope="col">№</th>
                <th >Название</th>
                <th >Автор</th>
                <th>Инвентарный номер</th>
            </tr>
            </thead>
            <tbody>
                <#global num=0>
                <#list booksNotFinish as book>
                    <#global num = num+1>
                <tr>
                    <th scope="row">#{num }</th>
                    <td>${book.catalogBooks.name}</td>
                    <td>${book.catalogBooks.author.authorName}</td>
                    <td>#{book.catalogBooks.invNum}</td>
                </tr>
                </#list>
            </tbody>
        </table>
</#if>

    <#if status?has_content>
    <div class="alert alert-success" role="alert">
    ${status}
    </div>
    </#if>


</#macro>
<#macro contentLeft>
            <#include "contentLeftReader.ftl"/>
   </#macro>




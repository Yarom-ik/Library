<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    users = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    nameUserLogin = users.getLogin()
    isAdmin = users.isAdmin()
    >
<#else>
    <#assign
    nameUserLogin = "unknown"
    isAdmin = false
    >
</#if>
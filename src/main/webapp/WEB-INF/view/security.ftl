<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    users = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    nameUserLogin = users.getLogin()
    isAdmin = users.isAdmin()
    isReader = users.isReader()
    isLibrary = users.isLibrary()

    >
<#else>
    <#assign
    nameUserLogin = "unknown"
    isAdmin = false
    isReader = false
    isLibrary = false
    >
</#if>
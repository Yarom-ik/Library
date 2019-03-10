<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%request.setCharacterEncoding("UTF-8");%>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> home </title>
</head>
<body>
hello

<br> <a href="/logout">Logout</a>

    ${auth} role = ${role}

<br>

<table>
<c:forEach items="${users}" var="user">
<tr>
    <td>${user.id}</td>
    <td>${user.name}</td>
    <td>${user.author.name}</td>
    <td>${user.countBook}</td>
</tr>
    </c:forEach>
</table>
<br>


<h1>Add</h1>
<form method="post" action="/add" >
    <label>Name:
        <input type="text" name="name"><br />
    </label>
    <label>INV N:
        <input type="text" name="invNum"><br />
    </label>
    <label>Year:
        <input type="text" name="year"><br />
    </label>
    <label>CountBook:
        <input type="text" name="countBook"><br />
    </label>

    <label>Author:
        <input type="text" name="NameAuthor"><br />
    </label>


    <button type="submit" >Submit</button>


</form>

    <br>
<form method="get" action="/del">
    <label>Delete id:
        <input type="text" name="id"><br />
    </label>

    <button type="submit" >Submit</button>

</form>


</body>
</html>
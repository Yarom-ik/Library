<%--
  Created by IntelliJ IDEA.
  User: Yarom
  Date: 19.01.2019
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

</form>

<form method="get" action="/edit">
    <label>Details:
        <input type="text" name="id" value="${book.name}"><br />
    </label>

    <button type="submit" >Submit</button>

</form>

</body>
</html>

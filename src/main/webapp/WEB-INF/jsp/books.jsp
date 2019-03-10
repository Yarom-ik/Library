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




<table border="1">

        <tr>
            <th>id</th>
            <th>name</th>
            <th>author</th>
            <th>category</th>
            <th>year</th>
            <th>inv_num</th>
            <th>count</th>
        </tr>
        <tr>
            <c:forEach items="${books}" var="book">
            <td>${book.id}</td>
            <td><a href="/addToOrder/${book.id}" > ${book.name} </a></td>
            <td>${book.author}</td>
            <td>${book.category.name}</td>
            <td>${book.year}</td>
            <td>${book.invNum}</td>
            <td>${book.countBook}</td>
            <td>   </td>
        </tr>
    </c:forEach>
</table>
<br>

<table>
<c:forEach items="${backet}" var="back">
    <tr>
        <td>${back.name}</td>

    </tr>
</c:forEach>
</table>




</body>
</html>
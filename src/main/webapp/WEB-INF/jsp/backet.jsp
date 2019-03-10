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
            <c:forEach items="${readers}" var="reader">
            <td>${reader.idReder}</td>
            <td><a href="/addToReader/${reader.idReder}" > ${reader.firstName} </a></td>
            <td>${reader.lastName}</td>
            <td>${reader.middleName}</td>
            <td>${reader.telephone}</td>
            <td></td>
            <td></td>
            <td>

            </td>
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

${readerById}

<br>
<a href="/order" > oformit </a>


</body>
</html>
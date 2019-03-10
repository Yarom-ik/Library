<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/sign_up" modelAttribute="user" >
    <label>Name:
        <input type="text" name="login"><br />
    </label>
    <label>Password:
        <input type="text" name="password"><br />
    </label>

    <button type="submit" >Submit</button>


</form>

</body>
</html>

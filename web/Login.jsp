<%--
  Created by IntelliJ IDEA.
  User: NarF
  Date: 01/12/2019
  Time: 3:56 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/login" method="post">
    <table>
        <tr>
            <th>Usuario:</th>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <th>Clave:</th>
            <td><input type="password" name="pass"/></td>
        </tr>
        <tr>
            <td rowspan="2"><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>


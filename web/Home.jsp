<%--@elvariable id="usuario" type="model.Usuario"--%>
<%--
  Created by IntelliJ IDEA.
  User: NarF
  Date: 01/12/2019
  Time: 4:07 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

Bienvenido Usuario ${usuario.email}


<form action="/logout" method="get"><input type="submit" value="Log Out"></form>

</body>
</html>

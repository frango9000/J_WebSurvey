<%--
  Created by IntelliJ IDEA.
  User: NarF
  Date: 02/12/2019
  Time: 4:38 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Admin</h1>
<h2>Bienvenido ${usuario.email}</h2>

<a href="/admin/usuarios">Usuarios</a><br>
<a href="/admin/preguntas">Preguntas</a><br>

<br><a href="/login">Volver</a><br>


</body>
</html>

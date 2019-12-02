<%--
  Created by IntelliJ IDEA.
  User: NarF
  Date: 02/12/2019
  Time: 10:17 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin - Usuarios</title>
</head>
<body>
<h1>Admin</h1>
<h2>Usuarios registrados:</h2>
<c:forEach var="user" items="${usuarios}" varStatus="i">
    <a href="/admin/usuario?id=${user.id}">${user.email}</a><br>
</c:forEach>

<br><a href="/admin">Volver</a><br>
</body>
</html>

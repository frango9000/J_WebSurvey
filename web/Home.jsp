<%--@elvariable id="usuario" type="model.Usuario"--%>
<%--
  Created by IntelliJ IDEA.
  User: NarF
  Date: 01/12/2019
  Time: 4:07 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<h2>Bienvenido Usuario ${usuario.email}</h2>
<c:if test="${usuario.id eq 1}"><br><a href="/admin"> Admin </a><br></c:if>

<br><br><a href="/usuario"> Detalle de Usuario </a><br><br>
Encuesta:<br>
<c:choose>
    <c:when test="${empty usuario.respuestas}">No Realizada <br><a href="/encuesta">Realizar Ahora</a>"</c:when>
    <c:otherwise>Finalizada </c:otherwise>
</c:choose>
<br><br>
<form action="/logout" method="get"><input type="submit" value="Log Out"></form>

</body>
</html>

<%--@elvariable id="userDetail" type="dev.kurama.model.Usuario"--%>
<%--
  Created by IntelliJ IDEA.
  User: NarF
  Date: 02/12/2019
  Time: 4:40 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin - Usuario</title>
</head>
<body>
Usuario ${userDetail.email}<br><br>
<c:choose>
    <c:when test="${empty userDetail.respuestas}">Encuesta no Realizada"</c:when>
    <c:otherwise>Tu Encuesta:<br><br>
        <jsp:useBean id="source" class="dev.kurama.data.PreguntaDao"/>
        <c:forEach var="pregunta" items="${source.getPreguntas()}" varStatus="i">
            ${i.index} - Pregunta: ${pregunta.pregunta}<br>

            &nbsp;&nbsp;&nbsp;&nbsp;${userDetail.respuestas.get(i.index).respuesta} - ${pregunta.opciones.get(userDetail.respuestas.get(i.index).respuesta)}
            <br>
            <br>
        </c:forEach>
    </c:otherwise>
</c:choose>
<br>

<form method="post">
    <input type="hidden" name="action" value="1"/>
    <input type="hidden" name="affectedid" value="${userDetail.id}">
    <table>
        <tr>
            <td>Clave Nueva:</td>
            <td><input type="password" name="newPass1" value=""/></td>
        </tr>
        <tr>
            <td>Clave Nueva:</td>
            <td><input type="password" name="newPass2" value=""/></td>
        </tr>
        <tr>
            <td><input type="submit" name="go" value="Cambiar Clave"></td>
        </tr>
    </table>
</form>
<br>

<form method="post">
    <input type="hidden" name="action" value="2">
    <input type="hidden" name="affectedid" value="${userDetail.id}">
    <input type="submit" value="Eliminar Encuesta">
</form>
<br>

<a href="/admin/usuarios">Volver</a>
</body>
</html>

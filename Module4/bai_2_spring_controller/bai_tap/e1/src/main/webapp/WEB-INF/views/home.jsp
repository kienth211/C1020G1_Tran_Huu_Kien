<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PV
  Date: 23-Feb-21
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>This is sandwich</h1>
<c:if test='${messenger == "Pls choose"}'>
    <h1>${messenger}</h1>
</c:if>
<c:if test='${messenger != "Pls choose"}'>
    <h1>Condiment: ${messenger}</h1>
</c:if>
<form action="home">
<table border="1px">
    <tr>
        <th>
            Lettuce
        </th>
        <th>
            Tomato
        </th>
        <th>
            Mustard
        </th>
        <th>
            Sprouts
        </th>
    </tr>
    <tr>
        <td>
            <input type="checkbox" name="condiment" value="Lettuce">
        </td>
        <td>
            <input type="checkbox" name="condiment" value="Tomato">
        </td>
        <td>
            <input type="checkbox" name="condiment" value="Mustard">
        </td>
        <td>
            <input type="checkbox" name="condiment" value="Sprouts">
        </td>
    </tr>
</table>
<input type="submit">
</form>
</body>
</html>

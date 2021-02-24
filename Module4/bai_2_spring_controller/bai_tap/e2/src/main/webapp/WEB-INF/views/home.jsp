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
<%--<h1>This is sandwich</h1>--%>
<%--<c:if test='${messenger == "Pls choose"}'>--%>
    <h1>${num}</h1>
<%--</c:if>--%>
<%--<c:if test='${messenger != "Pls choose"}'>--%>
<%--    <h1>Condiment: ${messenger}</h1>--%>
<%--</c:if>--%>
<form action="home">
<table border="1px">
    <tr>
        <th colspan="2">
            <input type="text" name="number_1">
        </th>
        <th colspan="2">
            <input type="text" name="number_2">
        </th>
    </tr>
    <tr>
        <td>
            <input type="submit" name="operator" value="+" style="width: 40px">
        </td>
        <td>
            <input type="submit" name="operator" value="-" style="width: 40px">
        </td>
        <td>
            <input type="submit" name="operator" value="*" style="width: 40px">
        </td>
        <td>
            <input type="submit" name="operator" value="/" style="width: 40px">
        </td>
    </tr>
</table>
</form>
</body>
</html>

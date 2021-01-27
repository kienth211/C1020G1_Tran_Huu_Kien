<%--
  Created by IntelliJ IDEA.
  User: PV
  Date: 25-Jan-21
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="result" value="${requestScope.result}"/>
<c:if test="${result == 'Infinity'}">
    Khong dc chia cho 0
</c:if>
<c:if test="${result != 'Infinity'}">
    <c:out value="${result}"/>
</c:if>
</body>
</html>
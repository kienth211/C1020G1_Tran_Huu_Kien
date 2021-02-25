<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" action="home" modelAttribute="configuration">
    <table>
        <tr>
            <td><form:label path="language">Languages: </form:label></td>
            <td>
                <form:select path="language">
                    <form:options items="${languages}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="page">Page size: </form:label></td>
            <td>
                <form:select path="page">
                    <form:options items="${pages}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="spam">Spam filter: </form:label></td>
            <td>
                <form:checkbox path="spam"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="sign">Signature: </form:label></td>
            <td><form:input path="sign"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
<button>Cancel</button>
<h1>${messenger}</h1>
</body>
</html>

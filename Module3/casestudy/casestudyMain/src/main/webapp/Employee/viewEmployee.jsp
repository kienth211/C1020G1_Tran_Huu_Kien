<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View employee</title>
</head>
<body>
<h1>Employee details</h1>
<p>
    <a href="/EmployeeServlet">Back to employee list</a>
</p>
<c:set var = "messenger" scope="session" value = "${requestScope.messenger}"/>
<c:if test="${messenger == 'OK'}">
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>Name: </td>--%>
<%--            <td>${requestScope["user"].getName()}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Email: </td>--%>
<%--            <td>${requestScope["user"].getEmail()}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Country: </td>--%>
<%--            <td>${requestScope["user"].getCountry()}</td>--%>
<%--        </tr>--%>
<%--    </table>--%>
    <table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Id Card</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
                    <th>Action</th>
                    <th>Action</th>
    </tr>
    <c:forEach var="employee" items="${employeeListFromServlet}">
        <tr>
            <td><c:out value="${employee.employee_id}"/></td>
            <td><c:out value="${employee.employee_name}"/></td>
            <td><c:out value="${employee.employee_birthday}"/></td>
            <td><c:out value="${employee.employee_id_card}"/></td>
            <td><c:out value="${employee.employee_phone}"/></td>
            <td><c:out value="${employee.employee_email}"/></td>
            <td><c:out value="${employee.employee_address}"/></td>
                            <td>
                                <a href="/EmployeeServlet?actionUser=update&id=${employee.employee_id}">Update</a>
                            </td>
                            <td>
                                <a href="/EmployeeServlet?actionUser=delete&id=${employee.employee_id}">Delete</a>
                            </td>
        </tr>
    </c:forEach>
    </table>
</c:if>
<c:if test="${messenger == 'NG'}">
    <c:out value="${'Employee not found'}"/>
</c:if>
</body>
</html>
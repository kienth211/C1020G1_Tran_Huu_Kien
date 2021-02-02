<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        td {
            white-space: nowrap;
        }

        .table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
            background-color: #ffc77e;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark " style="height: 50px">
    <div class="d-flex align-items-center justify-content-begin">
        <form class="form-inline" action="/EmployeeServlet">
            <a class="btn btn-primary" href="/EmployeeServlet?actionUser=create" role="button">Create new Employee</a>
        </form>
    </div>
    <div class="d-flex align-items-center justify-content-end">
        <form class="form-inline" action="/EmployeeServlet">
            <input type="hidden" name="actionUser" value="search">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" name="name">
            <button class="btn btn-success" type="submit">Search</button>
        </form>
    </div>
</nav>
<br>
<%--<div class="container ustify-content-center">--%>
<%--<p>--%>
<%--    <a href="/EmployeeServlet?actionUser=create">Create new employee</a>--%>
<%--</p>--%>
<div class="table-fit justify-content-center">
    <table class="table table-striped table-bordered table-hover thead-dark" data-pagination="true">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Id Card</th>
            <th>Salary</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Username</th>
            <th>Position</th>
            <th>Education Degree</th>
            <th>Division</th>
            <th>Action</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:forEach var="employee" items="${employeeListFromServlet}">
            <td><c:out value="${employee.employee_id}"/></td>
            <td><c:out value="${employee.employee_name}"/></td>
            <td>
                <div><c:out value="${employee.employee_birthday}"/></div>
            </td>
            <td><c:out value="${employee.employee_id_card}"/></td>
            <td><c:out value="${employee.employee_salary}"/></td>
            <td><c:out value="${employee.employee_phone}"/></td>
            <td><c:out value="${employee.employee_email}"/></td>
            <td><c:out value="${employee.employee_address}"/></td>
            <td><c:out value="${employee.user_username}"/></td>
            <td>
                <c:if test="${employee.position_id == 1}">
                    <c:out value="${'Manager'}"/>
                </c:if>
            </td>
            <td>
                <c:if test="${employee.education_degree_id == 1}">
                    <c:out value="${'University'}"/>
                </c:if>
            </td>
            <td>
                <c:if test="${employee.division_id == 1}">
                    <c:out value="${'Manager'}"/>
                </c:if>
            </td>
            <td>
                <a class="btn btn-primary" href="/EmployeeServlet?actionUser=update&id=${employee.employee_id}" role="button">Update</a>
            </td>
            <td>
                <a class="btn btn-primary" href="/EmployeeServlet?actionUser=delete&id=${employee.employee_id}" role="button">Delete</a>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%--</div>--%>
<%--<form>--%>
<%--    <input type="hidden" name="actionUser" value="search">--%>
<%--    <input type="text" placeholder="Search by name" name="name"/>--%>
<%--    <input type="submit" value="Search"/>--%>
<%--</form>--%>

<%--<form>--%>
<%--    <input type="hidden" name="actionUser" value="search_id">--%>
<%--    <input type="text" placeholder="Search by id" name="id"/>--%>
<%--    <input type="submit" value="Search"/>--%>
<%--</form>--%>

<%--<table border="1">--%>
<%--    <tr>--%>
<%--        <th>Id</th>--%>
<%--        <th>Name</th>--%>
<%--        <th>Birthday</th>--%>
<%--        <th>Id Card</th>--%>
<%--        <th>Salary</th>--%>
<%--        <th>Phone</th>--%>
<%--        <th>Email</th>--%>
<%--        <th>Address</th>--%>
<%--        <th>Username</th>--%>
<%--        <th>Position</th>--%>
<%--        <th>Education Degree</th>--%>
<%--        <th>Division</th>--%>
<%--        &lt;%&ndash;        <th>Action</th>&ndash;%&gt;--%>
<%--        &lt;%&ndash;        <th>Action</th>&ndash;%&gt;--%>
<%--    </tr>--%>

<%--    <c:forEach var="employee" items="${employeeListFromServlet}">--%>
<%--        <tr>--%>
<%--            <td><c:out value="${employee.employee_id}"/></td>--%>
<%--            <td><c:out value="${employee.employee_name}"/></td>--%>
<%--            <td><c:out value="${employee.employee_birthday}"/></td>--%>
<%--            <td><c:out value="${employee.employee_id_card}"/></td>--%>
<%--            <td><c:out value="${employee.employee_salary}"/></td>--%>
<%--            <td><c:out value="${employee.employee_phone}"/></td>--%>
<%--            <td><c:out value="${employee.employee_email}"/></td>--%>
<%--            <td><c:out value="${employee.employee_address}"/></td>--%>
<%--            <td><c:out value="${employee.user_username}"/></td>--%>
<%--            <td>--%>
<%--                <c:if test="${employee.position_id == 1}">--%>
<%--                    <c:out value="${'Manager'}"/>--%>
<%--                </c:if>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <c:if test="${employee.education_degree_id == 1}">--%>
<%--                    <c:out value="${'University'}"/>--%>
<%--                </c:if>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <c:if test="${employee.division_id == 1}">--%>
<%--                    <c:out value="${'Manager'}"/>--%>
<%--                </c:if>--%>
<%--            </td>--%>

<%--                &lt;%&ndash;            <td>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                <a href="/UserServlet?actionUser=update&id=${user.id}">Update</a>&ndash;%&gt;--%>
<%--                &lt;%&ndash;            </td>&ndash;%&gt;--%>
<%--                &lt;%&ndash;            <td>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                <a href="/UserServlet?actionUser=delete&id=${user.id}">Delete</a>&ndash;%&gt;--%>
<%--                &lt;%&ndash;            </td>&ndash;%&gt;--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
</body>
</html>

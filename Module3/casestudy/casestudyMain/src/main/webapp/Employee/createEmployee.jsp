<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        /*td {*/
        /*    white-space: nowrap;*/
        /*}*/

        /*.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {*/
        /*    background-color: #ffc77e;*/
        /*}*/
    </style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark" style="height: 50px">
    <div class="d-flex align-items-center justify-content-begin">
        <a class="btn btn-primary" href="/EmployeeServlet" role="button">Back to Employee list</a>
    </div>
    <div class="d-flex align-items-center justify-content-begin">
        <h1 style="color: white">Create new user</h1>
    </div>
</nav>
<p>
    <c:if test='${requestScope["messenger"] == "OK"}'>
<div class="alert alert-success" role="alert">
    Employee created successfully
</div>
</c:if>

<c:if test='${(requestScope["messenger"] != "OK") && (requestScope["messenger"] != null)}'>
    <div class="alert alert-danger" role="alert">
            ${requestScope["messenger"]}
    </div>
</c:if>
</p>
<%--<p>--%>
<%--    <a href="/EmployeeServlet">Back to Employee list</a>--%>
<%--</p>--%>
<c:if test='${requestScope["messenger"] != "OK"}'>
<form method="post" action="/EmployeeServlet">
    <input type="hidden" name="actionUser" value="create">
    <fieldset>
        <legend>Employee information</legend>
        <table>
            <tr>
                <td>*Name:</td>
                <td><input type="text" value="${employeeInfo.employee_name}" name="employee_name"></td>
            </tr>
            <tr>
                <td>*Birthday:</td>
                <td><input type="text" value="${employeeInfo.employee_birthday}" name="employee_birthday"></td>
            </tr>
            <tr>
                <td>*ID Card:</td>
                <td>
                    <input type="text" value="${employeeInfo.employee_id_card}" name="employee_id_card">
                </td>
            </tr>
            <tr>
                <td>*Salary:</td>
                <td>
                    <input type="text" value="${employeeInfo.employee_salary}" name="employee_salary">
                </td>
            </tr>
            <tr>
                <td>*Phone:</td>
                <td><input type="text" value="${employeeInfo.employee_phone}" name="employee_phone"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" value="${employeeInfo.employee_email}" name="employee_email"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" value="${employeeInfo.employee_address}" name="employee_address"></td>
            </tr>
            <tr>
                <td>Username:</td>
                <td><input type="text" value="${employeeInfo.user_username}" name="user_username"></td>
            </tr>
            <tr>
                <td>Position:</td>
                <td>
                    <input type="text" value="${employeeInfo.position_id}" name="position_id">
                </td>
            </tr>
            <tr>
                <td>Education Degree:</td>
                <td>
                    <input type="text" value="${employeeInfo.education_degree_id}" name="education_degree_id">
                </td>
            </tr>
            <tr>
                <td>Division:</td>
                <td>
                    <input type="text" value="${employeeInfo.division_id}" name="division_id">
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create employee"></td>
            </tr>
        </table>
    </fieldset>
</form>
</c:if>
</body>
</html>
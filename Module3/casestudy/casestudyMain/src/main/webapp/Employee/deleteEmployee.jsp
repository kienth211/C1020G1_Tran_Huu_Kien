<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new employee</title>
    <title>List employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark" style="height: 50px">
    <div class="d-flex align-items-center justify-content-begin">
        <a class="btn btn-primary" href="/EmployeeServlet" role="button">Back to Employee list</a>
    </div>
    <div class="d-flex align-items-center justify-content-begin">
        <h1 style="color: white">Delete employee</h1>
    </div>
</nav>
<c:if test='${requestScope["messenger"] == "OK"}'>
    <div class="alert alert-success" role="alert">
        Employee deleted successfully
    </div>
</c:if>
<c:if test='${requestScope["messenger"] == "NG"}'>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>ID:</td>
                <td>${requestScope["employeeInfo"].employee_id}</td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>${requestScope["employeeInfo"].employee_name}</td>
            </tr>
            <tr>
                <td>Birthday:</td>
                <td>${requestScope["employeeInfo"].employee_birthday}</td>
            </tr>
            <tr>
                <td>ID Card:</td>
                <td>${requestScope["employeeInfo"].employee_id_card}</td>
            </tr>
            <tr>
                <td>Salary:</td>
                <td>${requestScope["employeeInfo"].employee_salary}</td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td>${requestScope["employeeInfo"].employee_phone}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${requestScope["employeeInfo"].employee_email}</td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>${requestScope["employeeInfo"].employee_address}</td>
            </tr>
            <tr>
                <td>Position:</td>
                <td>${requestScope["employeeInfo"].position_id}</td>
            </tr>
            <tr>
                <td>Education Degree:</td>
                <td>${requestScope["employeeInfo"].education_degree_id}</td>
            </tr>
            <tr>
                <td>Division:</td>
                <td>${requestScope["employeeInfo"].division_id}</td>
            </tr>
            <tr>
                <td>Username:</td>
                <td>${requestScope["employeeInfo"].user_username}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete user"></td>
            </tr>
        </table>
    </fieldset>
</form>
</c:if>
</body>
</html>


<%--Integer employee_id;--%>
<%--String employee_name;--%>
<%--String employee_birthday;--%>
<%--String employee_id_card;--%>
<%--Double employee_salary;--%>
<%--String employee_phone;--%>
<%--String employee_email;--%>
<%--String employee_address;--%>
<%--Integer position_id;--%>
<%--Integer education_degree_id;--%>
<%--Integer division_id;--%>
<%--String user_username;--%>
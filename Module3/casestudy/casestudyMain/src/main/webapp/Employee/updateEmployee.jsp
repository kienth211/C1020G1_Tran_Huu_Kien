<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <form action="/EmployeeServlet" method="post">
        <input type="hidden" name="actionUser" value="update" />
        <input type="hidden" name="employee_id" value="${employeeInfo.employee_id}" />
        <p>
            Name:
            <input type="text" value="${employeeInfo.employee_name}" name="employee_name">
        </p>
        <p>
            Birthday:
            <input type="text" value="${employeeInfo.employee_birthday}" name="employee_birthday">
        </p>
        <p>
            ID Card:
            <input type="text" value="${employeeInfo.employee_id_card}" name="employee_id_card">
        </p>
        <p>
            Salary:
            <input type="text" value="${employeeInfo.employee_salary}" name="employee_salary">
        </p>
        <p>
            Phone:
            <input type="text" value="${employeeInfo.employee_phone}" name="employee_phone">
        </p>
        <p>
            Email:
            <input type="text" value="${employeeInfo.employee_email}" name="employee_email">
        </p>
        <p>
            Address:
            <input type="text" value="${employeeInfo.employee_address}" name="employee_address">
        </p>
        <p>
            Position ID:
            <input type="text" value="${employeeInfo.position_id}" name="position_id">
        </p>
        <p>
            Education Degree ID:
            <input type="text" value="${employeeInfo.education_degree_id}" name="education_degree_id">
        </p>
        <p>
            Division ID:
            <input type="text" value="${employeeInfo.division_id}" name="division_id">
        </p>
        <p>
            Username:
            <input type="text" value="${employeeInfo.user_username}" name="user_username">
        </p>
        </p>
        <p>
            <input type="submit" value="Save" />
        </p>
    </form>
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

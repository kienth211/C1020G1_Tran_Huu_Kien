<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
</head>
<body>
<br>

<div class="container">
    <h2>Toggleable Pills</h2>
    <br>
    <!-- Nav pills -->
    <ul class="nav nav-pills" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" data-toggle="pill" href="#home">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="pill" href="#menu1">Menu 1</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="pill" href="#menu2">Menu 2</a>
        </li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div id="home" class="container tab-pane active"><br>
            <h3>HOME</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        </div>
        <div id="menu1" class="container tab-pane fade"><br>
            <h3>Menu 1</h3>
            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        </div>
        <div id="menu2" class="container tab-pane fade"><br>
            <h3>Menu 2</h3>
            <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
        </div>
    </div>
</div>

</body>
</html>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Create new employee</title>--%>
<%--    <style>--%>
<%--        .message {--%>
<%--            color: green;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Create new user</h1>--%>
<%--<p>--%>
<%--    <c:if test='${requestScope["messenger"] == "OK"}'>--%>
<%--        <span class="message" style="color: blue">Employee created successfully</span>--%>
<%--    </c:if>--%>
<%--    <c:if test='${requestScope["messenger"] != "OK"}'>--%>
<%--        <span class="message" style="color: red">${requestScope["messenger"]}</span>--%>
<%--    </c:if>--%>
<%--</p>--%>
<%--<p>--%>
<%--    <a href="/EmployeeServlet">Back to Employee list</a>--%>
<%--</p>--%>
<%--<form method="post">--%>
<%--    <fieldset>--%>
<%--        <legend>Employee information</legend>--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td>*Name:</td>--%>
<%--                <td><input type="text" value="${employeeInfo.employee_name}" name="employee_name"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>*Birthday:</td>--%>
<%--                <td><input type="text" value="${employeeInfo.employee_birthday}" name="employee_birthday"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>*ID Card:</td>--%>
<%--                <td>--%>
<%--                    <input type="text" value="${employeeInfo.employee_id_card}" name="employee_id_card">--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>*Salary:</td>--%>
<%--                <td>--%>
<%--                    <c:if test='${employeeInfo.employee_salary == 0}'>--%>
<%--                        <input type="text" value="${listEmployeeInfo[0]}" name="employee_salary">--%>
<%--                    </c:if>--%>
<%--                    <c:if test='${employeeInfo.employee_salary != 0}'>--%>
<%--                        <input type="text" value="${employeeInfo.employee_salary}" name="employee_salary">--%>
<%--                    </c:if>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>*Phone:</td>--%>
<%--                <td><input type="text" value="${employeeInfo.employee_phone}" name="employee_phone"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Email:</td>--%>
<%--                <td><input type="text" value="${employeeInfo.employee_email}" name="employee_email"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Address:</td>--%>
<%--                <td><input type="text" value="${employeeInfo.employee_address}" name="employee_address"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Username:</td>--%>
<%--                <td><input type="text" value="${employeeInfo.user_username}" name="user_username"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Position:</td>--%>
<%--                <td>--%>
<%--&lt;%&ndash;                    <input type="text" value="${employeeInfo.position_id}" name="position_id">&ndash;%&gt;--%>
<%--                    <c:if test='${employeeInfo.position_id == 0}'>--%>
<%--                        <input type="text" value="${listEmployeeInfo[1]}" name="position_id">--%>
<%--                    </c:if>--%>
<%--                    <c:if test='${employeeInfo.position_id != 0}'>--%>
<%--                        <input type="text" value="${employeeInfo.position_id}" name="position_id">--%>
<%--                    </c:if>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Education Degree:</td>--%>
<%--                <td>--%>
<%--                    <c:if test='${employeeInfo.education_degree_id == 0}'>--%>
<%--                        <input type="text" value="${listEmployeeInfo[2]}" name="education_degree_id">--%>
<%--                    </c:if>--%>
<%--                    <c:if test='${employeeInfo.education_degree_id != 0}'>--%>
<%--                        <input type="text" value="${employeeInfo.education_degree_id}" name="education_degree_id">--%>
<%--                    </c:if>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Division:</td>--%>
<%--                <td>--%>
<%--                    <c:if test='${employeeInfo.division_id == 0}'>--%>
<%--                        <input type="text" value="${listEmployeeInfo[3]}" name="division_id">--%>
<%--                    </c:if>--%>
<%--                    <c:if test='${employeeInfo.division_id != 0}'>--%>
<%--                        <input type="text" value="${employeeInfo.division_id}" name="division_id">--%>
<%--                    </c:if>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td></td>--%>
<%--                <td><input type="submit" value="Create employee"></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </fieldset>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>

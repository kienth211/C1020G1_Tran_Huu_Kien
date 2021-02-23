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
        td {
            width: 24%;
        }
    </style>
</head>
<body>
<ul class="nav nav-pills mb-3 bg-secondary" role="tablist">
    <li class="nav-item">
        <a class="nav-link" href="/MainServlet" role="tab">Main Page</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#pills-profile" role="tab">Contract</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#pills-contact" role="tab">Customer</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" href="/EmployeeServlet" role="tab">Product</a>
    </li>
</ul>

<div>
    <div class="d-flex align-items-center float-left">
        <a class="btn btn-primary" href="/EmployeeServlet" role="button">
            Back to Product list
        </a>
    </div>
    <div class="d-flex align-items-center float-right">
        <h2>
            Create Product
        </h2>
    </div>
</div>

<div style="clear:both">
    <c:if test='${requestScope["messenger"] == "OK"}'>
        <div class="alert alert-success" role="alert">
            Product created successfully
        </div>
    </c:if>
    <c:if test='${(requestScope["messenger"] != "OK") && (requestScope["messenger"] != null)}'>
        <div class="alert alert-danger" role="alert">
                ${requestScope["messenger"]}
        </div>
    </c:if>
</div>

<c:if test='${requestScope["messenger"] != "OK"}'>
    <div class="container" style="clear:both">
        <form method="post" action="/EmployeeServlet">
            <input type="hidden" name="actionUser" value="create">
            <table>
                <tr>
                    <td>*product_name:</td>
                    <td><input type="text" value="${employeeInfo.product_name}" name="product_name"></td>
                </tr>
                <tr>
                    <td>*product_price:</td>
                    <td><input type="text" value="${employeeInfo.product_price}" name="product_price"></td>
                </tr>
                <tr>
                    <td>*product_discount:</td>
                    <td>
                        <div class="input-group mb-3">
                            <select class="custom-select" name="product_discount">
                                <c:set var="num" value="${employeeInfo.product_discount}"></c:set>
                                <c:if test="${(num == null) || (num == 5)}">
                                    <option selected value="5">5</option>
                                    <option value="10">10</option>
                                    <option value="15">15</option>
                                    <option value="20">20</option>
                                </c:if>
                                <c:if test="${num == 10}">
                                    <option value="5">5</option>
                                    <option selected value="10">10</option>
                                    <option value="15">15</option>
                                    <option value="20">20</option>
                                </c:if>
                                <c:if test="${num == 15}">
                                    <option value="5">5</option>
                                    <option value="10">10</option>
                                    <option selected value="15">15</option>
                                    <option value="20">20</option>
                                </c:if>
                                <c:if test="${num == 20}">
                                    <option value="5">5</option>
                                    <option value="10">10</option>
                                    <option value="15">15</option>
                                    <option selected value="20">20</option>
                                </c:if>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>*Stock:</td>
                    <td>
                        <input type="text" value="${employeeInfo.product_not_sold}" name="product_not_sold">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Create product">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</c:if>
</body>
</html>
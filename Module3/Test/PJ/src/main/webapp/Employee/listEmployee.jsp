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
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap4.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap4.min.js"></script>
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
<div>
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
        <div class="d-flex align-items-center justify-content-begin float-left">
            <a class="btn btn-primary" href="/EmployeeServlet?actionUser=create" role="button">Create new Product</a>
        </div>
        <div class="d-flex align-items-center justify-content-end float-right">
            <form class="form-inline" action="/EmployeeServlet">
                <input type="hidden" name="actionUser" value="search">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" name="name">
                <button class="btn btn-success" type="submit">Search</button>
            </form>
        </div>
    </div>
    <div class="container">
        <div class="table-fit">
            <table class="table table-striped table-bordered table-hover thead-dark table-responsive"
                   id="tableEmployee">
                <thead class="thead-dark">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Discount</th>
                    <th>Stock</th>
                    <th>Action</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <c:forEach var="employee" items="${employeeListFromServlet}">
                    <td><c:out value="${employee.product_id}"/></td>
                    <td><c:out value="${employee.product_name}"/></td>
                    <td><c:out value="${employee.product_price}"/></td>
                    <td><c:out value="${employee.product_discount}"/></td>
                    <td><c:out value="${employee.product_not_sold}"/></td>
                    <td>
                        <a class="btn btn-primary" href="/EmployeeServlet?actionUser=update&id=${employee.product_id}"
                           role="button">Update</a>
                    </td>
                    <td>
                        <a class="btn btn-primary" href="/EmployeeServlet?actionUser=delete&id=${employee.product_id}"
                           role="button">Delete</a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            $('#tableEmployee').dataTable({
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 5
            });
        });
    </script>
</body>
</html>

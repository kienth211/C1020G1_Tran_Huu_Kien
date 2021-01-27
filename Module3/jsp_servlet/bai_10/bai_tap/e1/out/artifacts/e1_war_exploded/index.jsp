<%--
  Created by IntelliJ IDEA.
  User: PV
  Date: 25-Jan-21
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <table border="1">
    <tr>
      <th>Tên</th>
      <th>Ngày sinh</th>
      <th>Địa chỉ</th>
      <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customerListFromServlet}">
      <tr>
        <td><c:out value="${customer.name}"/></td>
        <td><c:out value="${customer.dateOfBirth}"/></td>
        <td><c:out value="${customer.address}"/></td>
        <td><img src="${customer.image}" style="width: 200px; height: 200px"/></td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>

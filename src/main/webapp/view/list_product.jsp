<%--
  Created by IntelliJ IDEA.
  User: Duong
  Date: 12/7/2020
  Time: 14:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products List</title>
    <style>
        table{
            border: solid 1px;
            border-collapse: collapse;
            padding: 5px;
        }
        th, tr, td{
            border: solid 1px;
            border-collapse: collapse;
            padding: 5px;
        }
    </style>

</head>
<body>

<p>
    <a href="/products?action=create">Create Product</a>
</p>
<form action="/products?action=search" method="post">
    <input type="text" placeholder="Search here" name="search" id="search"><input type="submit" value="Search">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Status</th>
<%--        <th>Category</th>--%>
        <th>Action</th>
    </tr>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td><c:out value="${product.getId()}"></c:out></td>
            <td><c:out value="${product.getName()}"></c:out></td>
            <td><c:out value="${product.getPrime()}"></c:out></td>
            <td><c:out value="${product.getQuantity()}"></c:out></td>
            <td><c:out value="${product.getColor()}"></c:out></td>
            <td><c:out value="${product.getStatus()}"></c:out></td>
<%--            <td><c:out value="${product.getCategory().getCatName()}"></c:out></td>--%>
            <td>
                <a href="/products?action=edit&id=${product.getId()}">Edit</a>
                <a href="/products?action=delete&id=${product.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

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
    <title>Create Product</title>
</head>
<body>
<p>
    <a href="/products">Back to list of products</a>
</p>
<form method="post">
    <fieldset>
        <legend>Insert Product Info</legend>
        <table>
            <tr>
                <td>Id:</td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="prime" id="prime"></td>
            </tr>
            <tr>
                <td>Quantity:</td>
                <td><input type="text" name="quantity" id="quantity"></td>
            </tr>
            <tr>
                <td>Color:</td>
                <td><input type="text" name="color" id="color"></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td><input type="text" name="status" id="status"></td>
            </tr>
            <tr>
                <td>Category:</td>
                <td><select name="category" id="category">
                    <c:forEach items="${categoryList}" var="category">
                    <option value="${category.getCatName()}">${category.getCatName()}</option>
                    </c:forEach>
                </td>
            </tr>
        </table>
        <input type="submit" value="Create Product">
    </fieldset>
</form>
</body>
</html>

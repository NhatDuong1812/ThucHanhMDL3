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
    <title>Edit Product</title>
</head>
<body>
<p>
    <a href="/products">Back to list of products</a>
</p>
<form method="post" action="/products?action=edit">
    <fieldset>
        <legend>Insert Product Info</legend>
        <input type="hidded" name="id" value="${editProduct.getId()}">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name"value=""></td>
            </tr>
            <tr>
                <td>Prime:</td>
                <td><input type="text" name="prime" id="prime" value=""></td>
            </tr>

            <tr>
                <td>Quantity:</td>
                <td><input type="text" name="quantity" id="quantity" value=""></td>
            </tr>
            <tr>
                <td>Color:</td>
                <td><input type="text" name="color" id="color" value=""></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td><input type="text" name="status" id="status" value=""></td>
            </tr>


        </table>
        <input type="submit" value="Edit Product">
    </fieldset>
</form>
</body>
</html>

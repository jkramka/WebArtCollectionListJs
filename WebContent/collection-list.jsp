<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of the items in the table.</title>
<link rel='stylesheet' type='text/css' href='css/styles.css'>
</head>
<body>
<div class='headline'>
<h1>Current art works in the collection:</h1>
</div>

<form method = "post" action = "editShoppingListServlet">
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
 <td><input type="radio" name="id" value="${currentitem.id}"></td>
 <td>${currentitem.artist}</td>
 <td>${currentitem.item}</td>
 <td>${currentitem.year}</td>
 </tr>
</c:forEach>
</table>
<br>
<input type = "submit" value = "Edit Selected Item"
name="doThisToItem">
<input type = "submit" value = "Delete Selected Item"
name="doThisToItem">
<input type="submit" value = "Add New Item" name = "doThisToItem">
</form>
<br>
<div class='menu-button'>
<a href = "index.html">Home</a>
</div>
<script src='js/jquery-3.3.1.min.js'></script>
<script src='js/main.js'></script>
</body>
</html>
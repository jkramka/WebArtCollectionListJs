<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit art work information.</title>
<link rel='stylesheet' type='text/css' href='css/styles.css'>
</head>
<body>
<div class='headline'>
<h1>Enter any changes:</h1>
</div>
<form action = "editItemServlet" method="post">
Artist: <input type ="text" name = "artist" value= "${itemToEdit.artist}"><br>
<br>
Item : <input type = "text" name = "item" value= "${itemToEdit.item}"><br>
<br>
Year : <input type = "text" name = "year" value= "${itemToEdit.year}"><br>
<br>
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>
<br>
<div class='menu-button'>
<a href = "index.html">Home</a>
</div>
<script src='js/jquery-3.3.1.min.js'></script>
<script src='js/main.js'></script>
</body>
</html>
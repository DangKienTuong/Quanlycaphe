<!DOCTYPE html>
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="utf-8" />
<title>Tiêu đề</title>
</head>
<body>
	<img src="files/${photo_name}" width="300px" height="400px">
	<br>
	<br>
	<br>
	<form action="manage/insertPro.htm" method="post">
		<label>Name</label> <input name="name" /><br>
		<br> <label>Category Name</label> <select name="catid">
			<c:forEach items="${categories}" var="category">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select> <br>
		<br> <label>Price</label> <input type="hidden" name="photo"
			value="${photo_name}" /> <input name="price" /> <br>
		<br> <label>Describe</label>
		<textarea name="describe" rows="5" cols="30"></textarea>
		<br>
		<br>
		<button>Add</button>


		<form>
</body>
</html>

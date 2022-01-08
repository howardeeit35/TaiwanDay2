<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>刪除資料</h2>
	<form action="deleteDB.controller" method="post" id="user" enctype="html/text">
		<table>
			<tr>
				<td>樓層:</td>
				<td><input type="text" name="no" id="no" /></td>
				<td>${errors.no}</td>
			</tr>
			<tr>
				<td><input type="submit" id="submit" name="submit" value="發布"></td>
				<td>${errors.msg}</td>
			</tr>
			</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>展演活動資料更新</title>
</head>
<body>
<h1>展演活動資料更新</h1>
	<form action="getById" method="get">
		<table>
			<c:forEach var="show" items="${temp}">
			<tr>
				<td width="150">編號:</td>
				<td><input type="text" name="id" value="${show.id}"></td>
			</tr>
			<tr>
				<td >活動類別:</td>
				<td><input type="text" name="title" value="${show.title}"></td>
			</tr>
			<tr>
				<td>活動名稱:</td>
				<td><input type="text" name="name" value="${show.name}"></td>
			</tr>
			<tr>
				<td>活動開始日期:</td>
				<td>西元 <input type="date" name="sdate" value="${show.sdate}"></td>
			</tr>
			<tr>
				<td>活動結束日期:</td>
				<td>西元 <input type="date" name="edate" value="${show.edate}"></td>
			</tr>
			<tr>
				<td>金額:</td>
				<td>$<input type="text" name="price" value="${show.price}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="update" value="更新&保存"></td>
			</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>MainPage</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>討論區</h1>
<div>
<button onclick="location.href='content'">我要評論</button><br>
</div><br>
<div>
<table border="1">
	<tr>
		<th>樓層</th>
		<th>姓名</th>
		<th>內容</th>
		<th>評價</th>	
	<th>操作</th>
	</tr>
	<c:forEach var="query" items="${query}">
	<c:url var="update" value="/updatecontent">
            <c:param name="no" value="${query.id}"/>
            <c:param name="content" value="${query.content}"/>
            <c:param name="grades" value="${query.grades}"/>
    </c:url>
	<c:url var="delete" value="/deleteDB.controller">
            <c:param name="no" value="${query.id}"/>
    </c:url>
	<tr>
		<td>${query.id}</td>
		<td>${query.userName}</td>
		<td>${query.content}</td>
		<td>${query.grades}</td>
		<td><button onclick="location.href='${update}'">修改評論</button>
		<button onclick="if (!(confirm('確定刪除資料嗎?'))) return false;
		location.href='${delete}'">刪除評論</button>
		</td>	
	</tr>
    </c:forEach>

</table>
<div>
<button onclick="location.href='returnmainpage'">回主頁</button><br>
</div>
</div>
</body>
</html>
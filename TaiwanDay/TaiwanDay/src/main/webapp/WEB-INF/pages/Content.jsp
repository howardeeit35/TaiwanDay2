<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>評點區</h2>
	<form action="insertDB.controller" method="post" id="user" enctype="html/text">
		<table>
			<tr>
				<td>姓名:</td>
				<td><input type="text" name="name" id="name" /></td>
				<td>${errors.name}</td>
			</tr>
			<tr>
				<td>內容:</td>
				<td><textarea id="textarea" name="content" placeholder="請輸入留言"></textarea></td>
				<td>${errors.content}</td>
			</tr>
			<tr>
				<td>評價:</td>
				<td><input type="radio" name="grades" id="grades" value="非常差">非常差
					<input type="radio" name="grades" id="grades" value="差">差 <input
					type="radio" name="grades" id="grades" value="尚可">尚可 <input
					type="radio" name="grades" id="grades" value="好">好 <input
					type="radio" name="grades" id="grades" value="非常好"
					checked="checked">非常好</td>
			</tr>
			<tr>
				<td><input type="submit" id="submit" name="submit" value="發布"></td>
				<td>${errors.msg}</td>
			</tr>
		</table>
	</form>

</body>
</html>
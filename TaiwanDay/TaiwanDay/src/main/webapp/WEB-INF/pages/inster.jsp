<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增展演活動內容</title>
</head>
<body>
    <div align="center">
        <h1>新增展演活動內容</h1>
        <form action="saveShow" method="post">
         <h3>
             <a type="button" href="listShow">活動表演資訊</a>
        </h3>
        <table>
 
			<tr>
				<td>活動類別:</td>
				<td><input type="text" name="title" id="title" /></td>
			</tr>
			<tr>
				<td>活動名稱:</td>
				<td><input type="text" name="name" id="name" /></td>
			</tr>
			<tr>
				<td>活動開始日期:</td>
				<td>西元<input type="date" name="sdate" id="sdate" /></td>
			</tr>
			<tr>
				<td>活動結束日期:</td>
				<td>西元<input type="date" name="edate" id="edate" /></td>
			</tr>
			<tr>
				<td>金額:</td>
				<td>$<input type="text" name="price" id="price" /></td>
			</tr>
			
            <tr>
                <td colspan="2" align="center"><input type="submit" value="新增"></td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>
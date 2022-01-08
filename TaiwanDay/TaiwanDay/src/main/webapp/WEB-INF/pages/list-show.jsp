<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>活動表演資訊</title>
</head>
<body>
    <div align="center">
        <h1>活動表演資訊</h1>
         <form action="listShow" method="get">
        <h3>
        	<a type="button" href="showForm">新增活動表演資訊</a>
        </h3>
        <table border="1">
 
           	<th>編號</th>
			<th>活動類別</th>
			<th>活動名稱</th>
			<th>活動開始日期</th>
			<th>活動結束日期</th>
			<th>金額</th>
			<th>操作</th>
 
            <c:forEach var="show" items="${shows}">
            
            <c:url var="updateLink" value="/getById">
            	<c:param name="showId" value="${show.id}"/>
            </c:url>
            
             <c:url var="deleteLink" value="/delete">
            	<c:param name="showId" value="${show.id}"/>
            </c:url>
                <tr>
                    <td>${show.id}</td>
                    <td>${show.title}</td>
                    <td>${show.name}</td>
                    <td>${show.sdate}</td>
                    <td>${show.edate}</td>
                    <td>${show.price}</td>
                    <td><a href="${updateLink}">更新</a>|
                    <a href="${deleteLink}" onclick="if (!(confirm('確定刪除資料嗎?'))) return false">刪除</a></td>
 
                </tr>
            </c:forEach>
        </table>
        </form>
    </div>
</body>
</html>
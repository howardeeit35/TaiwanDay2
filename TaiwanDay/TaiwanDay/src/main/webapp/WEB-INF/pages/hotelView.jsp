<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>飯店簡介</title>
</head>
<body>
	<div align="center">
		<h2>飯店簡介</h2>
		<form action="/hotelView" method="get">
			<h4>
				<a type="button" href="hotelForm">新增飯店簡介</a>
			</h4>
			<table border="1">
				<th>飯店編號</th>
				<th>飯店名稱</th>
				<th>電話號碼</th>
				<th>飯店地址</th>
				<th>金額</th>
				<th>房型</th>
				<th>入住日期</th>
				<th>退房日期</th>


				<c:forEach var="hotel" items="${hotelBeans}">


					<c:url var="deleteLink" value="/deletehotel">
						<c:param name="hotelid" value="${hotel.hotelId}" />
					</c:url>


					<c:url var="updateLink" value="/getHotelById">
						<c:param name="hotelid" value="${hotel.hotelId}" />
						<c:param name="hotelname" value="${hotel.hotelName}" />
						<c:param name="hotelphonenum" value="${hotel.hotelPhoneNum}" />
						<c:param name="hoteladdress" value="${hotel.hotelAddress}" />
						<c:param name="hotelprice" value="${hotel.hotelPrice}" />
						<c:param name="roomstyle" value="${hotel.roomStyle}" />
						<c:param name="checkindate" value="${hotel.checkinDate}" />
						<c:param name="checkoutdate" value="${hotel.checkoutDate}" />
					</c:url>

					<tr>
						<td>${hotel.hotelId}</td>
						<td>${hotel.hotelName}</td>
						<td>${hotel.hotelPhoneNum}</td>
						<td>${hotel.hotelAddress}</td>
						<td>${hotel.hotelPrice}</td>
						<td>${hotel.roomStyle}</td>
						<td>${hotel.checkinDate}</td>
						<td>${hotel.checkoutDate}</td>
						<td><a href="${updateLink}">更新</a>| <a href="${deleteLink}"
							onclick="if (!(confirm('確定刪除資料嗎?'))) return false">刪除</a></td>

					</tr>
				</c:forEach>

			</table>
		</form>
<!-- 		<div align="center"> -->
<!-- 			<button onclick="location.href='returnmainpage'">回主頁</button> -->
<!-- 			<br> -->
<!-- 		</div> -->
	</div>
</body>
</html>
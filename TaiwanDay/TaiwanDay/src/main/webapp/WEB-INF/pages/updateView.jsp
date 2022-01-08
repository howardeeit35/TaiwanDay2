<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-Type" content="text/html ; charset=UTF-8">
<title>更新飯店資訊</title>
</head>
<body>
	<div>
		<h2>更新飯店資訊</h2>
		<form action="updatehotel" method="post">
			<table>
				<tr>
					<td>飯店編號:</td>
					<td><input type="text" name="hotelid"
						value="${updatehotel.hotelId}" /></td>
				</tr>
				<tr>
					<td>飯店名稱:</td>
					<td><input type="text" name="hotelname"
						value="${updatehotel.hotelName}" /></td>
				</tr>
				<tr>
					<td>電話號碼:</td>
					<td><input type="text" name="hotelphonenum"
						value="${updatehotel.hotelPhonenum}" /></td>
				</tr>
				<tr>
					<td>飯店地址:</td>
					<td><input type="text" name="hoteladdress"
						value="${updatehotel.hotelAddress}" /></td>
				</tr>
				<tr>
					<td>金額:</td>
					<td><input type="text" name="hotelprice"
						value="${updatehotel.hotelPrice}" /></td>
				</tr>
				<tr>
					<td>房型:</td>
					<td><input type="text" name="roomstyle"
						value="${updatehotel.roomStyle}" /></td>
				</tr>
				<tr>
					<td>入住日期:</td>
					<td><input type="date" name="checkindate"
						value="${updatehotel.checkinDate}" /></td>
				</tr>
				<tr>
					<td>退房日期:</td>
					<td><input type="date" name="checkoutdate"
						value="${updatehotel.checkoutDate}" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" value="送出" /></td>
				</tr>
			</table>

			<h3>
				<td align="center"><a href="hotelView"><input type="button"
						value="回上一頁" /></a></td>
			</h3>
		</form>
	</div>
</body>
</html>
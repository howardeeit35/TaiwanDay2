<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html ; charset=UTF-8">
<title>新增飯店資訊</title>
</head>
<body>
	<div align="center">
		<h2>新增飯店資訊</h2>
		<form action="saveHotel" method="post">

			<table>
				<tr>
					<td>飯店名稱:</td>
					<td><input type="text" name="hotelname" id="" /></td>
				</tr>
				<tr>
					<td>電話號碼:</td>
					<td><input type="text" name="hotelphonenum" id="" /></td>
				</tr>
				<tr>
					<td>飯店地址:</td>
					<td><input type="text" name="hoteladdress" id="" /></td>
				</tr>
				<tr>
					<td>金額:</td>
					<td>$<input type="text" name="hotelprice" id="" /></td>
				</tr>
				<tr>
					<td>房型:</td>
					<td><input type="text" name="roomstyle" id="" /></td>
				</tr>
				<tr>
					<td>入住日期:</td>
					<td>西元<input type="date" name="checkindate" id="" /></td>
				</tr>
				<tr>
					<td>退房日期:</td>
					<td>西元<input type="date" name="checkoutdate" id="" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" value="新增"></td>
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
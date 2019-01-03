<%@ page language="java" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/register" method="post">
		<table id="ec_table" class="tableRegion" width="98%">
			<tr>
				<td>用户名：</td>
				<td><input id="userName" type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>昵称：</td>
				<td><input type="text" name="userNickname" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" name="userPassword" /></td>
			</tr>
			<tr>
				<td>出生年份：</td>
				<td><input type="text" name="userBirthYear" /></td>
			</tr>
			<tr>
				<td>身高：</td>
				<td><input type="text" name="userHeight" /></td>
			</tr>
			<tr>
				<td>体重：</td>
				<td><input type="text" name="userWeight" /></td>
			</tr>			
			<tr>
				<td>手机：</td>
				<td><input type="text" name="userPhone" /></td>
			</tr>	
			<tr>
				<input value='ok' type='submit'>
			</tr>					
		</table>
		</form>

	</body>
</html>



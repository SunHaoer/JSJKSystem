<%@ page language="java" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/login" method="post">
		<table id="ec_table" class="tableRegion" width="98%">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<input value='ok' type='submit'>
			</tr>					
		</table>
		</form>
	</body>
</html>



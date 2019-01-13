<%@ page language="java" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
		<script type="text/javascript">
			function getPhoneVerificationCode() {
				var userPhone = $("input[name='userPhone']").val();
				$.ajax({
					type: "GET", 
					data: {userPhone: userPhone},
					dataType: "json",
 					url: "${pageContext.request.contextPath}/getPhoneVerificationCode",
 					success: function() { alert("发送成功"); }
				}); 
			}
			
			function checkUserNameIsLegal() {
				var userName = $("input[name='userName']").val();
				$.ajax({
					type: "GET",
					data: {userName: userName},
					dataType: "json",
					url: "${pageContext.request.contextPath}/validateUserName",
					success: function() { alert("开始验证"); }
				});
			}
			
			function checkUserPhoneIsLegal() {
				alert("lala");
				var userPhone = $("input[name='userPhone']").val();
				$.ajax({
					type: "GET",
					data: {userPhone: userPhone},
					dataType: "json",
					url: "${pageContext.request.contextPath}/validateUserPhone",
					success: function() { alert("开始验证"); }
				});
			}
		</script>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/register" method="post">
		<table id="ec_table" class="tableRegion" width="98%">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="userName" /></td>
				<td><a onclick="checkUserNameIsLegal()" aria-label="Close">验证用户名</a></td>
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
				<td>确认密码</td>
				<td><input type="text" name="userPassword2"/></td>
			</tr>
			<tr>
				<td>出生年份：</td>
				<td><input type="text" name="userBirthYear" value="0"/></td>
			</tr>
			<tr>
				<td>身高：</td>
				<td><input type="text" name="userHeight" value="0"/></td>
			</tr>
			<tr>
				<td>体重：</td>
				<td><input type="text" name="userWeight" value="0"/></td>
			</tr>			
			<tr>
				<td>手机：</td>
				<td><input type="text" name="userPhone" /></td>
				<td><a onclick="checkUserPhoneIsLegal()" aria-label="Close">验证手机</a></td>
				<td><a onclick="getPhoneVerificationCode()" aria-label="Close">获取验证码</a></td>
			</tr>	
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="phoneVerificationCode" /></td>
			</tr>	
			<tr>
				<input value='ok' type='submit'>
			</tr>					
		</table>
		</form>
	</body>
</html>



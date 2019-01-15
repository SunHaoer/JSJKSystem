<%@ page language="java" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
		<script type="text/javascript">
			var uri1 = "http://www.wochi.xin/jsjksystem";
			var uri2 = "${pageContext.request.contextPath}";
			uri = uri2;
			
			function getPhoneVerificationCode() {
				var userPhone = $("input[name='userPhone']").val();
				$.ajax({
					type: "GET", 
					data: {userPhone: userPhone},
					dataType: "json",
 					url: uri + "/getPhoneVerificationCode",
 					success: function() { alert("验证结束"); }
				}); 
			}
			
			function checkUserNameIsLegal() {
				var userName = $("input[name='userName']").val();
				$.ajax({
					type: "GET",
					data: {userName: userName},
					dataType: "json",
					url: uri + "/validateUserName",
					success: function() { alert("验证结束"); }
				});
			}
			
			function checkUserPhoneIsLegal() {
				var userPhone = $("input[name='userPhone']").val();
				$.ajax({
					type: "GET",
					data: {userPhone: userPhone},
					dataType: "json",
					url: uri + "/validateUserPhone",
					success: function() { alert("验证结束"); }
				});
			}
			
			function validatePhoneVerificationCode() {
				var phoneVerificationCode = $("input[name='phoneVerificationCode']").val();
				$.ajax({
					type: "GET",
					data: {phoneVerificationCode: phoneVerificationCode},
					dataType: "json",
					url: uri + "/validateVerificationCode",
					success: function() { alert("验证结束"); }
				});
			}
			
			function test1() {
				$.ajax({
					type: "GET",
					dataType: "json",
					url: uri1 + "/test1",
					success: function() { alert("success");  }
				});
			}
			
			function test2() {
				$.ajax({
					type: "GET",
					dataType: "json",
					url: uri1 + "/test2",
					success: function() { alert("success");  }
				});
			}
			
			function test3() {
				$.ajax({
					type: "GET",
					dataType: "json",
					url: uri1 + "/test3",
					success: function() { alert("success");  }
				});
			}
			
		</script>
	</head>
	<body>
		<a onclick="test1()" aria-label="Close">test1</a>
		<a onclick="test2()" aria-label="Close">test2</a>
		<a onclick="test3()" aria-label="Close">test3</a>
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
				<td><a onclick="validatePhoneVerificationCode()" aria-label="Close">验证验证码</a></td>
			</tr>	
			<tr>
				<input value='ok' type='submit'>
			</tr>					
		</table>
		</form>
	</body>
</html>



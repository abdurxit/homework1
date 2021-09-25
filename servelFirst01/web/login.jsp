<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="UTF-8">

		<title></title>
			<script>
			function checkForm(){
				var usertip=checkUserName();
				var pwdtip=checkPassword();
				var cpwedtip=ConfirmPassword();
				var emailtip=checkemail();
				var phonetip=checkPhone();
				
				return usertip && pwdtip && cpwedtip && emailtip && phonetip;
			}
			//验证用户名
			function checkUserName(){
				var user=document.getElementById("userName");
				var eror=document.getElementById('userErr');
				var pattern = /^\w{3,}$/;  //用户名格式正则表达式：用户名要至少三位
				if(!pattern.test(user.value) || user.value.length==0){
					eror.innerHTML="用户名不规范";
					eror.className="eror";
					return false;
				}else{
					eror.innerHTML="正确";
					eror.className="success";
					return true;
				}
			}
			//验证密码
			function checkPassword(){
				var pwd=document.getElementById("userPasword");
				var eror=document.getElementById("passwordErr");
				var pattern = /^\w{4,8}$/; //密码要在4-8位   正则表达式
				if(!pattern.test(pwd.value)){
					eror.innerHTML="密码不规范";
					eror.className="eror";
					return false;
				}else{
					eror.innerHTML="正确";
					eror.className="success";
					return true;
				}
			}
			//验证确认密码
			function ConfirmPassword(){
				var cpwd=document.getElementById("userConfirmPasword");
				var pwd=document.getElementById("userPasword");
				var eror=document.getElementById("confirmpasswordErr");
				if(cpwd.value!=pwd.value||cpwd.value.length==0){
					eror.innerHTML="两次密码不一致";
					eror.className="eror";
					return false;
				}else{
					eror.innerHTML="正确";
					eror.className="success";
					return true;
				}
			}
			//验证电子邮箱
			function checkemail(){
				var eamil=document.getElementById("useremail");
				var eror=document.getElementById("emailErr");
				var pattern = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;//邮箱
				if(!pattern.test(eamil.value) || eamil.value.length==0){
					eror.innerHTML="邮箱格式不规范";
					eror.className="eror";
					return false;
				}else{
					eror.innerHTML="正确";
					eror.className="success";
					return true;
				}
			}
			//验证手机号
			function checkPhone(){
				var phone=document.getElementById("userPhone");
				var eror=document.getElementById("phoneErr");
				var pattern = /^1[34578]\d{9}$/; //验证手机号正则表达式
				if(!pattern.test(phone.value)|| phone.value.length==0){
					eror.innerHTML="手机号码格式不规范";
					eror.className="eror";
					return false;
				}else{
					eror.innerHTML="正确";
					eror.className="success";
					return true;
				}
			}
		</script>
	</head>
	<body>
		<div class="divAll">
			<div id="titles">欢迎注册</div>
			<div id="contents">
				<h3>基本信息</h3>
			<hr color="darkslategray" width="95%" />
				<form action="http://localhost:8080/servelFirst01/login.html" method="get" onsubmit="return checkForm()">
					<div class="form-itemGroup">
						<label for="userName">用户名：</label>
						<input type="text" id="userName" name="userName" class="userName" onblur="checkUserName()" oninput="checkUserName()"/>
						<span class="default" id="userErr">请输入至少3位的用户名</span>
					</div>
					<div class="form-itemGroup">
						<%--@declare id="userpassword"--%><label for="userPassword">密码：</label>
						<input type="password" id="userPasword" name="pwd" class="userName" onblur="checkPassword()" oninput="checkPassword()"/>
						<span class="default" id="passwordErr">请输入4到8位的密码</span>
					</div>
					<div class="form-itemGroup">
						<%--@declare id="conpassword"--%><label for="conpassword">确认密码：</label>
						<input type="password" id="userConfirmPasword" name="cpwd" class="userName" onblur="ConfirmPassword()" oninput="ConfirmPassword()"/>
						<span class="default" id="confirmpasswordErr">请输入确认密码</span>
					</div>
					<div class="form-itemGroup">
						<%--@declare id="useemail"--%><label for="useEmail">电子邮箱：</label>
						<input type="email" id="useremail" name="email" class="userName" onblur="checkemail()" oninput="checkemail()"/>
						<span class="default" id="emailErr">请输入电子邮箱</span>
					</div>
					<div class="form-itemGroup">
						<label for="userPhone">手机号：</label>
						<input type="text" id="userPhone" name="phone" class="userName" onblur="checkPhone()" oninput="checkPhone()"/>
						<span class="default" id="phoneErr">请输入11位手机号</span>
					</div>
					<div>
						<button type="submit" class="divBneath">注册</button>
						<button type="reset" class="divBneath">重置</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
<style type="text/css">
	.divAll{
		width: 800px;
		margin: 50px auto;
	}
	#titles{
		background-color: mediumorchid;
		height: 70px;
		line-height: 70px;
		text-align: center;
		color: white;
		size: 22px;
		font-weight: bold;
		border: 5px solid skyblue;
	}
	#contents{
		background-color: mediumspringgreen;
		margin-top: 1px;
		border: 5px solid skyblue;
	}
	.form-itemGroup{
		padding: 20px;
	}
	.form-itemGroup label{
		display: inline-block;
		color: blue;
		width: 200px;
		height: 32px;
		text-align: right;
	}
	.form-itemGroup .userName{
		width: 200px;
		height: 30px;
		border: 3px solid darkgray;
	}
	.form-itemGroup .default{
		color: gold;
	}
	.form-itemGroup .eror{
		color: red;
	}
	.form-itemGroup .success{
		color: green;
	}
	 .divBneath{
        margin-top: 20px;
        margin-left: 190px;
        margin-bottom: 20px;
        background-color: darkslategrey;
        color: white;
	}
</style>
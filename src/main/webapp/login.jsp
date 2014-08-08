<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<style type="text/css">
span {
bakcground-color : gray;
float : left;
width : 70px;
}
</style>
</head>
<body>

<form action="/login" method="post">
<span>用户名：</span><input type="text" name="username"></input> <br/>
<span>密码：</span><input type="password" name="password"></input> </br>
<input type="submit" value="登  陆"></input> <br/>

<h3 style="color:red;">${loginErrorMsg }</h3>


</form>

</body>
</html>
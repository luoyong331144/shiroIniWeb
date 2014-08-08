<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.shiro.SecurityUtils" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功登陆</title>
</head>
<body>

<h1>你已经成功登陆了：<%=SecurityUtils.getSubject().getPrincipal() %></h1>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>绝密页面，<%=SecurityUtils.getSubject().getPrincipal() %></h1>
<shiro:hasRole name="role1">
<h2>role1 可见</h2>
</shiro:hasRole>

<shiro:hasPermission name="user:manager">
<h2>你可以管理用户</h2>
</shiro:hasPermission>

</body>
</html>
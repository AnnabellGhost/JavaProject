<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  
  <body>
  <div class="login">
  
  <h2>User Login</h2>
	<form action="user/userlogin.action" method="get">
		username:<input type="text" name="user.username" /><br/>
		password:<input type="password" name="user.password"/><br/>
		<input class="button" type="submit"/><input class="button" type="reset"/>
	    
	</form>
	<ul class="errorMessage">
	
	<s:fielderror></s:fielderror>
	
	</ul>
	<div id="backtoindex">
	<a href="index.jsp">欢迎页面</a>
	</div>
	</div>
  </body>
</html>

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
  
 <body id="b">
 <div class="login">
  <a href="changelanguage.action?request_locale=zh_CN">中文</a> &nbsp;&nbsp;<a href="changelanguage.action?request_locale=en_GB">English</a>
  <br/>
  <br/>
  <h2><s:text name="html.login.title"></s:text></h2>
  
	<form action="user/login.action" method="get">
		<s:text name="html.login.username"></s:text>:<input class="button" type="text" name="user.username" /><br/>
		<s:text name="html.login.password"></s:text>&nbsp;&nbsp;:<input class="button" type="password" name="user.password"/><br/>
		<input class="button" type="submit" value="<s:text name='html.login.submit'/>"/><input class="button" type="reset" value="<s:text name='html.login.reset'/>"/>
	    
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

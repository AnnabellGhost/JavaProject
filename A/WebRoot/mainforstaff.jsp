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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  
  <body id="a">
  <div class="loginfopic"></div>
  <div class="loginfo" width="270px" height="270px">
    <s:if test="#session.userinfo==null">
  	<a href="/A/userlogin.jsp">请登录</a>
  </s:if>
  <s:else>
  	欢迎<s:property  value="#session.userinfo.username"/>登录  
  	    <a href="<%=basePath%>user/userlogoff.action">退出</a>
  </s:else>
  </div>
    <div class="main">
    <a href="<%=basePath%>staff/selectallstaffinfoforstaff.action">员工信息</a>
    <a href="<%=basePath%>dept/selectalldeptforstaff.action">部门信息</a>
    <a href="<%=basePath%>salary/getsalarybystaffid.action?sal.staffid=<s:property  value="#session.userinfo.staffid"/>">工资信息</a>
    <a href="<%=basePath%>off/selectoffbystaffid.action?off.staffid=<s:property  value="#session.userinfo.staffid"/>">请假信息</a>
    </div>
  </body>
</html>

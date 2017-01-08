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
    
    <title>My JSP 'showalldept.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  
  <body id="b">
  <div class="tablediv">
   <table border="1" width="800px">
  		<tr>
  			<td>部门编号</td>
  			<td>部门名</td>
  			<td>详情</td>
  			
  		</tr>
   		<s:iterator value="depts" id="u">
   			<tr>
  				<td><s:property value="#u.deptid"/></td>
  				<td><s:property value="#u.deptname"/></td>
  				<td><s:property value="#u.detail"/></td>
  			    <td><a href="staff/selectstaffinfobydeptid.action?dept.deptid=<s:property value="#u.deptid"/>" target="myframe">查询人员</a></td>
  			</tr>
   		</s:iterator>
   		<s:fielderror></s:fielderror>
   	</table>
   	<div id="content">
	<iframe name="myframe" width="800" height="200"></iframe>
    </div> 
    </div>
    <a href="mainforstaff.jsp">返回主页</a>
  </body>
</html>

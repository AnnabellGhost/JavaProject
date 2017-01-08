<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
    
    <title>My JSP 'showalluser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>

<body id="b">
<div class="tablediv2">
<table border="1" width="600px" height="200px">
  		
  	    <s:iterator value="staffinfos" id="u">
   			<tr>
   			    <td>员工号</td>
  				<td><s:property value="#u.staffid"/></td>
  				<td>姓名</td>
  				<td><s:property value="#u.name"/></td>
  		    </tr>
  		    <tr>
  		        <td>出生年份</td>		
  				<td><s:property value="#u.birthyear"/></td>
  				<td>教育情况</td>
  				<td><s:property value="#u.edu"/></td>
  		    </tr>	
  		    <tr>	 
  		        <td>电话</td>
  				<td><s:property value="#u.tel"/></td>
  				<td>简介</td>
  				<td><s:property value="#u.intro"/></td>
  			</tr>
  			<tr>	
  			    <td>照片</td>
  				<td><img src="<s:property value="#u.image"/>" width="50" height="30"/></td>
  				<td>部门</td>
  				<td><a href="<%=basePath%>staff/selectstaff.action?staff.staffid=<s:property value="#u.staffid"/>">分配</a></td>
  			</tr>
  			<tr id="space"></tr>
   		</s:iterator>
  	    
  	    <s:fielderror></s:fielderror>
  	    
  	    
 </table>
 </div>
 <a href="main.jsp">返回主页</a>
</body>
</html>
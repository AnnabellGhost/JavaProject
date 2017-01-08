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
    
    <title>My JSP 'showcertaindept.jsp' starting page</title>
    
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
  		
  	    <s:iterator value="staffinfos" id="u">
   			<tr>
  				<td height="33px"><s:property value="#u.staffid"/></td>
  				<td><s:property value="#u.name"/></td>
  				<td><a class="special1" href="<%=basePath%>salary/preinsertsal.action?staffinfo.staffid=<s:property value="#u.staffid"/>">工资条</a></td>
  			</tr>
   		</s:iterator>
  	    
  	    <s:fielderror></s:fielderror>
  	    
  	    
 </table>
 </div>
 <br/>
 <a class="special2" href="<%=basePath%>salary/getallsalary.action">全部记录</a>
</body>
</html>
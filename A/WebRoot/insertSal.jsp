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
    
    <title>My JSP 'insertSal.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  
 <body>
		<form action="<%=basePath%>salary/calculatesalary.action" method="post">
			<table border="1" width="400">
				<tr>
					<td width="50px">员工编号</td>
					<td><s:textfield name="sal.staffid" theme="simple" readonly="true"/></td>
				</tr>
				<tr>
					<td>工资条编号</td>
					<td><s:textfield  name="sal.salaryid" theme="simple" />
				</tr>
				<tr>
					<td>年</td>
					<td><s:textfield  name="sal.year" theme="simple" />
				</tr>				
				<tr>
					<td>月</td>
					<td><s:textfield  name="sal.month" theme="simple" />
				</tr>
				
				<tr>
					<td><input type="submit" value="添加" onclick="conpwd()"/></td>
					<td><input type="reset" value="重置"/></td>
				</tr>
			</table>
		</form>
		<s:fielderror></s:fielderror>
		<a href="javascript:history.back()">返回</a>
	</body>
</html>

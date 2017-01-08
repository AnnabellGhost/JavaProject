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
    
    <title>My JSP 'insertUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
	<body>
		<form action="user/updateuser.action" method="post">
			<table border="1" width="400">
				<tr>
					<td width="50px">编号</td>
					<td><s:textfield id="uid" name="user.staffid" theme="simple" readonly="true"/></td>
				</tr>
				<tr>
					<td>用户名</td>
					<td><s:textfield id="uname"  name="user.username" theme="simple" readonly="true"/></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><s:password name="user.password" theme="simple"/></td>
				</tr>				
				<tr>
					<td>确认密码</td>
					<td><input type="password" name="conpwd"></td>
				</tr>
				<tr>
					<td>角色</td>
					<td><select name="user.role">
							<option value="admin">管理员</option>
							<option value="member" selected>会员</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="更新"/></td>
					<td><input type="reset" value="重置"/></td>
				</tr>
			</table>
			<input type="hidden" name="user.status" value="<s:property value='user.status'/>"/>
			<input type="hidden" name="user.wrongnum" value="<s:property value='user.wrongnum'/>"/>
		</form>
		<s:fielderror></s:fielderror>
		<a href="javascript:history.back()">返回</a>
	</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript">
	function deleteconfirm(){
		b = confirm("是否删除该用户？");
		return b;
	}
</script>
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
  	<div class="tablediv">
  	<table border="1" width="800px">
  		<tr>
  			<td>编号</td>
  			<td>用户名</td>
  			<td>角色</td>
  			<td>状态</td>
  			<td>密码错误次数</td>
  			<td>更新</td>
  			<td>删除</td>
  			<td>解锁</td>
  			<td>填写员工信息</td>
  		</tr>
   		<s:iterator value="users" id="u">
   			<tr>
  				<td><s:property value="#u.staffid"/></td>
  				<td><s:property value="#u.username"/></td>
  				<td><s:property value="#u.role"/></td>
  				<td>
  					<s:if test="%{#u.status==1}">未锁定</s:if>
  					<s:else>已锁定</s:else>
  				</td>
  				<td><s:property value="#u.wrongnum"/></td>
  				<td><a href="user/selectuserbyid.action?user.staffid=<s:property value="#u.staffid"/>">更新</a></td>
  				<td><a href="user/deleteuser.action?user.staffid=<s:property value="#u.staffid"/>" onclick="return deleteconfirm()">删除</a></td>
  				<td>
  					<s:if test="%{#u.status==1}">解锁</s:if>
  					<s:else>
  						<a href="user/userunlock.action?user.staffid=<s:property value="#u.staffid"/>">解锁</a>
  					</s:else>
  				</td>
  				<td><a href="staff/selectstaffinfo.action?staffinfo.staffid=<s:property value="#u.staffid"/>">填写信息</a></td>
  			</tr>
   		</s:iterator>
   		<s:fielderror></s:fielderror>
   	
   	</table>
   	<a href="javascript:history.back()">返回</a>
   	</div>
  </body>
</html>

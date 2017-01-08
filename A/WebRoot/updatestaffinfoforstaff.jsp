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
    
    <title>My JSP 'insertUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<style type="text/css">
		.errorMessage{list-style-type:none;color: red;}
	</style>
  </head>
<body id="b">
<form action="<%=basePath%>staff/updatestaffinfoforstaff.action" method="post" enctype="multipart/form-data">
			<table border="1" width="400">
				<tr>
					<td >员工编号</td>
					<td><s:textfield name="staffinfo.staffid" theme="simple" readonly="true"/></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><s:textfield name="staffinfo.name" /></td>
				</tr>
				<tr>
					<td>出生年份</td>
					<td><s:textfield name="staffinfo.birthyear" /></td>
				</tr>
				<tr>
					<td>毕业院校</td>
					<td><s:textfield name="staffinfo.edu" /></td>
				</tr>
				<tr>
					<td>联系电话</td>
					<td><s:textfield name="staffinfo.tel" /></td>
				</tr>
				<tr>
					<td>简介</td>
					<td><s:textfield name="staffinfo.intro" /></td>
				</tr>
				<tr>
					<td>照片</td>
					<td><s:file name="staffinfo.uploadImage"/></td>
				</tr>
				<tr>
					<td><input class="button" type="submit" value="修改"/></td>
					<td><input class="button" type="reset" value="重置"/></td>
				</tr>
			</table>
		</form>
		<br/>
		<a href="mainforstaff.jsp">返回主页</a>
</body>
</html>
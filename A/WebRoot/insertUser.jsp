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
		<style type="text/css">
.errorMessage {
	list-style-type: none;
	color: red;
	
}
</style>
	</head>
	<script type="text/javascript">
		function checkname(){
			u = document.getElementById("uname");
			uid = document.getElementById("uid");
			if(u.value==""){
				alert("请输入用户名.");
			}
			else{
				//提交一个请求
				location.href="checkname.action?user.staffid="+uid.value+"&user.username="+u.value;
		    }
		}
		
		function conpwd(){
			p1 = document.getElementById("p1");
			p2 = document.getElementById("p2");
			
			if(p2.value != p1.value){
				alert("两次密码必须一致");
				return false;
			}
		}
	</script>
	<body id="b">
		<form action="<%=basePath%>user/insertuser.action" method="post">
			<table border="1" width="400">

				<tr>
					<td width="75">
						编号
					</td>
					<td width="215">
						<s:textfield id="uid" name="user.staffid" theme="simple"
							readonly="true" />
					</td>
				</tr>
				
				<tr>
					<td>
						用户名
					</td>
					<td>
						<s:textfield id="uname" name="user.username" theme="simple" />
				    </td>
				    <td>
						<input type="button" class="button" value="检查重名" onClick="checkname()" />
					</td>
				</tr>
				<tr>
					<td>
						密码
					</td>
					<td>
						<input id="p1" type="password" name="user.password">
					</td>
				</tr>
				<tr>
					<td>
						确认密码
					</td>
					<td>
						<input id="p2" type="password" name="conpwd">
					</td>
				</tr>
				<tr>
					<td>
						角色
					</td>
					<td>
						<select name="user.role">
							<option value="admin">
								管理员
							</option>
							<option value="member" selected>
								会员
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" class="button" value="添加" onClick="conpwd()" />
					</td>
					<td>
						<input type="reset" class="button" value="重置" />
					</td>
				</tr>


			</table>

		</form>
		<s:fielderror></s:fielderror>
		<a href="javascript:history.back()">返回</a>
	</body>
</html>

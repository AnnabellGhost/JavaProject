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
    
    <title>My JSP 'showalloff.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  
  <body id="b">
   <form id="form" action="off/selectalloffbyoption.action">
    	年：<input type="text" name="off.year"/>
    	月：<input type="text" name="off.month"/>
    	日：<input type="text" name="off.day"/>
    	<input type="submit" value="按条件查询"/>
    </form>
    <h3>用0占位</h3>
    <div class="tablediv">
    <table border="1" width="800px">
  		<tr>
  	
  			<td>员工号</td>
  			<td>请假条编号</td>
  			<td>年份</td>
  			<td>月份</td>
  			<td>日期</td>
  			<td>类型</td>
  			<td>备注</td>
  			
  	    </tr>
  	    <s:iterator value="alloff" id="s">
   			<tr>
  				<td><s:property value="#s.staffid"/></td>
  				<td><s:property value="#s.offid"/></td>
  				<td><s:property value="#s.year"/></td>
  				<td><s:property value="#s.month"/></td>
  				<td><s:property value="#s.day"/></td>
  				<td><s:property value="#s.type"/></td>
  				<td><s:property value="#s.note"/></td>
  			</tr>
   		</s:iterator>
  	    
  	    <s:fielderror></s:fielderror>
  	    
  	    
 </table>
 <br/>
 <br/>
 <a href="main.jsp">返回主页</a>
 </div>
  </body>
</html>

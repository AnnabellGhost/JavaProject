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
    
    <title>My JSP 'showallsalary.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css">

  </head>
  
  <body>
   <form id="form" action="salary/selectallsalarybyoption.action">
    	年：<input type="text" name="sal.year"/>
    	月：<input type="text" name="sal.month"/>
    	员工号：<input type="text" name="sal.staffid"/>
    	<input type="submit" value="按条件查询"/>
    </form>
  
  
  
  <table border="1" width="800px">
  		<tr>
  	
  			<td>员工号</td>
  			<td>工资条编号</td>
  			<td>年份</td>
  			<td>月份</td>
  			<td>工资</td>
  			
  	    </tr>
  	    <s:iterator value="allsalary" id="s">
   			<tr>
  				<td><s:property value="#s.staffid"/></td>
  				<td><s:property value="#s.salaryid"/></td>
  				<td><s:property value="#s.year"/></td>
  				<td><s:property value="#s.month"/></td>
  				<td><s:property value="#s.salary"/></td>
  			</tr>
   		</s:iterator>
  	    
  	    <s:fielderror></s:fielderror>
 
  	    
 </table>
  </body>
</html>

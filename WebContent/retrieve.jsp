
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jwt.struts.form.RegisterUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee List</title>
</head>

 <body>
        <h1>List of users who have access. </h1>

		<%List<RegisterUser> uslist= (ArrayList<RegisterUser>)request.getAttribute("users"); %>
<table >
  <tr>
  	<th>Employee ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Age</th>
    <th>Date Of Birth</th>
    <th>Role Name</th>
  </tr>
 <% for(int i = 0; i < uslist.size(); i+=1) { %>
            <tr>      
                <td><%= uslist.get(i).getEmpid()%></td>
                <td><%= uslist.get(i).getFname()%></td>
                <td><%= uslist.get(i).getLname()%></td>
                <td><%= uslist.get(i).getAge()%></td>
                <td><%= uslist.get(i).getDob1()%></td>  
                <td><%= uslist.get(i).getRole()%></td>
            </tr>
  <%}%>
</table>
 </body>
</html>
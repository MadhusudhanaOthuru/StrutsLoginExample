<%-- 
    Document   : success
    Created on : Dec 15, 2008, 4:08:53 AM
    Author     : eswar@vaannila.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register User</title>
    </head>
    <body>
    <div style="color:blue">
        <h1>Registration Successful. Welcome <bean:write name="RegisterUser" property="fname"></bean:write></h1>
        </div>
    </body>
   </html>

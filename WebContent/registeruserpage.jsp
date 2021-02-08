
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body>
  <div style="color:red">
            <html:errors />
        </div>
        <html:form action="/Register" >
            Employee ID : <html:text name="RegisterUser" property="empid" /> <br>
            First Name  : <html:text name="RegisterUser" property="fname" /> <br>
            Last Name  : <html:text name="RegisterUser" property="lname" /> <br>
            Age  : <html:text name="RegisterUser" property="age" /> <br>
            Date Of Birth  : <html:text name="RegisterUser" property="dob" /> <br>
            Role  : <html:text name="RegisterUser" property="role" /> <br>
            <html:submit value="Register" />
        </html:form>
</body>
</html>
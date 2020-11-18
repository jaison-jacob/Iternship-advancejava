<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>success message</title>
</head>
<body>

<%=request.getAttribute("data")%> 

<form action="login" method="get">
<input type="hidden" name="page" value="login" >
<input type="submit" name="login" value="login page">

</form>

</body>
</html>
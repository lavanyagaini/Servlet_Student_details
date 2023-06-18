<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String message=(String)request.getAttribute("message"); %>
<%if(message!=null){ %>
<%= message %>
<%} %>
<form action="login" method="post">
<table>
<tr>
<td>Email
<input type="email" name="email">
</td>
</tr>
<tr>
<td>Password
<input type="password" name="password">
</td>
</tr>
<tr>
<td>
<input type="submit" name="Login">
</td>
</tr>



</table>

</form>
</body>
</html>
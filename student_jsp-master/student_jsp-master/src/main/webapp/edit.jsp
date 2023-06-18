<%@page import="jsp_task_dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Student student=(Student)request.getAttribute("student"); %>
<form action="edit" method="post"><table>
Id:<input type="number" name="id" placeholder="Enter your id" value=<%=student.getId() %> readonly="true">
Name:<input type="text" name="name" placeholder="Enter your name" value="<%=student.getName() %>">
<br>
Fathername:<input type="text" name="fathername" placeholder="Enter your fathername" value=<%=student.getFathername() %>>
<br>
Email:<input type="email" name="email" placeholder="Enter your email" value=<%=student.getEmail() %>>
<br>
Password:<input type="text" name="password" placeholder="Enter your password"value=<%=student.getPassword() %>>
<br>
Phone:<input type="tel" name="phone" placeholder="Enter your phone" value=<%=student.getPhone() %>>
<br>
<input type="submit" value="Submit">

</table>

</form>
</body>
</html>
<%@page import="com.bean.Standard"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="com.bean.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="100%">
	<tr>
		<th>Student ID</th>
		<th>Standard</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>DOB</th>
		<th>Created Date</th>
		<th>Image</th>
		<th>Status</th>
	</tr>
	<%
		List<Student> list=StudentDao.getAllStudent();
		for(Student s:list)
		{
			Standard std=StudentDao.getStandard(s.getSid());
	%>
	<tr>
		<td><%=s.getId() %></td>
		<td><%=std.getName() %></td>
		<td><%=s.getFname() %></td>
		<td><%=s.getLname() %></td>
		<td><%=s.getDob() %></td>
		<td><%=s.getCreated_date() %></td>
		<td><img src="product_images/<%=s.getImage()%>" width="100px" height="100px"></td>
		<td><%=std.getStatus() %></td>
	</tr>
	<%
		}
	%>
</table>
<a href="insert.jsp">Add New Student</a>
</body>
</html>
<%@page import="com.dao.StudentDao"%>
<%@page import="com.bean.Standard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Student Management</title>
</head>
<body>
<%
	List<Standard> list=StudentDao.getAllStandard();
%>
<form name="insert" action="StudentController" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>Select Standard</td>
			<td>
				<select name="standard">
					<option>---Select Standard---</option>
					<%
						for(Standard s:list)
						{
					%>
						<option value="<%=s.getId()%>"><%=s.getName() %></option>
					<%	
						}
					%>
				</select>
			</td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="fname"></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lname"></td>
		</tr>
		<tr>
			<td>DOB</td>
			<td><input type="date" name="dob"></td>
		</tr>
		<tr>
			<td>Image</td>
			<td><input type="file" name="image"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="action" value="Insert">
			</td>
		</tr>
	</table>
</form>
<a href="insert_standard.jsp">Insert Standard</a><br><br>
<a href="show.jsp">Show All Student</a>
</body>
</html>
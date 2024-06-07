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

<form name="insert" action="StandardController" method="post">
	<table>
		
		<tr>
			<td>Standard Name</td>
			<td><input type="text" name="sname"></td>
		</tr>
		<tr>
			<td>Standard Status</td>
			<td><input type="text" name="status"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" name="action" value="Insert Standard">
			</td>
		</tr>
	</table>
</form>
<a href="insert.jsp">Insert Student</a>
</body>
</html>
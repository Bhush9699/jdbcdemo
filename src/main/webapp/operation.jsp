<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eemock", "root", "MySql");
Statement st=cn.createStatement();
ResultSet rs=st.executeQuery("select * from student");
%>
<a href="addStudent.html">Add Student</a>

<table cellpadding="20px">
<th>ID</th>
<th>Name</th>
<th>Age</th>
<th>MobileNumber</th>
<th>Stream</th>
<%
while(rs.next())
{
%>
<tr>
<td>rs.getInt(1)</td>
<td>rs.getString(2)</td>
<td>rs.getInt(3)</td>
<td>rs.getLong(4)</td>
<td>rs.getString(5)</td>
<td><a href="deletestudent?id=<%rs.getInt(1);%>"></a></td>
<td><a href="updatestudent?id=<%rs.getInt(1);%>"></a></td>
</tr>
<%} %>

</table>

</body>
</html>
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
	Cookie cookie[]=request.getCookies();
	if(cookie!=null)
	{	out.println("Login successfull!!");
		RequestDispatcher rd=request.getRequestDispatcher("operation.jsp");
		rd.include(request, response);
	}
%>

<form action="saveadmin">
Enter id:<input value="text" name="id">
Enter email:<input value="text" name="email">
Enter password:<input value="text" name="password">
<button type="submit">Sign Up</button>
</form>

</body>
</html>
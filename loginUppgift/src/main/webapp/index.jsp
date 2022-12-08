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
		if (session.getAttribute("isLoggedIn") != null){
			response.sendRedirect(request.getContextPath()+"/views/ShowLogin.jsp");
		}
	%>
	
	<h3>Login here.</h3>
	<form action="<%=request.getContextPath()%>/LoginServlet" method="Post">
		<p>Account: </p>
		<input type="text" name="userName">
		<p>Password: </p>
		<input type="text" name="password"><br><br>
		<input type="submit" value="Submit">
	</form>
	<p> Try: John silver or billy bob</p>
</body>
</html>
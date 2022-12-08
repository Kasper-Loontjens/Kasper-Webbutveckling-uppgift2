<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.LoginBean" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if(session.getAttribute("isLoggedIn") !=null){
			out.print("<p>Welcome to profile shithead</p>");
		}else {
			out.print("<h1>Error</h1>");
			response.sendRedirect("index.jsp");
		}
 	%>
 	
 	<form action="<%=request.getContextPath()%>/LoginServlet" method="Get">
 		<input type="text" name="food"><br><br>
		<input type="submit" value="Favorite food?">
 	</form>
 	
 	<%
 		LoginBean loginBean = (LoginBean) session.getAttribute("isLoggedIn");
		out.println("<h1> Hello " + loginBean.getUsername() + "</h1>");
		out.println("<h1> Your favorite food is: " + loginBean.getFood() + "</h1>");
 		
 		out.print("<form action='" + request.getContextPath() + "/LogoutServlet' method='POST'>");
		out.print("<input type='submit' value='logout' />");
		out.print("</form>");
 	%>
</body>
</html>
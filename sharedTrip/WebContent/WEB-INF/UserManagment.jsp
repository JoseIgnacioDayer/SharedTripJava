<%@ page import="entidades.Usuario"%>
<%@	page import = "java.util.LinkedList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SharedTrip</title>
<%
	Usuario u = (Usuario)session.getAttribute("usuario");
	LinkedList<?> users = (LinkedList<?>)request.getAttribute("listaUsuarios"); //puse el ? para que no me tire warning
	
%>
</head>
<body>

</body>
</html>
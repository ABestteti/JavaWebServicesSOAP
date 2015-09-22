<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controle de usuário</title>
</head>
<body>
	<div align="center">
		<h1>Logon efetuado com sucesso!</h1>
		<br>
		<h1>Olá, <%=request.getAttribute("nome")%> !</h1>
		<br> 
		<br> 
		<a href="index.jsp">Sair</a>
	</div>
</body>
</html>
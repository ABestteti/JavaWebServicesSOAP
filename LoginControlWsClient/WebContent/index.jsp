<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controle de usuário</title>
</head>
<body>
	<h1>Efetuar Logon</h1>
	<br>
	<!-- <form action="LoginControlServlet" method="POST"> -->
	<form action="LoginControlServlet" method="POST">
		<table border="0">
			<tr>
				<td>E-mail</td>
				<td><input type="TEXT" name="email"></td>
			</tr>
			<tr>
				<td>Senha</td>
				<td><input type="PASSWORD" name="senha"></td>
			</tr>
			<tr>
				<td><input type="RESET" value="Limpar"></td>
				<td><input type="SUBMIT" value=" Envia "></td>
			</tr>
		</table>
	</form>
</body>
</html>
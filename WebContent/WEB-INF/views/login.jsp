<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css"/> ">
<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js"/> "></script>
</head>
<body>
	<div class="flex-align">
		<div class="${typeMsg}">
			${msg}
		</div>
		<div class="loginmodal-container">
			<h1>Login</h1><br>
		  <form method="post">
			<input type="text" name="login" placeholder="usuário">
			<input type="password" name="senha" placeholder="senha">
			<input type="submit" class="login loginmodal-submit" value="Login">
		  </form>
		</div>
	</div>
</body>
</html>
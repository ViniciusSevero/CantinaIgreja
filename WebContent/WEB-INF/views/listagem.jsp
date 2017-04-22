<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/dataTables.bootstrap.min.css"/> ">
<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.dataTables.min.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/js/dataTables.bootstrap.min.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/js/custom.js"/> "></script>
</head>
<body>
<%@ include file="_navbar.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h1>Listagem de clientes</h1>
			
			<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th>Name</th>
		                <th>Telefones</th>
		                <th>Endereços</th>
		                <th>Opções</th>
		            </tr>
		        </thead>
		        <tbody>
		        	<c:forEach items="${lista}" var="cliente"> 
		        		<%@ include file="_table-row.jsp" %>
		        	</c:forEach>
		        </tbody>
		    </table>
		</div>
	</div>
</div>
</body>
</html>
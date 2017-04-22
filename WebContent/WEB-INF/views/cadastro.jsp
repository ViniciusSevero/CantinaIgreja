<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/js/cadastro.js"/> "></script>
</head>
<body>
<%@ include file="_navbar.jsp" %>
<div class="container">
		<h1>Cadastro de Clientes</h1>
		<br>
		
		<form action="<c:url value="/cliente/salvar"/>" method="post">
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="nome" class>Nome:</label>
						<input type="text" class="form-control" name="nome" id="nome">
					</div>
				</div>
			</div>
			
			<label>Telefones:</label>
			<div id="telefones">
				<div class="form-group" class="phone" data-seq="1">
					<div class="row">
						<div class="col-md-3">
							<input type="text" class="form-control" name="telefones[0].ddd" id="ddd" placeholder="DDD">
						</div>
						<div class="col-md-5">
							<input type="text" class="form-control" name="telefones[0].numero" id="numero" placeholder="Número">
						</div>
						<div class="col-md-3">
							<select name="telefones[0].tipo" class="form-control" >
								<c:forEach items="${vo.tiposTelefone}" var="tipo">
									<option>${tipo}</option>
								</c:forEach> 
							</select>
						</div>
						<div class="col-md-1">
							<button class="btn btn-danger excluir">Excluir</button>			
						</div>
					</div>
				</div>
				<div>
					<span class="btn btn-primary add">Adicionar</span>
				</div>
			</div>
			<br/>
			
			<label>Endereços:</label>
			<div id="enderecos">
				<div class="form-group" class="endereco" data-seq="1">
					<div class="row">
						<div class="col-md-12">
							<div class="row">
								<div class="col-md-2">
									<input type="text" class="form-control" name="enderecos[0].cep" id="cep" placeholder="CEP">
								</div>
								<div class="col-md-4">
									<input type="text" class="form-control" name="enderecos[0].logradouro" id="logradouro" placeholder="Logradouro">
								</div>
								<div class="col-md-2">
									<input type="text" class="form-control" name="enderecos[0].numero" id="numero" placeholder="Número">
								</div>
								<div class="col-md-4">
									<input type="text" class="form-control" name="enderecos[0].complemento" id="complemento" placeholder="Complemento">
								</div>
							</div>
						</div>
						<br><br>
						<div class="col-md-12">
							<div class="row">
								<div class="col-md-3">
									<input type="text" class="form-control" name="enderecos[0].bairro" id="bairro" placeholder="Bairro">
								</div>
								<div class="col-md-3">
									<input type="text" class="form-control" name="enderecos[0].cidade" id="cidade" placeholder="Cidade">
								</div>
								<div class="col-md-3">
									<input type="text" class="form-control" name="enderecos[0].estado" id="estado" placeholder="Estado">
								</div>
								<div class="col-md-2">
									<select name="enderecos[0].tipoEndereco" class="form-control" >
										<c:forEach items="${vo.tiposEndereco}" var="tipo">
											<option>${tipo}</option>
										</c:forEach> 
									</select>
								</div>
								<div class="col-md-1">
									<button class="btn btn-danger excluir">Excluir</button>			
								</div>
							</div>
						</div>
					</div>
				</div>
				<div>
					<span class="btn btn-primary add">Adicionar</span>
				</div>
			</div>
			<div align="center">
				<input type="submit" value="Salvar" class="btn btn-success">
			</div>
		</form>
</div>
</body>
</html>
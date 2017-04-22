<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/> ">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/custom.css"/> ">
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
		
			
			<div class="panel panel-default">
				<div class="panel-heading">Telefones 
					<span class="btn btn-primary btn-sm add-phone pull-right">Adicionar</span>
        			<div class="clearfix"></div>	
				</div>
				<div class="panel-body">
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
							</div>
						</div>
					</div>
				
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">Endereços
					<span class="btn btn-primary btn-sm add-endereco pull-right">Adicionar</span>
					<div class="clearfix"></div>	
				</div>
				<div class="panel-body">
					<div id="enderecos">
						<div class="form-group endereco well" data-seq="1">
							<div class="row">
								<div class="col-md-12" style="margin-bottom: 15px">
									<div class="row">
										<div class="col-md-2">
											<input type="text" class="form-control" name="enderecos[0].cep" id="cep" placeholder="CEP">
										</div>
										<div class="col-md-5">
											<input type="text" class="form-control" name="enderecos[0].logradouro" id="logradouro" placeholder="Logradouro">
										</div>
										<div class="col-md-1">
											<input type="text" class="form-control" name="enderecos[0].numero" id="numero" placeholder="N°">
										</div>
										<div class="col-md-4">
											<input type="text" class="form-control" name="enderecos[0].complemento" id="complemento" placeholder="Complemento">
										</div>
									</div>
								</div>
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
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div>
				<input type="submit" value="Salvar" class="btn btn-success">
				<input type="reset" value="Limpar" class="btn btn-default">
			</div>
	</form>
</div>
</body>
</html>
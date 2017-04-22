<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		<form action="<c:url value="/cliente/alterar"/>" method="post">
			<input type="hidden" name="id" value="${vo.cliente.id}">
		
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="nome" class>Nome:</label>
						<input type="text" class="form-control" name="nome" id="nome" value="${vo.cliente.nome}">
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
						<c:forEach items="${vo.cliente.telefones}" var="tel" varStatus="loop">
							<div class="form-group" class="phone" data-seq="1">
								<input type="hidden" name="telefones[${loop.index}].id" value="${tel.id}">
								<div class="row">
									<div class="col-md-3">
										<input type="text" class="form-control" name="telefones[${loop.index}].ddd" id="ddd" placeholder="DDD" value="${tel.ddd}">
									</div>
									<div class="col-md-5">
										<input type="text" class="form-control" name="telefones[${loop.index}].numero" id="numero" placeholder="Número" value="${tel.numero}">
									</div>
									<div class="col-md-3">
										<select name="telefones[${loop.index}].tipo" class="form-control" >
											<c:forEach items="${vo.tiposTelefone}" var="tipo">
												<option ${tipo == tel.tipo ? 'selected' : ''}>${tipo}</option>
											</c:forEach> 
										</select>
									</div>
									<div class="col-md-1">
				    		            <span class="btn btn-danger excluir">Excluir</span>
				    		       </div>
								</div>
							</div>
						</c:forEach>
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
						<c:forEach items="${vo.cliente.enderecos}" var="end" varStatus="loop">
							<div class="form-group endereco well" data-seq="1">
								<input type="hidden" name="enderecos[${loop.index}].id" value="${end.id}">
								<div class="row">
									<div class="col-md-12" style="margin-bottom: 15px">
										<div class="row">
											<div class="col-md-2">
												<input type="text" class="form-control" name="enderecos[${loop.index}].cep" id="cep" placeholder="CEP" value="${end.cep}">
											</div>
											<div class="col-md-5">
												<input type="text" class="form-control" name="enderecos[${loop.index}].logradouro" id="logradouro" placeholder="Logradouro" value="${end.logradouro}">
											</div>
											<div class="col-md-1">
												<input type="text" class="form-control" name="enderecos[${loop.index}].numero" id="numero" placeholder="N°" value="${end.numero}">
											</div>
											<div class="col-md-4">
												<input type="text" class="form-control" name="enderecos[0].complemento" id="complemento" placeholder="Complemento" value="${end.complemento}">
											</div>
										</div>
									</div>
									<div class="col-md-12">
										<div class="row">
											<div class="col-md-3">
												<input type="text" class="form-control" name="enderecos[${loop.index}].bairro" id="bairro" placeholder="Bairro" value="${end.bairro}">
											</div>
											<div class="col-md-3">
												<input type="text" class="form-control" name="enderecos[${loop.index}].cidade" id="cidade" placeholder="Cidade" value="${end.cidade}">
											</div>
											<div class="col-md-3">
												<input type="text" class="form-control" name="enderecos[${loop.index}].estado" id="estado" placeholder="Estado" value="${end.estado}">
											</div>
											<div class="col-md-2">
												<select name="enderecos[${loop.index}].tipoEndereco" class="form-control" >
													<c:forEach items="${vo.tiposEndereco}" var="tipo">
														<option ${tipo == end.tipoEndereco ? 'selected' : ''}>${tipo}</option>
													</c:forEach> 
												</select>
											</div>
											<div class="col-md-1">
						    		            <span class="btn btn-danger excluir">Excluir</span>
						    		       </div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
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
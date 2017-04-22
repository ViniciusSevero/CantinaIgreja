<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Cantina</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="<c:url value="/cliente/listagem"/>" >Listagem</a></li>
      <li><a href="<c:url value="/cliente/cadastro"/>" >Cadastro</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Olá ${sessionScope.usuarioLogado} <span class="caret"></span></a>
        <ul class="dropdown-menu">
        	<li><a  href="<c:url value="/logout"/>">Sair</a></li>
        </ul>
    </ul>
  </div>
</nav>
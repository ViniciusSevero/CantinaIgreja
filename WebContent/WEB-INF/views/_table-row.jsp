 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <tr>
     <td>${cliente.nome}</td>
     <td>
     	<c:forEach items="${cliente.telefones}" var="tel"> 
       		(${tel.ddd}) ${tel.numero} <b>${tel.tipo}</b> <br/>
       	</c:forEach>
     </td>
     <td>
     	<c:forEach items="${cliente.enderecos}" var="end"> 
       		${end.logradouro} ${end.numero}. ${end.bairro}, ${end.cidade} - ${end.estado} - CEP ${end.cep} <b>${end.tipoEndereco}</b> <br/>
       	</c:forEach>
     </td>
     <td align="center">
     	<a href="<c:url value="/cliente/${cliente.id}"/>" class="btn btn-primary">Visualizar</a>
     </td>
 </tr>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8" />
	<title>App - Java</title>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container fixed-top" >	

		<h4>Cadastramento de leitores:</h4>

		<form action="/leitor" method="get">
			<button type="submit">Novo leitor</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
			  <strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty leitorLista}">
		  	<p>Quantidade de leitores cadastrados: ${leitorLista.size()}</p>            
		  	<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>Nome</th>
			        <th>E-mail</th>
			        <th>CPF</th>
			        <th>Usuário</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:forEach var="l" items="${leitorLista}">
			      <tr>
			        <td>${l.nome}</td>
			        <td>${l.email}</td>
			        <td>${l.cpf}</td>
			        <td>${l.usuario.nome}</td>
			        <td><a href="/leitor/${l.id}/excluir">Excluir</a></td>
			      </tr>
				</c:forEach>
			    </tbody>
		  	</table>
		</c:if>
		
		<c:if test="${empty leitorLista}">
	  		<p>Não existem leitores cadastrados!!!</p>            
	  	</c:if>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>App.2022 - Java</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container fixed-top">

		<h4>Cadastramento de publicacoes:</h4>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty publicacaoLista}">
			<p>Quantidade de publicacaoes cadastradas:
				${publicacaoLista.size()}</p>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Titulo</th>
						<th>Valor</th>
						<th>Editora</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${publicacaoLista}">
						<tr>
							<td>${p.id}</td>
							<td>${p.titulo}</td>
							<td>${p.valor}</td>
							<td>${p.editora}</td>
							<td><a href="/publicacao/${p.id}/excluir">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty publicacaoLista}">
			<p>Não existem publicacoes cadastradas!!!</p>
		</c:if>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>App - Java</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container fixed-top">

		<h4>Cadastramento de revistas:</h4>

		<form action="/revista" method="get">
			<button type="submit">Nova Revista</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty revistaLista}">
			<p>Quantidade de revistas cadastradas: ${revistaLista.size()}</p>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Titulo</th>
						<th>Valor</th>
						<th>Editora</th>
						<th>Periodicidade</th>
						<th>Impressa</th>
						<th>Adulta</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="r" items="${revistaLista}">
						<tr>
							<td>${r.id}</td>
							<td>${r.titulo}</td>
							<td>${r.valor}</td>
							<td>${r.editora}</td>
							<td>${r.periodicidade}</td>
							<td>${r.impressa}</td>
							<td>${r.adulta}</td>
							<td><a href="/revista/${r.id}/excluir">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty revistaLista}">
			<p>Não existem revistas cadastradas!!!</p>
		</c:if>
	</div>
</body>
</html>
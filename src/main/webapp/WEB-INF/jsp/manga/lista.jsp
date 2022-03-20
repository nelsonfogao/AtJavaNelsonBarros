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

		<h4>Cadastramento de mangas:</h4>

		<form action="/manga" method="get">
			<button type="submit">Novo Manga</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty mangaLista}">
			<p>Quantidade de mangas cadastrados: ${mangaLista.size()}</p>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Titulo</th>
						<th>Valor</th>
						<th>Editora</th>
						<th>Volume</th>
						<th>Autor</th>
						<th>Categoria</th>
						<th>Adulto</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="m" items="${mangaLista}">
						<tr>
							<td>${m.id}</td>
							<td>${m.titulo}</td>
							<td>${m.valor}</td>
							<td>${m.editora}</td>
							<td>${m.volume}</td>
							<td>${m.autor}</td>
							<td>${m.categoria}</td>
							<td>${m.adulto}</td>
							<td><a href="/manga/${m.id}/excluir">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty mangaLista}">
			<p>Não existem mangas cadastrados!!!</p>
		</c:if>
	</div>
</body>
</html>
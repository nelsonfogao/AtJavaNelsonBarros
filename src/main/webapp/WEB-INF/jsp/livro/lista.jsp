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

		<h4>Cadastramento de livros:</h4>

		<form action="/livro" method="get">
			<button type="submit">Novo Livro</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty livroLista}">
			<p>Quantidade de livros cadastrados: ${livroLista.size()}</p>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Titulo</th>
						<th>Valor</th>
						<th>Editora</th>
						<th>ISBN</th>
						<th>Autor</th>
						<th>Edicao</th>
						<th>Categoria</th>
						<th>Importado</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="l" items="${livroLista}">
						<tr>
							<td>${l.id}</td>
							<td>${l.titulo}</td>
							<td>${l.valor}</td>
							<td>${l.editora}</td>
							<td>${l.ISBN}</td>
							<td>${l.autor}</td>
							<td>${l.edicao}</td>
							<td>${l.categoria}</td>
							<td>${l.importado}</td>
							<td><a href="/livro/${l.id}/excluir">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty livroLista}">
			<p>Não existem livros cadastrados!!!</p>
		</c:if>
	</div>
</body>
</html>
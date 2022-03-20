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

	<header class="masthead">
		<div class="container px-4 px-lg-5 h-100">
			<c:import url="/WEB-INF/jsp/menu.jsp" />
		</div>
	</header>

	<div class="container">

		<form action="/livro/incluir" method="post">
			<h2>Cadastramento de Livros</h2>

			<div class="form-group">
				<label>Titulo:</label> <input type="text" class="form-control"
					name="titulo" value="Harry Potter">
			</div>

			<div class="form-group">
				<label>Valor:</label> <input type="text" class="form-control"
					name="valor" value="50">
			</div>

			<div class="form-group">
				<label>Editora:</label> <input type="text" class="form-control"
					name="editora" value="Rocco">
			</div>

			<div class="form-group">
				<label>ISBN:</label> <input type="text" class="form-control"
					name="isbn" value="8532511015">
			</div>
			<div class="form-group">
				<label>Autor:</label> <input type="text" class="form-control"
					name="autor" value="J.K. Rowlling">
			</div>
			<div class="form-group">
				<label>Edicao:</label> <input type="text" class="form-control"
					name="edicao" value="1">
			</div>
			<div class="form-group">
				<label>Categoria:</label> <input type="text" class="form-control"
					name="categoria" value="infantil">
			</div>

			<div class="form-group">
				<label>Caracter�sticas:</label>

				<div class="checkbox">
					<label><input type="checkbox" name="importado" value="true"
						checked> Importado</label>
				</div>
			</div>

			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>
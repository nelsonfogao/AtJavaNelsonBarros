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

		<form action="/revista/incluir" method="post">
			<h2>Cadastramento de Revistas</h2>

			<div class="form-group">
				<label>Titulo:</label> <input type="text" class="form-control"
					name="titulo" value="Caras">
			</div>

			<div class="form-group">
				<label>Valor:</label> <input type="text" class="form-control"
					name="valor" value="10">
			</div>

			<div class="form-group">
				<label>Editora:</label> <input type="text" class="form-control"
					name="editora" value="Abril">
			</div>

			<div class="form-group">
				<label>Periodicidade:</label> <input type="text"
					class="form-control" name="periodicidade" value="15">
			</div>

			<div class="form-group">
				<label>Características:</label>

				<div class="checkbox">
					<label><input type="checkbox" name="impressa" value="true"
						checked> Impressa</label>
				</div>
				<div class="checkbox">
					<label><input type="checkbox" name="adulta" value="true"
						checked> Adulta</label>
				</div>

			</div>

			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>
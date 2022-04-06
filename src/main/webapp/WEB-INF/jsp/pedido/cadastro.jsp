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

	<c:set var="statusBotao" value=""/>

	<header class="masthead">
    <div class="container px-4 px-lg-5 h-100">
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	</div>
	</header>

	<div class="container">
	
		<form action="/pedido/incluir" method="post">
			<h2>Cadastramento de Pedidos</h2>
		
			<div class="form-group">
				<label>Descrição:</label>
				<input type="text" class="form-control" name="descricao" value="Pedido n 1"> 
			</div>

			<div class="form-group">
				<c:if test="${not empty leitorLista}">
					<label>Leitor:</label>
					<select name="leitor.id" class="form-control">
						<c:forEach var="l" items="${leitorLista}">
							<option value="${l.id}">${l.nome}</option>
						</c:forEach>
					</select>
				</c:if>
				
				
				<c:if test="${empty leitorLista}">
					<label>Nenhum leitor cadastrado!!!</label>
					<c:set var="statusBotao" value="disabled"/>
				</c:if>				
			</div>

			<div class="form-group">
				<c:if test="${not empty publicacaoLista}">
					<label>Publicações:</label>
					
					<c:forEach var="p" items="${publicacaoLista}">
						<div class="checkbox">
						  <label><input type="checkbox" name="idsPublicacoes" value="${p.id}" checked> ${p.titulo}</label>
						</div>
					</c:forEach>	
				</c:if>
				
				<c:if test="${empty publicacaoLista}">
					<label>Nenhuma publicação cadastrada!!!</label>
					<c:set var="statusBotao" value="disabled"/>
				</c:if>				
			</div>

			<button ${statusBotao} type="submit">Cadastrar</button>
		</form>		
	</div>
</body>
</html>
<!--  
Nome do autor: Elian Melo Morais 
Data de criação do arquivo: 10/04/2019 
Objetivo sucinto do programa: Formul�rio HTML de pesquisa
Referencia ao enunciado/origem do exercicio: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
-->

<!-- Corresponde a uma p�gina completa padr�o/modelo -->
<%@ page language="java" contentType="text/html; charsert=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Sistema de Filmes</title>
	<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css" rel="stylesheet">
</head>

<body>

	<jsp:include page="/resources/templates/navbar.jsp"/>

	<!-- Conte�do da p�gina -->
	<div class="container">
		<div class="page-header">
			<h1>Filmes encontrados</h1>
		</div>

		<!-- Adiciona uma tabela -->
		<table class="table">
			<thead>
				<tr>
					<th>C�digo</th>
					<th>T�tulo</th>
					<th>A��o</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codFilme}</td>
						<td>${x.titulo}</td>
						<td><a href="<%=request.getContextPath()%>/filme/detalhes?cod=${x.codFilme}" 
						class="btn btn-primary btn-xs">Detalhes</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<jsp:include page="/resources/templates/rodape.jsp"/>

	<!-- Core JS (Corresponde ao n�cleo de processamento do JavaScript)-->
	<!-- Conta com as bibliotecas do bootstrap e do jquery -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
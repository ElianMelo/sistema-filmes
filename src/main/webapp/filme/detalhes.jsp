<!--  
Nome do autor: Elian Melo Morais 
Data de criação do arquivo: 30/04/2019 
Objetivo sucinto do programa: P�gina HTML de detalhes
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
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">
</head>

<body>

	<jsp:include page="/resources/templates/navbar.jsp" />

	<!-- Conte�do da p�gina -->
	<div class="container">
		<div class="page-header">
			<h1>Detalhes do filme</h1>
		</div>
		
		<div>
			<ul class="list-group">
				<li class="list-group-item">C�digo: ${item.codFilme}</li>
				<li class="list-group-item">T�tulo: ${item.titulo}</li>
				<li class="list-group-item">Dura��o: ${item.duracao}</li>
				<li class="list-group-item">Ano: ${item.ano}</li>
				<li class="list-group-item">Gasto total em cache: <fmt:setLocale value="pt_BR" />
					<fmt:formatNumber type="currency" value="${item.cacheTotal}" /></li>
			</ul>
		</div>

		<div>
			<a href="<%=request.getContextPath()%>/filme/pesquisar" class="btn btn-success">Nova Pesquisa</a>
		</div>
		
	</div>

	<jsp:include page="/resources/templates/rodape.jsp" />

	<!-- Core JS (Corresponde ao n�cleo de processamento do JavaScript)-->
	<!-- Conta com as bibliotecas do bootstrap e do jquery -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
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
			<h1>Pesquisar Filmes</h1>
		</div>

		<form method="get" name="myform" class="form-horizontal" 
			action="<%=request.getContextPath()%>/filme/resultado">
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="titulo">T�tulo:</label>
				<div class="col-sm-5">
					<input type="text" name="titulo" id="titulo" class="form-control"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="anoMin">Ano M�nimo:</label>
				<div class="col-sm-5">
					<input type="number" name="anoMin" id="anoMin" required="required" class="form-control"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="anoMax">Ano M�ximo:</label>
				<div class="col-sm-5">
					<input type="number" name="anoMax" id="anoMax" required="required" class="form-control"/>
				</div>
			</div>
			
			 
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Pesquisar</button>
					<a href="<%=request.getContextPath()%>" class="btn btn-default">Voltar</a>
				</div>
			</div>
			
		</form>

	</div>

	<jsp:include page="/resources/templates/rodape.jsp"/>

	<!-- Core JS (Corresponde ao n�cleo de processamento do JavaScript)-->
	<!-- Conta com as bibliotecas do bootstrap e do jquery -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
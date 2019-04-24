<!--  
Nome do autor: Elian Melo Morais 
Data de criação do arquivo: 10/04/2019 
Objetivo sucinto do programa: Template do menu de navega��o
Referencia ao enunciado/origem do exercicio: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
-->

<!-- Corresponde a barra de navega��o de nossa aplica��o -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=request.getContextPath()%>/">Sistema
				de Filmes</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="<%=request.getContextPath()%>/artista/listar">Cadastro
						de Artistas</a></li>
				<li><a href="<%=request.getContextPath()%>/filmes/pesquisar">Pesquisar
						Filmes</a></li>
				<li><a href="<%=request.getContextPath()%>/participacao/filmes">Inserir
						Participa��o</a></li>
			</ul>
		</div>
	</div>
</nav>
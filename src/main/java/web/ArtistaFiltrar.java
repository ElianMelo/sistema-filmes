/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 25/04/2019
Resumo: Servlet que filtra os Artistas
Refer�ncia ao enunciado/origem do exerc�cio: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
*/

package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Artista;
import servico.ArtistaServico;

@WebServlet("/artista/filtrar")
public class ArtistaFiltrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/artista/listar.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Cria um Service de Artista
		ArtistaServico as = new ArtistaServico();
		
		// Cria uma string que recebe o par�metro "busca" informado pelo cliente
		String nome = request.getParameter("busca");
		
		// Busca o artista
		List<Artista> itens = as.buscarPorNome(nome);
		
		// Envia dados para o JSP
		request.setAttribute("itens", itens);
		
		// Vamos encaminhar para o destino, passando o request e o response
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}

}

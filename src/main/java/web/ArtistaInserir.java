/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 10/04/2019
Objetivo sucinto do programa: Servlet que persiste e insere Artistas
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
import servico.ServicoException;

@WebServlet("/artista/inserir")
public class ArtistaInserir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/artista/listar.jsp";
	private static String ERRO = "/publico/erro.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Cria um Service de Artista
		ArtistaServico as = new ArtistaServico();
		
		Artista x = Instanciar.artista(request);
		
		try {
			// Tenta persistir o Artista x no banco de dados
			as.inserir(x);
			
			// Busca o artista
			List<Artista> itens = as.buscarTodosOrdenadosPorNome();
			
			// Envia dados para o JSP
			request.setAttribute("itens", itens);
			
			// Vamos encaminhar para o destino, passando o request e o response
			request.getRequestDispatcher(DESTINO).forward(request, response);
		} catch (ServicoException e) {
			// Envia para o JSP a mensagem de erro gerada pelo servidor
			request.setAttribute("msg", e.getMessage());
			
			// Vamos encaminhar para a pagina de erro, passando o request e o response
			request.getRequestDispatcher(ERRO).forward(request, response);
		}

	}

}

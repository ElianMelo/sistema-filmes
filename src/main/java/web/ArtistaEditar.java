/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 30/04/2019
Resumo: Servlet que envia os dados para um formul�rio
Refer�ncia ao enunciado/origem do exerc�cio: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
*/

package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Artista;
import servico.ArtistaServico;

@WebServlet("/artista/editar")
public class ArtistaEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String DESTINO = "/artista/formEditar.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Pega o c�digo do bot�o alterar e busca no banco e instancia em um Artista
		ArtistaServico as = new ArtistaServico();
		int cod = Integer.parseInt(request.getParameter("cod"));
		Artista art = as.buscar(cod);
		
		// Envia dados para o JSP
		request.setAttribute("item", art);
		
		// Vamos encaminhar para o destino, passando o request e o response
		request.getRequestDispatcher(DESTINO).forward(request, response);
	}

}

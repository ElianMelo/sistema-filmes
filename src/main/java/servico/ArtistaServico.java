/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 10/04/2019
Objetivo sucinto do programa: Service que invoca o DAO(Data Access Object) de Artista
Refer�ncia ao enunciado/origem do exerc�cio: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
*/

package servico;

import java.util.List;

import dao.ArtistaDao;
import dao.DaoFactory;
import dao.Transaction;
import dominio.Artista;

public class ArtistaServico {
	
	private ArtistaDao dao;
	
	public ArtistaServico() {
		dao = DaoFactory.criarArtistaDao();
	}

	public void inserir(Artista x) throws ServicoException {
		try {
			Artista aux = dao.buscaNomeExato(x.getNome());
			if(aux != null) {
				throw new ServicoException("J� existe um artista com esse nome!", 1);
			}
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if(Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void atualizar(Artista x) throws ServicoException {
		try {
			Artista aux = dao.buscaNomeExatoDiferente(x.getCodAtor(), x.getNome());
			if(aux != null) {
				throw new ServicoException("J� existe um artista com esse nome!", 1);
			}
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if(Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void excluir(Artista x) throws ServicoException {
		try {
			x = dao.buscar(x.getCodAtor());
			if(!x.getParticipacoes().isEmpty()) {
				throw new ServicoException("Exclus�o n�o permitida: este artista possui participa��es!", 2);
			}
			
			Transaction.begin();
			dao.excluir(x);
			Transaction.commit();
		} catch (RuntimeException e) {
			if(Transaction.isActive()) {
				Transaction.rollback();
			}
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public Artista buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Artista> buscarTodos(){
		return dao.buscarTodos();
	}
	
	public List<Artista> buscarTodosOrdenadosPorNome(){
		return dao.buscarTodosOrdenadosPorNome();
	}
	
	public List<Artista> buscarPorNome(String trecho){
		return dao.buscarPorNome(trecho);
	}
}

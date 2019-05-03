/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 12/04/2019
Resumo: Service que invoca o DAO(Data Access Object) de Filme
Refer�ncia ao enunciado/origem do exerc�cio: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
*/

package servico;

import java.util.List;

import dao.DaoFactory;
import dao.FilmeDao;
import dao.Transaction;
import dominio.Filme;

public class FilmeServico {
	
	private FilmeDao dao;
	
	public FilmeServico() {
		dao = DaoFactory.criarFilmeDao();
	}
	
	public void inserirAtualizar(Filme x) {
		try {
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
	
	public void excluir(Filme x) {
		try {
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
	
	public Filme buscar(int cod) {
		return dao.buscar(cod);
	}
	
	public List<Filme> buscarTodos(){
		return dao.buscarTodos();
	}
	
	public List<Filme> buscarPorNomeAno(String nome, int anoMin, int anoMax){
		return dao.buscarPorNomeAno(nome, anoMin, anoMax);
	}
}

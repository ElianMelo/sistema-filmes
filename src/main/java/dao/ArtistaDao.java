/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 12/04/2019
Resumo: Interface DAO(Data Access Object) que mostra os m�todos obrigat�rios em rela��o a classe Artista
Refer�ncia ao enunciado/origem do exerc�cio: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
*/

package dao;

import java.util.List;

import dominio.Artista;

public interface ArtistaDao {
	public void inserirAtualizar(Artista x);
	public void excluir(Artista x);
	public Artista buscar(int cod);
	public List<Artista> buscarTodos();
	
	public List<Artista> buscarTodosOrdenadosPorNome();
	public Artista buscaNomeExato(String nome);
	public Artista buscaNomeExatoDiferente(Integer codigo, String nome);
	public List<Artista> buscarPorNome(String trecho);
}

/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 12/04/2019
Resumo: Interface DAO(Data Access Object) que mostra os m�todos obrigat�rios em rela��o a classe Participacao
Refer�ncia ao enunciado/origem do exerc�cio: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
*/

package dao;

import java.util.List;

import dominio.Artista;
import dominio.Filme;
import dominio.Participacao;

public interface ParticipacaoDao {
	public void inserirAtualizar(Participacao x);
	public void excluir(Participacao x);
	public Participacao buscar(int cod);
	public List<Participacao> buscarTodos();
	
	public Participacao buscarExato(String personagem, Artista artista, Filme filme);
	public Participacao buscarExatoDiferente(Integer codigo, String personagem, Artista artista, Filme filme);
	
}

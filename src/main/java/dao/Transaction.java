/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 12/04/2019
Resumo: Interface DAO(Data Access Object) que mostra os m�todos obrigat�rios em rela��o as opera��es de transa��o
Refer�ncia ao enunciado/origem do exerc�cio: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
*/

package dao;

import dao.impl.EM;

public class Transaction {

	public static void begin() {
		EM.getLocalEm().getTransaction().begin();
	}
	
	public static void commit() {
		EM.getLocalEm().getTransaction().commit();
	}
	
	public static void rollback() {
		EM.getLocalEm().getTransaction().rollback();
	}
	
	public static boolean isActive() {
		return EM.getLocalEm().getTransaction().isActive();
	}
}

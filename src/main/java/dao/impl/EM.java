/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 12/04/2019
Resumo: Classe de Implementa��o do Entity Manager (Acesso ao banco de dados)
Refer�ncia ao enunciado/origem do exerc�cio: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
*/

package dao.impl;

import javax.persistence.EntityManager;

public class EM {
	private static ThreadLocal<EntityManager> localEm = new ThreadLocal<EntityManager>();
	
	public static synchronized EntityManager getLocalEm() {
		EntityManager em = localEm.get();
		if(em == null) {
			em = EMF.get().createEntityManager();
			localEm.set(em);
		}
		return em;
	}
	
	public static void closeLocalEm() {
		EntityManager em = localEm.get();
		if(em != null) {
			localEm.get().close();
			localEm.set(null);
		}
	}
}

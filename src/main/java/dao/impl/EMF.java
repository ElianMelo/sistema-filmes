/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 12/04/2019
Resumo: Classe de Implementa��o do Entity Manager Factory (criador de Entity Manager)
Refer�ncia ao enunciado/origem do exerc�cio: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
*/

package dao.impl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private static EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("meujpa");
	
	public static EntityManagerFactory get() {
		return emf;
	}
}

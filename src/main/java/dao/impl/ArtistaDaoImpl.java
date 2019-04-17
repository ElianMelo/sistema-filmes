package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ArtistaDao;
import dominio.Artista;

public class ArtistaDaoImpl implements ArtistaDao {

	private EntityManager em;
	
	public ArtistaDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Artista x) {
		if(x.getCodAtor() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Artista x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Artista buscar(int cod) {
		return em.find(Artista.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> buscarTodos() {
		String jpql = "SELECT x FROM Artista x";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> buscarTodosOrdenadosPorNome() {
		String jpql = "SELECT x FROM Artista x ORDER BY x.nome";
		Query query = em.createNamedQuery(jpql);
		return query.getResultList();
	}

}

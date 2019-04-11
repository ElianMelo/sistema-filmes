/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 10/04/2019
Objetivo sucinto do programa: Simular um artista que participa de um filme
Refer�ncia ao enunciado/origem do exerc�cio: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
*/
package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_artista")
public class Artista implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codAtor;
	private String nome;
	private String nacionalidade;
	private BigDecimal cache;
	private Date nascimento;
	
	@OneToMany(mappedBy="artista")
	private List<Participacao> participacoes = new ArrayList<>();
	
	public Artista() {
		super();
	}

	public Artista(Integer codAtor, String nome, String nacionalidade, BigDecimal cache, Date nascimento) {
		super();
		this.codAtor = codAtor;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.cache = cache;
		this.nascimento = nascimento;
	}

	public Integer getCodAtor() {
		return codAtor;
	}

	public void setCodAtor(Integer codAtor) {
		this.codAtor = codAtor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public BigDecimal getCache() {
		return cache;
	}

	public void setCache(BigDecimal cache) {
		this.cache = cache;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public List<Participacao> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}
	
	public void addParticipacao(Participacao x) {
		this.participacoes.add(x);
		x.setArtista(this);
	}
	
	public void removeParticipacao(Participacao x) {
		this.participacoes.remove(x);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAtor == null) ? 0 : codAtor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		if (codAtor == null) {
			if (other.codAtor != null)
				return false;
		} else if (!codAtor.equals(other.codAtor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artista [codAtor=" + codAtor + ", nome=" + nome + ", nacionalidade=" + nacionalidade + ", cache="
				+ cache + ", nascimento=" + nascimento + "]";
	}
}

package br.com.postogasolina.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

/**
 * Classe representa a entidade Posto de gasolina.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Entity
public class Posto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo NOME é requerido.")
	@Length(min = 2, max = 30, message = "O campo NOME deve ter entre 2 e 30 caracteres")
	private String nome;
	
	@OneToMany(mappedBy = "posto")
	private List<Bomba> bombas;
	
	/**
	 * Construtor padrão.
	 */
	public Posto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Construtora parametrizado.
	 * 
	 * @param id - Long
	 * @param nome - String
	 * @param bombas - List<Bomba>
	 */
	public Posto(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the bombas
	 */
	public List<Bomba> getBombas() {
		return bombas;
	}
	/**
	 * @param bombas the bombas to set
	 */
	public void setBombas(List<Bomba> bombas) {
		this.bombas = bombas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Posto other = (Posto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

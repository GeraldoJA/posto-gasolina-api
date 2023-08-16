package br.com.postogasolina.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe representa a entidade Combustível.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Entity
public class Combustivel {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private TipoCombustivel tipoCombustivel;
	
	/**
	 * Construtor padrão.
	 */
	public Combustivel() {
		super();
		// Auto-generated constructor stub
	}
	
	/**
	 * Construtor parametrizado.
	 * 
	 * @param id
	 * @param tipoCombustivel
	 */
	public Combustivel(Long id, TipoCombustivel tipoCombustivel) {
		super();
		this.id = id;
		this.tipoCombustivel = tipoCombustivel;
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
	 * @return the tipoCombustivel
	 */
	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	/**
	 * @param tipoCombustivel the tipoCombustivel to set
	 */
	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoCombustivel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combustivel other = (Combustivel) obj;
		return tipoCombustivel == other.tipoCombustivel;
	}

	@Override
	public String toString() {
		return tipoCombustivel.name();
	}

	  
}

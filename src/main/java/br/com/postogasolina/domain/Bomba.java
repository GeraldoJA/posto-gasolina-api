package br.com.postogasolina.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe representa a entidade Bomba de Combustível.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Entity
public class Bomba implements Serializable {



	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double preco;

	private Integer velocidadeAbastecimento;   
	
	@ManyToOne
	@JoinColumn(name = "combustivel_id")
	private Combustivel combustivel;
	
	@ManyToOne
	@JoinColumn(name = "posto_id")
	private Posto posto;
		
	/**
	 * Construtor padrão.
	 */
	public Bomba() {
		super();
	}

	/**
	 * Construtora parametrizado.
	 * 
	 * @param id
	 * @param preco
	 * @param velocidadeAbastecimento
	 * @param combustivel
	 * @param posto
	 */
	public Bomba(Long id, Double preco, Integer velocidadeAbastecimento, Combustivel combustivel, Posto posto) {
		super();
		this.id = id;
		this.preco = preco;
		this.velocidadeAbastecimento = velocidadeAbastecimento;
		this.combustivel = combustivel;
		this.posto = posto;
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
	 * @return the preco
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	
	/**
	 * @return the velocidadeAbastecimento
	 */
	public Integer getVelocidadeAbastecimento() {
		return velocidadeAbastecimento;
	}

	/**
	 * @param velocidadeAbastecimento the velocidadeAbastecimento to set
	 */
	public void setVelocidadeAbastecimento(Integer velocidadeAbastecimento) {
		this.velocidadeAbastecimento = velocidadeAbastecimento;
	}
	
	/**
	 * @return the combustivel
	 */
	public Combustivel getCombustivel() {
		return combustivel;
	}

	/**
	 * @param combustivel the combustivel to set
	 */
	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	/**
	 * @return the posto
	 */
	public Posto getPosto() {
		return posto;
	}
	
	/**
	 * @param posto the posto to set
	 */
	public void setPosto(Posto posto) {
		this.posto = posto;
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
		Bomba other = (Bomba) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "B"+ id + " " + combustivel.getTipoCombustivel().name().toLowerCase() + " - preco: R$ " + preco;
	}


}

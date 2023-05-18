package br.com.postogasolina.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

/**
 * Classe representa a entidade Veículo.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Entity
public class Veiculo implements Serializable {
	


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo MODELO é requerido.")
	@Length(min = 2, max = 30, message = "O campo MODELO deve ter entre 2 e 30 caracteres")
	private String modelo;
	
	@NotEmpty(message = "Campo NOME é requerido.")
	@Length(min = 1, max = 30, message = "O campo NOME deve ter entre 1 e 30 caracteres")
	private String nome;
	
	@NotEmpty(message = "Campo PLACA é requerido.")
	@Length(min = 1, max = 20, message = "O campo PLACA deve ter entre 1 e 20 caracteres")
	private String placa;
	
	private Integer capacidadeTanque;
	
	/**
	 * Construtor padrão.
	 */
	public Veiculo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Construtora parametrizado.
	 * 
	 * @param id - lONG
	 * @param modelo - String
	 * @param nome - String
	 * @param placa - String
	 * @param capacidadeTanque - Integer
	 */
	public Veiculo(Long id, String modelo, String nome, String placa, Integer capacidadeTanque) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.nome = nome;
		this.placa = placa;
		this.capacidadeTanque = capacidadeTanque;
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
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the capacidadeTanque
	 */
	public Integer getCapacidadeTanque() {
		return capacidadeTanque;
	}

	/**
	 * @param capacidadeTanque the capacidadeTanque to set
	 */
	public void setCapacidadeTanque(Integer capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
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
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}





}

package br.com.postogasolina.domain;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe representa a entidade Abastecimento.
 * 
 * @author Geraldo jorge - candidato5
 * 		   email: geraldo.gja@gmail.com
 */
@Entity
public class Abastecimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date date;
	
	private Double quantidadeLitros;
	
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "veiculo_id")
	private Veiculo veiculo;
	
	@ManyToOne
	@JoinColumn(name = "bomba_id")
	private Bomba bomba;

	public Abastecimento() {
		super();
		// Auto-generated constructor stub
	}
	
	public Abastecimento(Long id, Date date, Double quantidadeLitros, Double valor, Veiculo veiculo, Bomba bomba) {
		super();
		this.id = id;
		this.date = date;
		this.quantidadeLitros = quantidadeLitros;
		this.valor = valor;
		this.veiculo = veiculo;
		this.bomba = bomba;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the quantidadeLitros
	 */
	public Double getQuantidadeLitros() {
		return quantidadeLitros;
	}

	/**
	 * @param quantidadeLitros the quantidadeLitros to set
	 */
	public void setQuantidadeLitros(Double quantidadeLitros) {
		this.quantidadeLitros = quantidadeLitros;
	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @return the veiculo
	 */
	public Veiculo getVeiculo() {
		return veiculo;
	}

	/**
	 * @param veiculo the veiculo to set
	 */
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	/**
	 * @return the bomba
	 */
	public Bomba getBomba() {
		return bomba;
	}

	/**
	 * @param bomba the bomba to set
	 */
	public void setBomba(Bomba bomba) {
		this.bomba = bomba;
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
		Abastecimento other = (Abastecimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}

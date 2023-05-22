package br.com.postogasolina.dto;

import java.util.Objects;

public class AbastecimentoDTO {

	private String data;
	
	private String infoCarro;
	
	private String placa;
	
	private String descricao;
	
	private Double qtdGasolina;
	
	private Double qtdAlcool;
	
	private Double valorGasto;

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @return the infoCarro
	 */
	public String getInfoCarro() {
		return infoCarro;
	}

	/**
	 * @return the qtdGasolina
	 */
	public Double getQtdGasolina() {
		return qtdGasolina;
	}

	/**
	 * @return the qtdAlcool
	 */
	public Double getQtdAlcool() {
		return qtdAlcool;
	}

	/**
	 * @return the valorGasto
	 */
	public Double getValorGasto() {
		return valorGasto;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @param infoCarro the infoCarro to set
	 */
	public void setInfoCarro(String infoCarro) {
		this.infoCarro = infoCarro;
	}

	/**
	 * @param qtdGasolina the qtdGasolina to set
	 */
	public void setQtdGasolina(Double qtdGasolina) {
		this.qtdGasolina = qtdGasolina;
	}

	/**
	 * @param qtdAlcool the qtdAlcool to set
	 */
	public void setQtdAlcool(Double qtdAlcool) {
		this.qtdAlcool = qtdAlcool;
	}

	/**
	 * @param valorGasto the valorGasto to set
	 */
	public void setValorGasto(Double valorGasto) {
		this.valorGasto = valorGasto;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	@Override
	public int hashCode() {
		return Objects.hash(placa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbastecimentoDTO other = (AbastecimentoDTO) obj;
		return Objects.equals(placa, other.placa);
	}

	
}

package br.com.projetoa.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author MARCIO GALVAO
 * @since 2018
 *
 */
@XmlRootElement
public class DisponibilizarMedicamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fb_id = "";
	private int fk_medicamento;
	private int qtd_disponivel;
	private double nr_valor_unit;
	private String data_validade = "";
	private int tipo_medicamento;
	private double latitude;
	private double longitude;
	private String text_observacao = "";
	
	public String getText_observacao() {
		return text_observacao;
	}

	public void setText_observacao(String text_observacao) {
		this.text_observacao = text_observacao;
	}

	/**
	 * 
	 * @param fk_usuario int
	 * @param fk_medicamento int
	 * @param qtd_disponivel int
	 * @param nr_valor_unit double
	 * @param data_validade String
	 * @param tipo_medicamento int
	 */
	public DisponibilizarMedicamento(
			 String fb_id,
			 int fk_medicamento,
			 int qtd_disponivel,
			 double nr_valor_unit,
			 String data_validade,
			 int tipo_medicamento,
			 double latitude,
			 double longitude
			) {
		 this.fb_id = fb_id;
		 this.fk_medicamento = fk_medicamento;
		 this.qtd_disponivel = qtd_disponivel;
		 this.nr_valor_unit = nr_valor_unit;
		 this.data_validade = data_validade;
		 this.tipo_medicamento = tipo_medicamento;
		 this.latitude = latitude;
		 this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public DisponibilizarMedicamento() {}



	public String getFb_id() {
		return fb_id;
	}

	public void setFb_id(String fb_id) {
		this.fb_id = fb_id;
	}

	public int getFk_medicamento() {
		return fk_medicamento;
	}

	public void setFk_medicamento(int fk_medicamento) {
		this.fk_medicamento = fk_medicamento;
	}

	public int getQtd_disponivel() {
		return qtd_disponivel;
	}

	public void setQtd_disponivel(int qtd_disponivel) {
		this.qtd_disponivel = qtd_disponivel;
	}

	public double getNr_valor_unit() {
		return nr_valor_unit;
	}

	public void setNr_valor_unit(double nr_valor_unit) {
		this.nr_valor_unit = nr_valor_unit;
	}

	public String getData_validade() {
		return data_validade;
	}

	public void setData_validade(String data_validade) {
		this.data_validade = data_validade;
	}

	public int getTipo_medicamento() {
		return tipo_medicamento;
	}

	public void setTipo_medicamento(int tipo_medicamento) {
		this.tipo_medicamento = tipo_medicamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_validade == null) ? 0 : data_validade.hashCode());
		result = prime * result + ((fb_id == null) ? 0 : fb_id.hashCode());
		result = prime * result + fk_medicamento;
		long temp;
		temp = Double.doubleToLongBits(nr_valor_unit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + qtd_disponivel;
		result = prime * result + tipo_medicamento;
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
		DisponibilizarMedicamento other = (DisponibilizarMedicamento) obj;
		if (data_validade == null) {
			if (other.data_validade != null)
				return false;
		} else if (!data_validade.equals(other.data_validade))
			return false;
		if (fb_id == null) {
			if (other.fb_id != null)
				return false;
		} else if (!fb_id.equals(other.fb_id))
			return false;
		if (fk_medicamento != other.fk_medicamento)
			return false;
		if (Double.doubleToLongBits(nr_valor_unit) != Double.doubleToLongBits(other.nr_valor_unit))
			return false;
		if (qtd_disponivel != other.qtd_disponivel)
			return false;
		if (tipo_medicamento != other.tipo_medicamento)
			return false;
		return true;
	}
	
	
	
	
	

}

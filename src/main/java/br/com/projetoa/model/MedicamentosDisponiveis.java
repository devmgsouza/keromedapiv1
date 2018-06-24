package br.com.projetoa.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Marcio Galvão
 * @Since 2018
 * @version 1.0.1
 */
@XmlRootElement
public class MedicamentosDisponiveis {
	private int pk_mmd;
	private String text_nome_comercial = "";
	private String text_apresentacao = "";
	private String nr_ean = "";
	private double latitude;
	private double longitude;
	private String data_validade = "";
	private int qtd_disponivel;
	private String tipo_medicamento = "";
	private String text_principio_ativo = "";
	private String text_laboratorio = "";
	private double distancia;
	
	public String getText_principio_ativo() {
		return text_principio_ativo;
	}

	public void setText_principio_ativo(String text_principio_ativo) {
		this.text_principio_ativo = text_principio_ativo;
	}

	public String getText_laboratorio() {
		return text_laboratorio;
	}

	public void setText_laboratorio(String text_laboratorio) {
		this.text_laboratorio = text_laboratorio;
	}

	/**
	 * 
	 * @param pk_mmd int
	 * @param text_nome_comercial String
	 * @param text_apresentacao String
	 * @param nr_ean String
	 * @param latitude double
	 * @param longitude double
	 * @param data_validade String
	 * @param qtd_disponivel int
	 * @param tipo_medicamento String
	 * @param text_principio_ativo String
	 * @param text_laboratorio
	 */
	public MedicamentosDisponiveis(
			 int pk_mmd,
			 String text_nome_comercial,
			 String text_apresentacao,
			 String nr_ean,
			 double latitude,
			 double longitude,
			 String data_validade,
			 int qtd_disponivel,
			 String tipo_medicamento,
			 String text_principio_ativo,
			 String text_laboratorio,
			 double distancia
			) {
		 this.pk_mmd = pk_mmd;
		 this.text_nome_comercial = text_nome_comercial;
		 this.text_apresentacao = text_apresentacao;
		 this.nr_ean = nr_ean;
		 this.latitude = latitude;
		 this.longitude = longitude;
		 this.data_validade = data_validade;
		 this.qtd_disponivel = qtd_disponivel;
		 this.tipo_medicamento = tipo_medicamento;
		 this.text_principio_ativo = text_principio_ativo;
		 this.text_laboratorio = text_laboratorio;
		 this.distancia = distancia;
	}
	
	public MedicamentosDisponiveis() {}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public int getPk_mmd() {
		return pk_mmd;
	}

	public void setPk_mmd(int pk_mmd) {
		this.pk_mmd = pk_mmd;
	}

	public String getText_nome_comercial() {
		return text_nome_comercial;
	}

	public void setText_nome_comercial(String text_nome_comercial) {
		this.text_nome_comercial = text_nome_comercial;
	}

	public String getText_apresentacao() {
		return text_apresentacao;
	}

	public void setText_apresentacao(String text_apresentacao) {
		this.text_apresentacao = text_apresentacao;
	}

	public String getNr_ean() {
		return nr_ean;
	}

	public void setNr_ean(String nr_ean) {
		this.nr_ean = nr_ean;
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

	public String getData_validade() {
		return data_validade;
	}

	public void setData_validade(String data_validade) {
		this.data_validade = data_validade;
	}

	public int getQtd_disponivel() {
		return qtd_disponivel;
	}

	public void setQtd_disponivel(int qtd_disponivel) {
		this.qtd_disponivel = qtd_disponivel;
	}

	public String getTipo_medicamento() {
		return tipo_medicamento;
	}

	public void setTipo_medicamento(String tipo_medicamento) {
		this.tipo_medicamento = tipo_medicamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_validade == null) ? 0 : data_validade.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nr_ean == null) ? 0 : nr_ean.hashCode());
		result = prime * result + pk_mmd;
		result = prime * result + qtd_disponivel;
		result = prime * result + ((text_apresentacao == null) ? 0 : text_apresentacao.hashCode());
		result = prime * result + ((text_laboratorio == null) ? 0 : text_laboratorio.hashCode());
		result = prime * result + ((text_nome_comercial == null) ? 0 : text_nome_comercial.hashCode());
		result = prime * result + ((text_principio_ativo == null) ? 0 : text_principio_ativo.hashCode());
		result = prime * result + ((tipo_medicamento == null) ? 0 : tipo_medicamento.hashCode());
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
		MedicamentosDisponiveis other = (MedicamentosDisponiveis) obj;
		if (data_validade == null) {
			if (other.data_validade != null)
				return false;
		} else if (!data_validade.equals(other.data_validade))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (nr_ean == null) {
			if (other.nr_ean != null)
				return false;
		} else if (!nr_ean.equals(other.nr_ean))
			return false;
		if (pk_mmd != other.pk_mmd)
			return false;
		if (qtd_disponivel != other.qtd_disponivel)
			return false;
		if (text_apresentacao == null) {
			if (other.text_apresentacao != null)
				return false;
		} else if (!text_apresentacao.equals(other.text_apresentacao))
			return false;
		if (text_laboratorio == null) {
			if (other.text_laboratorio != null)
				return false;
		} else if (!text_laboratorio.equals(other.text_laboratorio))
			return false;
		if (text_nome_comercial == null) {
			if (other.text_nome_comercial != null)
				return false;
		} else if (!text_nome_comercial.equals(other.text_nome_comercial))
			return false;
		if (text_principio_ativo == null) {
			if (other.text_principio_ativo != null)
				return false;
		} else if (!text_principio_ativo.equals(other.text_principio_ativo))
			return false;
		if (tipo_medicamento == null) {
			if (other.tipo_medicamento != null)
				return false;
		} else if (!tipo_medicamento.equals(other.tipo_medicamento))
			return false;
		return true;
	}
	
	
	
}

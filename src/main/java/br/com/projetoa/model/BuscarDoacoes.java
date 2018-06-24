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
public class BuscarDoacoes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fb_id;
	private int parametro;
	private int tipo;
	private int pk_mmd;
	private String codigo_validador = "";
	private String text_nome_comercial = "";
	private int qtd_solicitado;
	private String tipo_medicamento = "";
	private String status_troca = "";
	private String data_solicitacao = "";
	private String data_troca_efetivada = "";
	private String fb_id_doador = "";
	private double latitude;
	private double longitude;
	private String text_observacao = "";
	
	
	public String getText_observacao() {
		return text_observacao;
	}



	public void setText_observacao(String text_observacao) {
		this.text_observacao = text_observacao;
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



	/**
	 * 
	 * @param fk_usuario int
	 * @param parametro int
	 * @param tipo int
	 * @param pk_mmd int
	 * @param codigo_validador String
	 * @param text_nome_comercial String
	 * @param qtd_solicitado int
	 * @param tipo_medicamento String
	 * @param status_troca String
	 * @param data_solicitacao String
	 * @param data_troca_efetivada String
	 * @param fb_id_doador String
	 */
	public BuscarDoacoes(
			 String fb_id,
			 int parametro,
			 int tipo,
			 int pk_mmd,
			 String codigo_validador,
			 String text_nome_comercial,
			 int qtd_solicitado,
			 String tipo_medicamento,
			 String status_troca,
			 String data_solicitacao,
			 String data_troca_efetivada,
			 String fb_id_doador
			) {
		 this.fb_id = fb_id;
		 this.parametro = parametro;
		 this.tipo = tipo;
		 this.pk_mmd = pk_mmd;
		 this.codigo_validador = codigo_validador;
		 this.text_nome_comercial = text_nome_comercial;
		 this.qtd_solicitado = qtd_solicitado;
		 this.tipo_medicamento = tipo_medicamento;
		 this.status_troca = status_troca;
		 this.data_solicitacao = data_solicitacao;
		 this.data_troca_efetivada = data_troca_efetivada;
		 this.fb_id_doador = fb_id_doador;
		
		
	}
	
	

	public String getFb_id_doador() {
		return fb_id_doador;
	}



	public void setFb_id_doador(String fb_id_doador) {
		this.fb_id_doador = fb_id_doador;
	}



	public String getData_solicitacao() {
		return data_solicitacao;
	}

	public void setData_solicitacao(String data_solicitacao) {
		this.data_solicitacao = data_solicitacao;
	}

	public String getData_troca_efetivada() {
		return data_troca_efetivada;
	}

	public void setData_troca_efetivada(String data_troca_efetivada) {
		this.data_troca_efetivada = data_troca_efetivada;
	}

	public BuscarDoacoes() {}



	public int getParametro() {
		return parametro;
	}

	public void setParametro(int parametro) {
		this.parametro = parametro;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getPk_mmd() {
		return pk_mmd;
	}

	public void setPk_mmd(int pk_mmd) {
		this.pk_mmd = pk_mmd;
	}

	public String getCodigo_validador() {
		return codigo_validador;
	}

	public void setCodigo_validador(String codigo_validador) {
		this.codigo_validador = codigo_validador;
	}

	public String getText_nome_comercial() {
		return text_nome_comercial;
	}

	public void setText_nome_comercial(String text_nome_comercial) {
		this.text_nome_comercial = text_nome_comercial;
	}

	public int getQtd_solicitado() {
		return qtd_solicitado;
	}

	public void setQtd_solicitado(int qtd_solicitado) {
		this.qtd_solicitado = qtd_solicitado;
	}

	public String getTipo_medicamento() {
		return tipo_medicamento;
	}

	public void setTipo_medicamento(String tipo_medicamento) {
		this.tipo_medicamento = tipo_medicamento;
	}

	public String getStatus_troca() {
		return status_troca;
	}

	public void setStatus_troca(String status_troca) {
		this.status_troca = status_troca;
	}

	public String getFb_id() {
		return fb_id;
	}

	public void setFb_id(String fb_id) {
		this.fb_id = fb_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo_validador == null) ? 0 : codigo_validador.hashCode());
		result = prime * result + ((data_solicitacao == null) ? 0 : data_solicitacao.hashCode());
		result = prime * result + ((data_troca_efetivada == null) ? 0 : data_troca_efetivada.hashCode());
		result = prime * result + ((fb_id == null) ? 0 : fb_id.hashCode());
		result = prime * result + parametro;
		result = prime * result + pk_mmd;
		result = prime * result + qtd_solicitado;
		result = prime * result + ((status_troca == null) ? 0 : status_troca.hashCode());
		result = prime * result + ((text_nome_comercial == null) ? 0 : text_nome_comercial.hashCode());
		result = prime * result + tipo;
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
		BuscarDoacoes other = (BuscarDoacoes) obj;
		if (codigo_validador == null) {
			if (other.codigo_validador != null)
				return false;
		} else if (!codigo_validador.equals(other.codigo_validador))
			return false;
		if (data_solicitacao == null) {
			if (other.data_solicitacao != null)
				return false;
		} else if (!data_solicitacao.equals(other.data_solicitacao))
			return false;
		if (data_troca_efetivada == null) {
			if (other.data_troca_efetivada != null)
				return false;
		} else if (!data_troca_efetivada.equals(other.data_troca_efetivada))
			return false;
		if (fb_id == null) {
			if (other.fb_id != null)
				return false;
		} else if (!fb_id.equals(other.fb_id))
			return false;
		if (parametro != other.parametro)
			return false;
		if (pk_mmd != other.pk_mmd)
			return false;
		if (qtd_solicitado != other.qtd_solicitado)
			return false;
		if (status_troca == null) {
			if (other.status_troca != null)
				return false;
		} else if (!status_troca.equals(other.status_troca))
			return false;
		if (text_nome_comercial == null) {
			if (other.text_nome_comercial != null)
				return false;
		} else if (!text_nome_comercial.equals(other.text_nome_comercial))
			return false;
		if (tipo != other.tipo)
			return false;
		if (tipo_medicamento == null) {
			if (other.tipo_medicamento != null)
				return false;
		} else if (!tipo_medicamento.equals(other.tipo_medicamento))
			return false;
		return true;
	}

	

}



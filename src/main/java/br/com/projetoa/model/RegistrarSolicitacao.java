package br.com.projetoa.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Marcio Galvão
 * @since 2018
 */
@XmlRootElement
public class RegistrarSolicitacao  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fb_id_solicitante = "";
	private String tokenfb_doador = "";
	private int fk_medicamento_solicitado = 0;
	private int qtd_solicitado = 0;
	private String codigo_validador = "";
	private int  status_troca;
	private double nr_valor = 0; 
	private double latitude = 0;
	private double longitude =0;
	private int fk_usuarioin;
	
	public int getFk_usuarioin() {
		return fk_usuarioin;
	}

	public void setFk_usuarioin(int fk_usuarioin) {
		this.fk_usuarioin = fk_usuarioin;
	}

	/**
	 * 
	 * @param fb_id_solicitante String
	 * @param fk_medicamento_solicitado int
	 * @param qtd_solicitado int
	 * @param codigo_validador String
	 * @param status_troca int
	 * @param nr_valor double
	 * @param latitude double
	 * @param longitude double
	 */
	public RegistrarSolicitacao(
			 String fb_id_solicitante,
			 int fk_medicamento_solicitado,
			 int qtd_solicitado,
			 String codigo_validador,
			 int  status_troca,
			 double nr_valor,
			 double latitude,
			 double longitude
			) {
		 this.fb_id_solicitante = fb_id_solicitante;
		 this.fk_medicamento_solicitado = fk_medicamento_solicitado;
		 this.qtd_solicitado = qtd_solicitado; 
		 this.codigo_validador = codigo_validador;
		 this.status_troca = status_troca;
		 this.nr_valor = nr_valor;
		 this.latitude = latitude;
		 this.longitude = longitude;
		
	}

	public RegistrarSolicitacao() {}

	public String getTokenfb_doador() {
		return tokenfb_doador;
	}

	public void setTokenfb_doador(String tokenfb_doador) {
		this.tokenfb_doador = tokenfb_doador;
	}

	public String getFb_id_solicitante() {
		return fb_id_solicitante;
	}

	public void setFb_id_solicitante(String fb_id_solicitante) {
		this.fb_id_solicitante = fb_id_solicitante;
	}

	public int getFk_medicamento_solicitado() {
		return fk_medicamento_solicitado;
	}

	public void setFk_medicamento_solicitado(int fk_medicamento_solicitado) {
		this.fk_medicamento_solicitado = fk_medicamento_solicitado;
	}

	public int getQtd_solicitado() {
		return qtd_solicitado;
	}

	public void setQtd_solicitado(int qtd_solicitado) {
		this.qtd_solicitado = qtd_solicitado;
	}

	public String getCodigo_validador() {
		return codigo_validador;
	}

	public void setCodigo_validador(String codigo_validador) {
		this.codigo_validador = codigo_validador;
	}

	public int getStatus_troca() {
		return status_troca;
	}

	public void setStatus_troca(int status_troca) {
		this.status_troca = status_troca;
	}

	public double getNr_valor() {
		return nr_valor;
	}

	public void setNr_valor(double nr_valor) {
		this.nr_valor = nr_valor;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo_validador == null) ? 0 : codigo_validador.hashCode());
		result = prime * result + ((fb_id_solicitante == null) ? 0 : fb_id_solicitante.hashCode());
		result = prime * result + fk_medicamento_solicitado;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(nr_valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + qtd_solicitado;
		result = prime * result + status_troca;
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
		RegistrarSolicitacao other = (RegistrarSolicitacao) obj;
		if (codigo_validador == null) {
			if (other.codigo_validador != null)
				return false;
		} else if (!codigo_validador.equals(other.codigo_validador))
			return false;
		if (fb_id_solicitante == null) {
			if (other.fb_id_solicitante != null)
				return false;
		} else if (!fb_id_solicitante.equals(other.fb_id_solicitante))
			return false;
		if (fk_medicamento_solicitado != other.fk_medicamento_solicitado)
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (Double.doubleToLongBits(nr_valor) != Double.doubleToLongBits(other.nr_valor))
			return false;
		if (qtd_solicitado != other.qtd_solicitado)
			return false;
		if (status_troca != other.status_troca)
			return false;
		return true;
	}
	
	
	
}


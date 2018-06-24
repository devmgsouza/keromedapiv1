package br.com.projetoa.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author SOA - Development
 * @since 2018
 *
 */
@XmlRootElement
public class Medicamento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pk_medicamento;
	private String text_nome_comercial;
	private String text_principio_ativo;
	private String text_laboratorio;
	private String text_apresentacao;
	private String text_tarja;
	private String nr_ean;
	private String text_classe;
	private String url_image;


	/**
	 * 
	 * @param parametro_busca String
	 * @param pk_medicamento int
	 * @param text_nome_comercial String
	 * @param text_principio_ativo String
	 * @param text_laboratorio String
	 * @param text_tarja String
	 * @param nr_ean String
	 */
	public Medicamento(
			 int pk_medicamento,
			 String text_nome_comercial,
			 String text_principio_ativo,
			 String text_laboratorio,
			 String text_tarja,
			 String text_apresentacao,
			 String nr_ean,
			 String text_classe,
			 String url_image
			) {
	
		 this.pk_medicamento = pk_medicamento;
		 this.text_nome_comercial = text_nome_comercial;
		 this.text_principio_ativo = text_principio_ativo;
		 this.text_laboratorio = text_laboratorio;
		 this.text_apresentacao = text_apresentacao;
		 this.text_tarja = text_tarja;
		 this.nr_ean = nr_ean;
		 this.text_classe = text_classe;
		 this.url_image = url_image;
	}
	
	public Medicamento() {
		// TODO Auto-generated constructor stub
	}

	
	
	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public int getPk_medicamento() {
		return pk_medicamento;
	}

	public void setPk_medicamento(int pk_medicamento) {
		this.pk_medicamento = pk_medicamento;
	}

	public String getText_nome_comercial() {
		return text_nome_comercial;
	}

	public void setText_nome_comercial(String text_nome_comercial) {
		this.text_nome_comercial = text_nome_comercial;
	}

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

	public String getText_apresentacao() {
		return text_apresentacao;
	}

	public void setText_apresentacao(String text_apresentacao) {
		this.text_apresentacao = text_apresentacao;
	}

	public String getText_tarja() {
		return text_tarja;
	}

	public void setText_tarja(String text_tarja) {
		this.text_tarja = text_tarja;
	}

	public String getNr_ean() {
		return nr_ean;
	}

	public void setNr_ean(String nr_ean) {
		this.nr_ean = nr_ean;
	}

	public String getText_classe() {
		return text_classe;
	}

	public void setText_classe(String text_classe) {
		this.text_classe = text_classe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nr_ean == null) ? 0 : nr_ean.hashCode());
		result = prime * result + pk_medicamento;
		result = prime * result + ((text_apresentacao == null) ? 0 : text_apresentacao.hashCode());
		result = prime * result + ((text_classe == null) ? 0 : text_classe.hashCode());
		result = prime * result + ((text_laboratorio == null) ? 0 : text_laboratorio.hashCode());
		result = prime * result + ((text_nome_comercial == null) ? 0 : text_nome_comercial.hashCode());
		result = prime * result + ((text_principio_ativo == null) ? 0 : text_principio_ativo.hashCode());
		result = prime * result + ((text_tarja == null) ? 0 : text_tarja.hashCode());
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
		Medicamento other = (Medicamento) obj;
		if (nr_ean == null) {
			if (other.nr_ean != null)
				return false;
		} else if (!nr_ean.equals(other.nr_ean))
			return false;
		if (pk_medicamento != other.pk_medicamento)
			return false;
		if (text_apresentacao == null) {
			if (other.text_apresentacao != null)
				return false;
		} else if (!text_apresentacao.equals(other.text_apresentacao))
			return false;
		if (text_classe == null) {
			if (other.text_classe != null)
				return false;
		} else if (!text_classe.equals(other.text_classe))
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
		if (text_tarja == null) {
			if (other.text_tarja != null)
				return false;
		} else if (!text_tarja.equals(other.text_tarja))
			return false;
		return true;
	}




}
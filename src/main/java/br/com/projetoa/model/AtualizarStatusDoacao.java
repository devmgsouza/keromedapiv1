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
public class AtualizarStatusDoacao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigo_validador = "";
	private int status_troca;
	private int qtd_doado;
	
	/**
	 * 
	 * @param codigo_validador String
	 * @param status_troca int
	 * @param qtd_doado int
	 */
	public AtualizarStatusDoacao(
			 String codigo_validador,
			 int status_troca,
			 int qtd_doado
			) {
		 this.codigo_validador = codigo_validador;
		 this.status_troca = status_troca;
		 this.qtd_doado = qtd_doado;
	}
	
	public AtualizarStatusDoacao() {}

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

	public int getQtd_doado() {
		return qtd_doado;
	}

	public void setQtd_doado(int qtd_doado) {
		this.qtd_doado = qtd_doado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo_validador == null) ? 0 : codigo_validador.hashCode());
		result = prime * result + qtd_doado;
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
		AtualizarStatusDoacao other = (AtualizarStatusDoacao) obj;
		if (codigo_validador == null) {
			if (other.codigo_validador != null)
				return false;
		} else if (!codigo_validador.equals(other.codigo_validador))
			return false;
		if (qtd_doado != other.qtd_doado)
			return false;
		if (status_troca != other.status_troca)
			return false;
		return true;
	}
	
	
}

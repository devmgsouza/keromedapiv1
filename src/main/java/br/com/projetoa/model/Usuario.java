package br.com.projetoa.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author MARCIO GALVAO
 * @since 2018
 */
@XmlRootElement
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String text_nome = "";
	private String text_sobrenome = "";
	private String text_cpf = "";
	private String text_cnpj = ""; 
	private String text_razao_social = ""; 
	private String text_nm_rua = "";
	private double latitude = 0; 
	private double longitude = 0;
	private String text_email = "";
	private String text_fone = "";
	private String text_nr_residencia = "";
	private String text_cidade = "";
	private String text_uf = ""; 
	private String fb_id = "";
	private String data_nascimento = "";
	private String token_gcm = "";
	private int tipo_conta;
	private String text_password;
	
	public int getTipo_conta() {
		return tipo_conta;
	}

	public void setTipo_conta(int tipo_conta) {
		this.tipo_conta = tipo_conta;
	}

	/**
	 * 
	 * @param text_nome String
	 * @param text_sobrenome String
	 * @param text_cpf String
	 * @param text_cnpj String
	 * @param text_razao_social String
	 * @param text_nm_rua String
	 * @param latitude double
	 * @param longitude double
	 * @param text_email String
	 * @param text_fone String
	 * @param text_nr_residencia String
	 * @param text_cidade String
	 * @param text_uf String
	 * @param fb_id String
	 * @oaram data_nascimento
	 * @param token_gcm
	 * @param tipo_conta
	 * @param String
	 * 
	 */
	public Usuario(
			 String text_nome,
			 String text_sobrenome,
			 String text_cpf,
			 String text_cnpj,
			 String text_razao_social, 
			 String text_nm_rua,
			 double latitude, 
			 double longitude,
			 String text_email,
			 String text_fone,
			 String text_nr_residencia,
			 String text_cidade,
			 String text_uf,
			 String fb_id,
			 String data_nascimento,
			 String token_gcm,
			 int tipo_conta,
			 String text_password
			) {
		this.text_nome = text_nome;
		this.text_sobrenome =  text_sobrenome;
		this.text_cpf = text_cpf;
		this.text_cnpj = text_cnpj;
		this.text_razao_social = text_razao_social;
		this.text_nm_rua = text_nm_rua;
		this.latitude = latitude;
		this.longitude = longitude;
		this.text_email = text_email;
		this.text_fone = text_fone;
		this.text_nr_residencia =  text_nr_residencia;
		this.text_cidade = text_cidade;
		this.text_uf = text_uf;
		this.fb_id = fb_id;
		this.data_nascimento = data_nascimento;
		this.token_gcm = token_gcm;
		this.tipo_conta = tipo_conta;
		this.text_password = text_password;
		
	}
	
	public String getText_password() {
		return text_password;
	}

	public void setText_password(String text_password) {
		this.text_password = text_password;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getToken_gcm() {
		return token_gcm;
	}

	public void setToken_gcm(String token_gcm) {
		this.token_gcm = token_gcm;
	}

	public Usuario() {}
	

	public String getText_nome() {
		return text_nome;
	}

	public void setText_nome(String text_nome) {
		this.text_nome = text_nome;
	}

	public String getText_sobrenome() {
		return text_sobrenome;
	}

	public void setText_sobrenome(String text_sobrenome) {
		this.text_sobrenome = text_sobrenome;
	}

	public String getText_cpf() {
		return text_cpf;
	}

	public void setText_cpf(String text_cpf) {
		this.text_cpf = text_cpf;
	}

	public String getText_cnpj() {
		return text_cnpj;
	}

	public void setText_cnpj(String text_cnpj) {
		this.text_cnpj = text_cnpj;
	}

	public String getText_razao_social() {
		return text_razao_social;
	}

	public void setText_razao_social(String text_razao_social) {
		this.text_razao_social = text_razao_social;
	}

	public String getText_nm_rua() {
		return text_nm_rua;
	}

	public void setText_nm_rua(String text_nm_rua) {
		this.text_nm_rua = text_nm_rua;
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

	public String getText_email() {
		return text_email;
	}

	public void setText_email(String text_email) {
		this.text_email = text_email;
	}

	public String getText_fone() {
		return text_fone;
	}

	public void setText_fone(String text_fone) {
		this.text_fone = text_fone;
	}

	public String getText_nr_residencia() {
		return text_nr_residencia;
	}

	public void setText_nr_residencia(String text_nr_residencia) {
		this.text_nr_residencia = text_nr_residencia;
	}

	public String getText_cidade() {
		return text_cidade;
	}

	public void setText_cidade(String text_cidade) {
		this.text_cidade = text_cidade;
	}

	public String getText_uf() {
		return text_uf;
	}

	public void setText_uf(String text_uf) {
		this.text_uf = text_uf;
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
		result = prime * result + ((data_nascimento == null) ? 0 : data_nascimento.hashCode());
		result = prime * result + ((fb_id == null) ? 0 : fb_id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((text_cidade == null) ? 0 : text_cidade.hashCode());
		result = prime * result + ((text_cnpj == null) ? 0 : text_cnpj.hashCode());
		result = prime * result + ((text_cpf == null) ? 0 : text_cpf.hashCode());
		result = prime * result + ((text_email == null) ? 0 : text_email.hashCode());
		result = prime * result + ((text_fone == null) ? 0 : text_fone.hashCode());
		result = prime * result + ((text_nm_rua == null) ? 0 : text_nm_rua.hashCode());
		result = prime * result + ((text_nome == null) ? 0 : text_nome.hashCode());
		result = prime * result + ((text_nr_residencia == null) ? 0 : text_nr_residencia.hashCode());
		result = prime * result + ((text_razao_social == null) ? 0 : text_razao_social.hashCode());
		result = prime * result + ((text_sobrenome == null) ? 0 : text_sobrenome.hashCode());
		result = prime * result + ((text_uf == null) ? 0 : text_uf.hashCode());
		result = prime * result + ((token_gcm == null) ? 0 : token_gcm.hashCode());
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
		Usuario other = (Usuario) obj;
		if (data_nascimento == null) {
			if (other.data_nascimento != null)
				return false;
		} else if (!data_nascimento.equals(other.data_nascimento))
			return false;
		if (fb_id == null) {
			if (other.fb_id != null)
				return false;
		} else if (!fb_id.equals(other.fb_id))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		if (text_cidade == null) {
			if (other.text_cidade != null)
				return false;
		} else if (!text_cidade.equals(other.text_cidade))
			return false;
		if (text_cnpj == null) {
			if (other.text_cnpj != null)
				return false;
		} else if (!text_cnpj.equals(other.text_cnpj))
			return false;
		if (text_cpf == null) {
			if (other.text_cpf != null)
				return false;
		} else if (!text_cpf.equals(other.text_cpf))
			return false;
		if (text_email == null) {
			if (other.text_email != null)
				return false;
		} else if (!text_email.equals(other.text_email))
			return false;
		if (text_fone == null) {
			if (other.text_fone != null)
				return false;
		} else if (!text_fone.equals(other.text_fone))
			return false;
		if (text_nm_rua == null) {
			if (other.text_nm_rua != null)
				return false;
		} else if (!text_nm_rua.equals(other.text_nm_rua))
			return false;
		if (text_nome == null) {
			if (other.text_nome != null)
				return false;
		} else if (!text_nome.equals(other.text_nome))
			return false;
		if (text_nr_residencia == null) {
			if (other.text_nr_residencia != null)
				return false;
		} else if (!text_nr_residencia.equals(other.text_nr_residencia))
			return false;
		if (text_razao_social == null) {
			if (other.text_razao_social != null)
				return false;
		} else if (!text_razao_social.equals(other.text_razao_social))
			return false;
		if (text_sobrenome == null) {
			if (other.text_sobrenome != null)
				return false;
		} else if (!text_sobrenome.equals(other.text_sobrenome))
			return false;
		if (text_uf == null) {
			if (other.text_uf != null)
				return false;
		} else if (!text_uf.equals(other.text_uf))
			return false;
		if (token_gcm == null) {
			if (other.token_gcm != null)
				return false;
		} else if (!token_gcm.equals(other.token_gcm))
			return false;
		return true;
	}
	
	
	
	
	

}

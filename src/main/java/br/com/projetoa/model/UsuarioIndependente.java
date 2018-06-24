package br.com.projetoa.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioIndependente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pk_usuarioin;
	private String nomeCompleto;
	private String endereco;
	private String cidade;
	private String uf;
	private String cpf;
	private String rg;
	private String telefone;
	private String dataNascimento;
	private int fk_usuario;
	private String idade;
	
	
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public int getPk_usuarioin() {
		return pk_usuarioin;
	}
	public void setPk_usuarioin(int pk_usuarioin) {
		this.pk_usuarioin = pk_usuarioin;
	}
	public int getFk_usuario() {
		return fk_usuario;
	}
	public void setFk_usuario(int fk_usuario) {
		this.fk_usuario = fk_usuario;
	}

	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	

}

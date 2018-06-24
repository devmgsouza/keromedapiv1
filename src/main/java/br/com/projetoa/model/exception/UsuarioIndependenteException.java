package br.com.projetoa.model.exception;

public class UsuarioIndependenteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuarioIndependenteException(Throwable erro, String mensagem) {
		super(mensagem, erro);
	}
	public UsuarioIndependenteException(Throwable erro) {
		super(erro);
	}
	public UsuarioIndependenteException(String mensagem) {
		super(mensagem);
	}


}

package br.com.projetoa.model.exception;

public class UsuarioException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuarioException(Throwable erro, String mensagem) {
		super(mensagem, erro);
	}
	public UsuarioException(Throwable erro) {
		super(erro);
	}
	public UsuarioException(String mensagem) {
		super(mensagem);
	}


}

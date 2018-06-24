package br.com.projetoa.model.exception;

public class RegistrarSolicitacaoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RegistrarSolicitacaoException(Throwable erro, String mensagem) {
		super(mensagem, erro);
	}
	public RegistrarSolicitacaoException(Throwable erro) {
		super(erro);
	}
	public RegistrarSolicitacaoException(String mensagem) {
		super(mensagem);
	}


}

package br.com.projetoa.model.exception;

public class AtualizarStatusDoacaoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AtualizarStatusDoacaoException(Throwable erro, String mensagem) {
		super(mensagem, erro);
	}
	public AtualizarStatusDoacaoException(Throwable erro) {
		super(erro);
	}
	public AtualizarStatusDoacaoException(String mensagem) {
		super(mensagem);
	}


}

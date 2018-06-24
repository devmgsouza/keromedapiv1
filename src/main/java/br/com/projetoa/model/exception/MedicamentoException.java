package br.com.projetoa.model.exception;

public class MedicamentoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MedicamentoException(Throwable erro, String mensagem) {
		super(mensagem, erro);
	}
	public MedicamentoException(Throwable erro) {
		super(erro);
	}
	public MedicamentoException(String mensagem) {
		super(mensagem);
	}


}

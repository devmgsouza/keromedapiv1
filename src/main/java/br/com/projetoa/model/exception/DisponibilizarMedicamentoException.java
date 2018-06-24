package br.com.projetoa.model.exception;

public class DisponibilizarMedicamentoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DisponibilizarMedicamentoException(Throwable erro, String mensagem) {
		super(mensagem, erro);
	}
	public DisponibilizarMedicamentoException(Throwable erro) {
		super(erro);
	}
	public DisponibilizarMedicamentoException(String mensagem) {
		super(mensagem);
	}


}

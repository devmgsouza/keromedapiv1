package br.com.projetoa.model.exception;

public class MedicamentosDisponiveisException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MedicamentosDisponiveisException(Throwable erro, String mensagem) {
		super(mensagem, erro);
	}
	public MedicamentosDisponiveisException(Throwable erro) {
		super(erro);
	}
	public MedicamentosDisponiveisException(String mensagem) {
		super(mensagem);
	}


}

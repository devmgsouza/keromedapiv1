package br.com.projetoa.model.exception;

public class BuscarDoacoesException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BuscarDoacoesException(Throwable erro, String mensagem) {
		super(mensagem, erro);
	}
	public BuscarDoacoesException(Throwable erro) {
		super(erro);
	}
	public BuscarDoacoesException(String mensagem) {
		super(mensagem);
	}


}

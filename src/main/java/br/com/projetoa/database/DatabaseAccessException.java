package br.com.projetoa.database;

public class DatabaseAccessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DatabaseAccessException() {
		super();
	}
	
	public DatabaseAccessException(Throwable causa, String mensagem) {
		super(mensagem, causa);
	}
	
	public DatabaseAccessException(Throwable causa) {
		super(causa);
	}
	
	public DatabaseAccessException(String mensagem) {
		super(mensagem);
	}

}

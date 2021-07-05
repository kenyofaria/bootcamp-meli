package br.com.meli.api.rest.exception;

public class RecursoIndisponivelException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RecursoIndisponivelException(String mensagem) {
		super(mensagem);
	}
	public RecursoIndisponivelException(Exception e) {
		super(e);
	}
}

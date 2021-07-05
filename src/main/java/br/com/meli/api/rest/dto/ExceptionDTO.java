package br.com.meli.api.rest.dto;

public class ExceptionDTO {

	
	private String campo;
	private String mensagem;
	
	
	
	public ExceptionDTO(String mensagem) {
		super();
		this.mensagem = mensagem;
	}

	public ExceptionDTO(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
	public String getCampo() {
		return campo;
	}
}

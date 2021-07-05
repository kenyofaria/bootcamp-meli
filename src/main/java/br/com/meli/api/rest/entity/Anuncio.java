package br.com.meli.api.rest.entity;


public class Anuncio {

	
	private long id;
	private String codigo ;
	private String descricao;
	

	
	public Anuncio(long id, String codigo, String descricao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Anuncio() {
		
	}
	
	public long getId() {
		return id;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	
}

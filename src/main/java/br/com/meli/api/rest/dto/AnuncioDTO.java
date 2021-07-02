package br.com.meli.api.rest.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.meli.api.rest.dao.AnuncioDAO;
import br.com.meli.api.rest.entity.Anuncio;

public class AnuncioDTO {

	private String codigo;
	private String descricao;
	
	public AnuncioDTO(String codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public AnuncioDTO(Anuncio anuncio) {
		super();
		this.codigo = anuncio.getCodigo();
		this.descricao = anuncio.getDescricao();
	}
	public String getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public static AnuncioDTO converte(Anuncio anuncio) {
		return new AnuncioDTO(anuncio.getCodigo(), anuncio.getDescricao());
	}
	public static Anuncio converte(AnuncioDTO anuncio, AnuncioDAO dao) {
		return new Anuncio(dao.getList().size()+1,anuncio.getCodigo(), anuncio.getDescricao());
	}
	public static Anuncio converte(AnuncioDTO anuncio) {
		//new Anuncio(id, codigo, descricao)
		return new Anuncio(0L, anuncio.getCodigo(), anuncio.getDescricao());
	}
	public static List<AnuncioDTO> converte(List<Anuncio> anuncios) {
		return anuncios.stream().map(a -> new AnuncioDTO(a)).collect(Collectors.toList());
	}
}

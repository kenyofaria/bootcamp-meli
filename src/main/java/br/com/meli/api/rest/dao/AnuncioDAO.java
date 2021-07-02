package br.com.meli.api.rest.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.com.meli.api.rest.entity.Anuncio;

public class AnuncioDAO {

	private static List<Anuncio> anuncios = new ArrayList<Anuncio>(
				Arrays.asList(
							new Anuncio(1, "MLB001", "descricao anuncio 1"),
							new Anuncio(2, "MLB002", "descricao anuncio 2"),
							new Anuncio(3, "MLB003", "descricao anuncio 3"),
							new Anuncio(4, "MLB004", "descricao anuncio 4"),
							new Anuncio(5, "MLB005", "descricao anuncio 5")
						)
				
			);
	
	
	public List<Anuncio> getList(){
		return anuncios;
	}
	
	public void adicionar(Anuncio anuncio) {
		anuncios.add(anuncio);
	}
	
	public Anuncio get(long id) {
		Optional<Anuncio> anuncioOpt = anuncios.stream().filter(a -> a.getId() == id).findFirst();
		Anuncio a = anuncioOpt.orElse(anuncioOpt.get());
		return a;
	}
	
}

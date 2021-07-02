package br.com.meli.api.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.api.rest.dao.AnuncioRepository;
import br.com.meli.api.rest.entity.Anuncio;

@Service
public class AnuncioService {


	private AnuncioRepository repository;
	
	public void cadastra(Anuncio anuncio) {
		if(anuncio.getDescricao().length() < 3)
			throw new RuntimeException("O anuncio deve ter no mínimo 3 caracteres");
		repository.add(anuncio);
	}
	
	public List<Anuncio> listar(){
		return repository.getList();
	}
	
	public AnuncioService() {
		
	}
	
	@Autowired
	public AnuncioService(AnuncioRepository repository) {
		this.repository = repository;
		
	}
}

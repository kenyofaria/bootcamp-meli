package br.com.meli.api.rest.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.meli.api.rest.entity.Anuncio;

@Repository
public class AnuncioRepository{

	private static final File FILE = new File("anuncios.json");
	@Autowired
	private ObjectMapper mapper;

	public List<Anuncio> getList(){
		List<Anuncio> anuncios = new ArrayList<>();
		try {
			FileInputStream is = new FileInputStream(FILE);
			TypeReference<List<Anuncio>> typeReference = new TypeReference<List<Anuncio>>() {};
			anuncios = mapper.readValue(is, typeReference);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return anuncios;
	}
	
	public void add(Anuncio anuncio) {
		try {
			 List<Anuncio> anuncios = getList();
			 anuncios.add(anuncio);
			 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
			 mapper.writeValue(out, anuncios);
			 out.close();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

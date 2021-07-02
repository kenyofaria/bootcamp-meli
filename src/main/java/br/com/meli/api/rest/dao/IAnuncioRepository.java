package br.com.meli.api.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meli.api.rest.entity.Anuncio;


public interface IAnuncioRepository extends JpaRepository<Anuncio, Long>{

}

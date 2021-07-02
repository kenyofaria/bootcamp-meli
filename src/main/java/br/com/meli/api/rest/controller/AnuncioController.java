package br.com.meli.api.rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.meli.api.rest.dao.AnuncioDAO;
import br.com.meli.api.rest.dto.AnuncioDTO;
import br.com.meli.api.rest.entity.Anuncio;
import br.com.meli.api.rest.service.AnuncioService;

@RestController
@RequestMapping("/anuncios")
public class AnuncioController {

	@Autowired
	private AnuncioService anuncioService;
	
	private AnuncioDAO dao = new AnuncioDAO();
	
	@RequestMapping("/ed1/{p}")
	public String endPoint1(@PathVariable String p) {
		return "recebido: " + p + " retornando : {\"id\":\"1\", \"nome\":\"kenyo\"}";
	}
	
	@RequestMapping("/ed2")
	public String endPoint2() {
		return "consumindo endpoint 2";
	}
	
	@GetMapping("/ed3/{p1}/{p2}/{p3}")
	public String endPoint3(@PathVariable("p1") String param1, @PathVariable("p2") String param2, @PathVariable("p3") String param3) {
		return "parametros recebidos: " + param1 + "--" + param2 + "--" + param3;
	}
	
	@GetMapping
	@RequestMapping("/ed4")
	public String endPoint4(@RequestParam("param1") String p1, @RequestParam("param2") String p2) {
		return "parametros recebidos: " + p1 + " : " + p2;
	}
	
	@GetMapping
	@RequestMapping("/ed5/{pPath}")
	public String endPoint5(@RequestParam("antigo") String antigo, @PathVariable("pPath") String novo) {
		return "parametros recebidos: " + antigo + " : " + novo;
	}
	
	@GetMapping
	@RequestMapping("/ed6")
	public AnuncioDTO endPoint6() {
		Anuncio anuncio = new Anuncio(1, "MLB019182", "Chuteira Adidas Messi 2021");
		return AnuncioDTO.converte(anuncio);
	}
	
	@GetMapping
	@RequestMapping("/ed7")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<AnuncioDTO> endPoint7() {
		Anuncio anuncio = new Anuncio(1, "MLB019182", "Chuteira Adidas Messi 2021");
		return new ResponseEntity<AnuncioDTO>(AnuncioDTO.converte(anuncio), HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public ResponseEntity<AnuncioDTO> cadastra(@RequestBody AnuncioDTO anuncioDTO, UriComponentsBuilder uriBuilder) {
		Anuncio anuncio = AnuncioDTO.converte(anuncioDTO, dao);
		dao.adicionar(anuncio);
		URI uri = uriBuilder.path("/anuncios/{id}").buildAndExpand(anuncio.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public AnuncioDTO obterAnuncio(@PathVariable long id) {
		Anuncio anuncio = dao.get(id);
		AnuncioDTO anuncioDTO = AnuncioDTO.converte(anuncio);
		return anuncioDTO;
	}
	
	@GetMapping
	public List<AnuncioDTO> obterAnuncios() {
		List<Anuncio> anuncios = anuncioService.listar();
		List<AnuncioDTO> dtos = AnuncioDTO.converte(anuncios);
		return dtos;
	}
	
	
	@PostMapping
	@RequestMapping("/cadastra")
	public void cadastraAnuncio(@RequestBody AnuncioDTO dto) {
		Anuncio anuncio = AnuncioDTO.converte(dto);
		anuncioService.cadastra(anuncio);
	}
}

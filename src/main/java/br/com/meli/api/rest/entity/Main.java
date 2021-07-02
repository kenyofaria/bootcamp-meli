package br.com.meli.api.rest.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

	
	public static void main(String[] args) {
		Pedido pedido = new Pedido(LocalDate.now(), new BigDecimal(400), 1, new Anuncio());
	}
}

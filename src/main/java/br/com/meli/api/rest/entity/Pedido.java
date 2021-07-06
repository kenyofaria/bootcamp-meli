package br.com.meli.api.rest.entity;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Pedido {

	private long id;
	private LocalDate dataPedido;
	private BigDecimal valorTotal;
	private int quantidade;
	private Anuncio anuncio;
	
	
	public Pedido(LocalDate dataPedido, BigDecimal valorTotal, int quantidade, Anuncio anuncio) {
		super();
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
		this.quantidade = quantidade;
		this.anuncio = anuncio;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Anuncio getAnuncio() {
		return anuncio;
	}
	public long getId() {
		return id;
	}
	
}

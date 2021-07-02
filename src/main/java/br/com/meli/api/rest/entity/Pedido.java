package br.com.meli.api.rest.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate dataPedido;
	private BigDecimal valorTotal;
	private int quantidade;
	@ManyToOne
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
	
}

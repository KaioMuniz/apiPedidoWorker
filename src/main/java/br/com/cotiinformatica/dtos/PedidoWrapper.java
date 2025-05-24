package br.com.cotiinformatica.dtos;

import java.time.OffsetDateTime;

public class PedidoWrapper {

	private String id;
	private OffsetDateTime dataGeracao;
	private Pedido pedido;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OffsetDateTime getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(OffsetDateTime dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
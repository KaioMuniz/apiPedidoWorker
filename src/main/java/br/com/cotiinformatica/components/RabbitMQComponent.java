package br.com.cotiinformatica.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cotiinformatica.dtos.PedidoWrapper;

@Component
public class RabbitMQComponent {
	
	@Autowired ObjectMapper objectMapper;

	@RabbitListener(queues = "pedidos")
	public void consumer(@Payload String message) throws Exception {
		
		//ler a mensagem contida na fila e deserializar
		var pedidoWrapper = objectMapper.readValue(message, PedidoWrapper.class);
		
		//imprimindo os dados do pedido
		System.out.println("\n\nPedido recebido:\n");
		System.out.println("ID da mensagem: " + pedidoWrapper.getId());
		System.out.println("Enviado em: " + pedidoWrapper.getDataGeracao());
		System.out.println("\tID do pedido: " + pedidoWrapper.getPedido().getId());
		System.out.println("\tCliente: " + pedidoWrapper.getPedido().getCliente());
		System.out.println("\tData: " + pedidoWrapper.getPedido().getDataPedido());
		System.out.println("\tValor total: " + pedidoWrapper.getPedido().getValorTotal());
		System.out.println("\tDescrição: " + pedidoWrapper.getPedido().getDescricao());
	}
}

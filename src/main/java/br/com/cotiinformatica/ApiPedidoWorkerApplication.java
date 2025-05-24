package br.com.cotiinformatica;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ApiPedidoWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPedidoWorkerApplication.class, args);
	}

}

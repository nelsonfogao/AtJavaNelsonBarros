package br.edu.infnet.pedidoAt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PedidoAtApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoAtApplication.class, args);
	}

}

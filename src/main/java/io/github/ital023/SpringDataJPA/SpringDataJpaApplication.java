package io.github.ital023.SpringDataJPA;

import io.github.ital023.SpringDataJPA.domain.entity.Cliente;
import io.github.ital023.SpringDataJPA.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes){
		return args -> {
			Cliente cliente = new Cliente();
			cliente.setNome("ital023");
			clientes.salvar(cliente);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}

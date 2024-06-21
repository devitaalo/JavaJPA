package io.github.ital023.SpringDataJPA;

import io.github.ital023.SpringDataJPA.domain.entity.Cliente;
import io.github.ital023.SpringDataJPA.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes){
		return args -> {
			clientes.save(new Cliente("Italo"));
			clientes.save(new Cliente("davi"));

			List<Cliente> todosClientes = clientes.findAll();

			todosClientes.forEach(System.out::println);

			todosClientes.forEach(cliente -> {
				cliente.setNome(cliente.getNome() + "atualizado");
				clientes.save(cliente);
			});


			todosClientes = clientes.findAll();

			todosClientes.forEach(System.out::println);

			System.out.println();
			System.out.println("Buscando clientes");
			clientes.findByNomeLike("Ita").forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}

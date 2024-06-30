package io.github.ital023.SpringDataJPA;

import io.github.ital023.SpringDataJPA.domain.entity.Cliente;
import io.github.ital023.SpringDataJPA.domain.entity.Produto;
import io.github.ital023.SpringDataJPA.domain.repositorio.Clientes;
import io.github.ital023.SpringDataJPA.domain.repositorio.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired Clientes clientes, @Autowired Produtos produtos){
		return args -> {
			Cliente c = new Cliente("Italo","2130123");
			Cliente c2 = new Cliente("davi","9324939");
			Cliente c3 = new Cliente("TOnhas","102301230");
			clientes.save(c);
			clientes.save(c2);
			clientes.save(c3);

			Produto produto = new Produto("Celular");
			Produto produto2 = new Produto("Televisao");
			Produto produto3 = new Produto("Computador");

			produtos.save(produto);
			produtos.save(produto2);
			produtos.save(produto3);


		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}

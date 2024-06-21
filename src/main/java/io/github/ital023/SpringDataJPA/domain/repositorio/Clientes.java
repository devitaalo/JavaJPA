package io.github.ital023.SpringDataJPA.domain.repositorio;

import io.github.ital023.SpringDataJPA.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String nome);

    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

    Cliente findOneByNomeLike(String nome);

    boolean existsByNome(String nome);

}

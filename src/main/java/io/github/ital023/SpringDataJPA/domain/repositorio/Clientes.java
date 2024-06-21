package io.github.ital023.SpringDataJPA.domain.repositorio;

import io.github.ital023.SpringDataJPA.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT * FROM tb_cliente c WHERE c.nome LIKE %:nome%", nativeQuery = true)
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query(value = "DELETE FROM cliente WHERE c.nome = :nome", nativeQuery = true)
    @Modifying //Diz ao BD que está havendo uma atualização tanto deleção quanto atualização
    void deleteByNome(String nome);

}

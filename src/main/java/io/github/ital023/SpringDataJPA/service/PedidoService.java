package io.github.ital023.SpringDataJPA.service;

import io.github.ital023.SpringDataJPA.domain.entity.Pedido;
import io.github.ital023.SpringDataJPA.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar(PedidoDTO pedidoDTO);

    Optional<Pedido> obterPedidoCompleto(Integer id);

}

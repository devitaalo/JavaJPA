package io.github.ital023.SpringDataJPA.service.impl;

import io.github.ital023.SpringDataJPA.domain.repositorio.Pedidos;
import io.github.ital023.SpringDataJPA.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private Pedidos pedidos;


}

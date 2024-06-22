package io.github.ital023.SpringDataJPA.rest.controller;

import io.github.ital023.SpringDataJPA.rest.dto.PedidoDTO;
import io.github.ital023.SpringDataJPA.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;



}

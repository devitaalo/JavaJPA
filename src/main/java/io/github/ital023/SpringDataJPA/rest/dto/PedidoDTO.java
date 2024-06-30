package io.github.ital023.SpringDataJPA.rest.dto;

import io.github.ital023.SpringDataJPA.validation.NotEmptyList;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    @NotNull(message = "Informe o codigo do cliente")
    private Integer cliente;
    @NotNull(message = "Informe o total do pedido e obrigatorio")
    private BigDecimal total;
    @NotEmptyList(message = "Pedido nao pode ser realizado sem itens")
    private List<ItemsPedidoDTO> items;



}

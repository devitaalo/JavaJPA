package io.github.ital023.SpringDataJPA.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformacoesItemPedidoDTO {

    private String descricaoProduto;

    private BigDecimal precoUnitario;

    private Integer quantidade;

}

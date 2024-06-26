package io.github.ital023.SpringDataJPA.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemsPedidoDTO {

    private Integer produto;
    private Integer quantidade;

}

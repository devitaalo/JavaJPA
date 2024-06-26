package io.github.ital023.SpringDataJPA.service.impl;

import io.github.ital023.SpringDataJPA.domain.entity.Cliente;
import io.github.ital023.SpringDataJPA.domain.entity.ItemPedido;
import io.github.ital023.SpringDataJPA.domain.entity.Pedido;
import io.github.ital023.SpringDataJPA.domain.entity.Produto;
import io.github.ital023.SpringDataJPA.domain.repositorio.Clientes;
import io.github.ital023.SpringDataJPA.domain.repositorio.ItemsPedido;
import io.github.ital023.SpringDataJPA.domain.repositorio.Pedidos;
import io.github.ital023.SpringDataJPA.domain.repositorio.Produtos;
import io.github.ital023.SpringDataJPA.exception.RegraNegocioException;
import io.github.ital023.SpringDataJPA.rest.dto.ItemsPedidoDTO;
import io.github.ital023.SpringDataJPA.rest.dto.PedidoDTO;
import io.github.ital023.SpringDataJPA.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private Pedidos pedidos;

    @Autowired
    private Clientes clientes;

    @Autowired
    private Produtos produtos;

    @Autowired
    private ItemsPedido itemsPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO pedidoDTO) {

        Integer idCliente = pedidoDTO.getCliente();

        Cliente cliente = clientes.findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Codigo de cliente invalido"));


        Pedido pedido = new Pedido();
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setDate(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemsPedido = converterItems(pedido, pedidoDTO.getItems());

        pedidos.save(pedido);
        itemsPedidoRepository.saveAll(itemsPedido);
        pedido.setItens(itemsPedido);

        return pedido;
    }



    private List<ItemPedido> converterItems(Pedido pedido, List<ItemsPedidoDTO> items){
        if(items.isEmpty()){
            throw new RegraNegocioException("Nao e possivel realizar um pedido sem items");
        }
        return items
                .stream()
                .map(dto -> {

                    Integer idProduto = dto.getProduto();
                    Produto produto = produtos
                            .findById(idProduto)
                            .orElseThrow( () -> new RegraNegocioException(
                                    "Codigo de produto invalido: " + idProduto
                            ) );


                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);

                    return itemPedido;
                }).collect(Collectors.toList());
    }


    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return pedidos.findByFetchItens(id);
    }

}

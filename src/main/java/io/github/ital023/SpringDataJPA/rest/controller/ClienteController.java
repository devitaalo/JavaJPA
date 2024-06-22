package io.github.ital023.SpringDataJPA.rest.controller;

import io.github.ital023.SpringDataJPA.domain.entity.Cliente;
import io.github.ital023.SpringDataJPA.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    /*@RequestMapping(
            value = {"/hello/{nome}", "/hello"},
            method = RequestMethod.GET
            //consumes = {"application/json", "application/xml"}, //formato como pode receber
            //produces = {"application/json", "application/xml"} //formato como response body pode ser
    )
    @ResponseBody
    public String helloClientes( @PathVariable("nome") String nomeCliente ){
        return "Hello: " + nomeCliente;
    }*/

    @Autowired
    private Clientes clientes;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteByID( @PathVariable Integer id ) {

        Optional<Cliente> cliente = clientes.findById(id);

        if(cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Cliente> save ( @RequestBody Cliente cliente ) {
        Cliente clienteSalvo = clientes.save(cliente);

        return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Cliente> cliente = clientes.findById(id);

        if(cliente.isPresent()){
            clientes.delete( cliente.get() );
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity update( @PathVariable Integer id, @RequestBody Cliente cliente ) {

        return clientes
                .findById(id)
                .map( clienteExistente ->  {
                    cliente.setId(clienteExistente.getId());
                    clientes.save(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build() );

    }

    @GetMapping
    public ResponseEntity find(Cliente filtro){

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING
                );

        Example example = Example.of(filtro, matcher);

        List<Cliente> lista = clientes.findAll(example);
        return ResponseEntity.ok(lista);
    }
    

}

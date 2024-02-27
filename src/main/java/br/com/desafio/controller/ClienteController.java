package br.com.desafio.controller;

import br.com.desafio.domain.entity.ClienteEntity;
import br.com.desafio.domain.request.ClienteRequest;
import br.com.desafio.domain.request.UpdateRequest;
import br.com.desafio.repository.ClienteRepo;
import br.com.desafio.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteRepo clienteRepo;


    @PostMapping
    public ResponseEntity<?> inserirCliente(@RequestBody @Valid ClienteRequest request){
        var response = service.salvarCliente(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarClienteById(@PathVariable(name = "id") Long clienteId){
        var response = service.buscarClienteById(clienteId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarClientes() {
        var clientes = service.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid UpdateRequest request) {

        var response = service.atualizarCliente(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable(name = "id") Long id) {
        service.deletarCliente(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}

package com.example.barbearia_pai.controller;

import com.example.barbearia_pai.domain.cliente.Cliente;
import com.example.barbearia_pai.domain.cliente.ClienteRepository;
import com.example.barbearia_pai.domain.cliente.ClienteService;
import com.example.barbearia_pai.dto.cliente.DadosDetalhamentoCliente;
import com.example.barbearia_pai.dto.cliente.InfosCadastroCliente;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService  clienteService;

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCliente(@RequestBody @Valid InfosCadastroCliente infoCliente, UriComponentsBuilder uriComponentsBuilder){
        var clienteNovo = new Cliente(infoCliente);
        clienteService.cadastrar(clienteNovo);

        var uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(clienteNovo.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(clienteNovo));
    }

    @GetMapping
    @Transactional
    public ResponseEntity<Page<DadosDetalhamentoCliente>> listarClientes(Pageable paginacao){
        var page = clienteRepository.findAll(paginacao).map(DadosDetalhamentoCliente::new);
        return ResponseEntity.ok(page);
    }

}

package com.example.barbearia_pai.controller;


import com.example.barbearia_pai.domain.barbeiro.Barbeiro;
import com.example.barbearia_pai.domain.barbeiro.BarbeiroRepository;
import com.example.barbearia_pai.domain.barbeiro.BarbeiroService;
import com.example.barbearia_pai.dto.barbeiro.DadosDetalhamentoBarbeiro;
import com.example.barbearia_pai.dto.barbeiro.InfosCadastroBarbeiro;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/barbeiro")
public class BarbeiroController {

    @Autowired
    BarbeiroService service;

    @Autowired
    BarbeiroRepository barbeiroRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrarBarbeiro(@RequestBody @Valid InfosCadastroBarbeiro infosCadastroBarbeiro, UriComponentsBuilder uriComponentsBuilder){
        var barbeiro = new Barbeiro(infosCadastroBarbeiro);
        var barbeiroSalvo = service.cadastrar(barbeiro);
        var uri = uriComponentsBuilder.path("/barbeiro/{id}").buildAndExpand(barbeiro.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoBarbeiro(barbeiroSalvo));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoBarbeiro>> devolverBarbeiros(Pageable paginacao){
        var page = barbeiroRepository.findAll(paginacao).map(DadosDetalhamentoBarbeiro::new);
        return ResponseEntity.ok(page);
    }

}

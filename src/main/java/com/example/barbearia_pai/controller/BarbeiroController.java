package com.example.barbearia_pai.controller;


import com.example.barbearia_pai.domain.barbeiro.Barbeiro;
import com.example.barbearia_pai.domain.barbeiro.BarbeiroService;
import com.example.barbearia_pai.dto.DadosDetalhamentoBarbeiro;
import com.example.barbearia_pai.dto.InfosCadastroBarbeiro;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barbeiro")
public class BarbeiroController {

    @Autowired
    BarbeiroService service;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrarBarbeiro(@RequestBody @Valid InfosCadastroBarbeiro infosCadastroBarbeiro){
        var barbeiro = new Barbeiro(infosCadastroBarbeiro);
        var barbeiroSalvo = service.cadastrar(barbeiro);

        return ResponseEntity.status(HttpStatus.CREATED).body(new DadosDetalhamentoBarbeiro(barbeiroSalvo));
    }

//    @GetMapping
//    public ResponseEntity devolverBarbeiros(){
//        return
//    }

}

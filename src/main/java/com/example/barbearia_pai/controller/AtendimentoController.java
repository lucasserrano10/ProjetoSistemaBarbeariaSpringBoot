package com.example.barbearia_pai.controller;

import com.example.barbearia_pai.domain.atendimento.Atendimento;
import com.example.barbearia_pai.domain.atendimento.AtendimentoRepository;
import com.example.barbearia_pai.domain.atendimento.AtendimentoService;
import com.example.barbearia_pai.dto.atendimento.DadosDetalhamentoAtendimento;
import com.example.barbearia_pai.dto.atendimento.InfosCadastroAtendimento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

    @Autowired
    AtendimentoService atendimentoService;

    @Autowired
    AtendimentoRepository atendimentoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity agendarAtendimento(@Valid @RequestBody InfosCadastroAtendimento infosCadastroAtendimento, UriComponentsBuilder uriComponentsBuilder){
        var atendimento = new Atendimento(infosCadastroAtendimento);
        atendimentoService.cadastrar(atendimento);

        var uri = uriComponentsBuilder.path("/atendimento/{id}").buildAndExpand(atendimento.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtendimento(atendimento));

    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoAtendimento>> listarAtendimentos(Pageable paginacao){
        var page = atendimentoRepository.findAll(paginacao).map(DadosDetalhamentoAtendimento::new);
        return ResponseEntity.ok(page);
    }
}

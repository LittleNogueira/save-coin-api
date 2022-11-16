package br.com.fiap.savecoin.controller;

import br.com.fiap.savecoin.factory.LancamentoFactory;
import br.com.fiap.savecoin.model.Lancamento;
import br.com.fiap.savecoin.request.LancamentoRequest;
import br.com.fiap.savecoin.service.LancamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/lancamento")
@AllArgsConstructor
public class LancamentoController {

    private final LancamentoService lancamentoService;
    private final LancamentoFactory lancamentoFactory;

    @PostMapping
    public ResponseEntity<Lancamento> salvar(@RequestBody @Valid LancamentoRequest lancamentoRequest, @RequestHeader("usuario") String usuario){
        Lancamento lancamento = lancamentoFactory.factory(lancamentoRequest, usuario);
        Lancamento lancamentoPersistido = lancamentoService.salvar(lancamento);
        return new ResponseEntity<>(lancamentoPersistido, CREATED);
    }

}

package br.com.fiap.savecoin.controller;

import br.com.fiap.savecoin.model.Economia;
import br.com.fiap.savecoin.service.EconomiaService;
import br.com.fiap.savecoin.util.ReferenciaUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/economia")
@AllArgsConstructor
public class EconomiaController {

    private final EconomiaService economiaService;

    @GetMapping
    public ResponseEntity<List<Economia>> historico(@RequestHeader("usuario") String usuario){
        economiaService.calcularEconomia(ReferenciaUtil.atual(), usuario);
        List<Economia> economias = economiaService.ultimasEconomias(usuario);
        return ResponseEntity.ok(economias);
    }
}

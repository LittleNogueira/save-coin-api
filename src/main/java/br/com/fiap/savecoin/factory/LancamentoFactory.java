package br.com.fiap.savecoin.factory;

import br.com.fiap.savecoin.model.Lancamento;
import br.com.fiap.savecoin.model.Usuario;
import br.com.fiap.savecoin.request.LancamentoRequest;
import br.com.fiap.savecoin.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LancamentoFactory {

    private final UsuarioService usuarioService;

    public Lancamento factory(LancamentoRequest lancamentoRequest, String usuarioUUID){
        Usuario usuario = usuarioService.buscar(usuarioUUID);
        return Lancamento.builder()
                .nome(lancamentoRequest.getNome())
                .valor(lancamentoRequest.getValor())
                .tipo(lancamentoRequest.getTipo())
                .recorrencia(lancamentoRequest.getRecorrencia())
                .usuario(usuario)
                .build();
    }

}

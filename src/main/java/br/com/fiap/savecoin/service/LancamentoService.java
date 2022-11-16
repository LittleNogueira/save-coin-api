package br.com.fiap.savecoin.service;

import br.com.fiap.savecoin.model.Lancamento;
import br.com.fiap.savecoin.repository.LancamentoRepository;
import br.com.fiap.savecoin.util.ReferenciaUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LancamentoService {

    private final LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }

    public List<Lancamento> lancamentoMesAtual(String usuario){
        String referencia = ReferenciaUtil.atual();
        return lancamentoRepository.findLancamentosByReferencia(referencia, usuario);
    }

}

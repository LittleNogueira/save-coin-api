package br.com.fiap.savecoin.service;

import br.com.fiap.savecoin.dto.CalculoDTO;
import br.com.fiap.savecoin.model.Economia;
import br.com.fiap.savecoin.model.Lancamento;
import br.com.fiap.savecoin.repository.EconomiaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

import static br.com.fiap.savecoin.enumeration.Recorrencia.*;
import static br.com.fiap.savecoin.enumeration.Tipo.ENTRADA;
import static java.math.BigDecimal.ZERO;

@Service
@AllArgsConstructor
public class EconomiaService {

    private final LancamentoService lancamentoService;
    private final EconomiaRepository economiaRepository;
    private final UsuarioService usuarioService;

    public Economia calcularEconomia(String referencia, String usuario){
        Optional<Economia> economiaOptional = economiaRepository.findByReferenciaAndUsuarioUuid(referencia, usuario);

        Economia economiaAtual = economiaOptional.orElse(new Economia());
        CalculoDTO calculoDTO = calculaEconomia(lancamentoService.lancamentoMesAtual(usuario));

        economiaAtual.setEntrada(calculoDTO.getEntrada());
        economiaAtual.setSaida(calculoDTO.getSaida());
        economiaAtual.setUsuario(usuarioService.buscar(usuario));

        return economiaRepository.save(economiaAtual);
    }

    public List<Economia> ultimasEconomias(String usuario){
        return economiaRepository.findTop3ByUsuarioUuidOrderByIdDesc(usuario);
    }

    private CalculoDTO calculaEconomia(List<Lancamento> lancamentos){
        BigDecimal entrada = ZERO;
        BigDecimal saida = ZERO;

        for(Lancamento lancamento : lancamentos){
            if(ENTRADA.equals(lancamento.getTipo()))
                entrada = entrada.add(calculaValor(lancamento));
            else
                saida = saida.add(calculaValor(lancamento));
        }

        return new CalculoDTO(entrada, saida);
    }

    private BigDecimal calculaValor(Lancamento lancamento){
        BigDecimal valor = lancamento.getValor();
        String referencia = lancamento.getReferencia();
        Integer ano = Integer.valueOf(referencia.substring(referencia.length()-4,referencia.length()));
        Integer mes = Integer.valueOf(referencia.substring(0,referencia.length()-4));

        YearMonth mesAtual = YearMonth.of(ano, mes);

        if(lancamento.getRecorrencia() == MENSAL || lancamento.getRecorrencia() == UNICA){
            return valor;
        }else if(lancamento.getRecorrencia() == SEMANAL){
            return valor.multiply(new BigDecimal(mesAtual.lengthOfMonth()/7));
        }else{
            return valor.multiply(new BigDecimal(mesAtual.lengthOfMonth()));
        }
    }
}

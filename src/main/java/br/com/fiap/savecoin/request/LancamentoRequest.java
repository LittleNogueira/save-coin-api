package br.com.fiap.savecoin.request;

import br.com.fiap.savecoin.enumeration.Recorrencia;
import br.com.fiap.savecoin.enumeration.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LancamentoRequest {

    @NotEmpty
    private String nome;

    @Min(value = 1)
    private BigDecimal valor;

    @NotNull
    private Tipo tipo;

    @NotNull
    private Recorrencia recorrencia;
}

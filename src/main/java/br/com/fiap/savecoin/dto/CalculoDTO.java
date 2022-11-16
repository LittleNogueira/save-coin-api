package br.com.fiap.savecoin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculoDTO {

    private BigDecimal entrada;

    private BigDecimal saida;

}

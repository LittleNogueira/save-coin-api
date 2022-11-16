package br.com.fiap.savecoin.model;

import br.com.fiap.savecoin.enumeration.Recorrencia;
import br.com.fiap.savecoin.enumeration.Tipo;
import br.com.fiap.savecoin.util.ReferenciaUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    private Recorrencia recorrencia;

    private String referencia;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="usuario_uuid", nullable=false)
    private Usuario usuario;

    @PrePersist
    private void prePersist(){
        this.referencia = ReferenciaUtil.atual();
    }

}

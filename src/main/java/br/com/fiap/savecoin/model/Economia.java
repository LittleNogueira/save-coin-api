package br.com.fiap.savecoin.model;

import br.com.fiap.savecoin.util.ReferenciaUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Economia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal entrada;

    private BigDecimal saida;

    @Column(unique = true)
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

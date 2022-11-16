package br.com.fiap.savecoin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    private String uuid;

    private String nome;

    private String email;

    @PrePersist
    private void prePersist(){
        this.uuid = UUID.randomUUID().toString();
    }

}

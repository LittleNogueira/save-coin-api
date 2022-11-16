package br.com.fiap.savecoin.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

    @NotEmpty
    private String nome;

    @Email
    @NotEmpty
    private String email;
}

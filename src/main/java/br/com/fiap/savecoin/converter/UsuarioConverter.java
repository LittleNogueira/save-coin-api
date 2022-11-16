package br.com.fiap.savecoin.converter;

import br.com.fiap.savecoin.model.Usuario;
import br.com.fiap.savecoin.request.UsuarioRequest;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {

    public Usuario convert(UsuarioRequest usuarioRequest){
        return Usuario.builder()
                .nome(usuarioRequest.getNome())
                .email(usuarioRequest.getEmail())
                .build();
    }

}

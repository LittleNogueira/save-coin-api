package br.com.fiap.savecoin.service;

import br.com.fiap.savecoin.model.Usuario;
import br.com.fiap.savecoin.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario buscar(String uuid){
        return usuarioRepository.findById(uuid).orElseThrow(() -> new RuntimeException(format("Usuario com uuid %s nao encontrado!", uuid)));
    }

}

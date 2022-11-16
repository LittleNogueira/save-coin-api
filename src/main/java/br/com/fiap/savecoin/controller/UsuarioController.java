package br.com.fiap.savecoin.controller;

import br.com.fiap.savecoin.converter.UsuarioConverter;
import br.com.fiap.savecoin.model.Usuario;
import br.com.fiap.savecoin.request.UsuarioRequest;
import br.com.fiap.savecoin.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioConverter usuarioConverter;

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody @Valid UsuarioRequest usuarioRequest){
        Usuario usuario = usuarioConverter.convert(usuarioRequest);
        Usuario usuriousPersistido = usuarioService.salvar(usuario);
        return new ResponseEntity<>(usuriousPersistido, CREATED);
    }

}

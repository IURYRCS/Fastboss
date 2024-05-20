package com.example.fastboss.CONTROLLER;

import com.example.fastboss.MODEL.Usuario;
import com.example.fastboss.SERVICE.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")


public class UsuarioController {
    @PostMapping()
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){

        Usuario response = usuarioService.salvar(usuario);
        return ResponseEntity.ok(response);
    }
    @Autowired
    UsuarioService usuarioService;

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<List<Usuario>> buscarTodos(){

        List<Usuario> response = usuarioService.buscarTodos();
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){

        Optional<Usuario> response = usuarioService.buscarPorId(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<List<Usuario>> buscarPorNome(@PathVariable String nome){

        List<Usuario> response = usuarioService.buscarPorNome(nome);
        if (response != null && !response.isEmpty()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping()
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario){

        if (!usuarioService.buscarPorId(Usuario.getId()).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioService.atualizar(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return usuarioService.deleteById(id);
    }


}

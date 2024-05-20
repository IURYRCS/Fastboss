package com.example.fastboss.SERVICE;

import com.example.fastboss.MODEL.Usuario;
import com.example.fastboss.REPOSITORY.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;


public class UsuarioService {

        @Autowired
        UsuarioRepository usuariorepository;

        public Usuario salvar(Usuario usuario){
            usuario.setAtivo(true);
            return usuariorepository.save(usuario);
        }

        public List<Usuario> buscarTodos(){
            List<Usuario> response = usuariorepository.findAll();
            response.removeIf(usuario -> !usuario.getAtivo());
            return response;
        }

        public Optional<Usuario> buscarPorId(Long id){
            return usuariorepository.findById(id);
        }

        public Usuario atualizar(Usuario usuario){
            return usuariorepository.save(usuario);
        }

        public List<Usuario> buscarPorNome(String nome){
            return usuariorepository.findByNomeAndAtivo(nome, true);
        }

        public ResponseEntity<?> deleteById(Long id) {

            Optional<Usuario> response = buscarPorId(id);

            if (!response.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            response.get().setAtivo(false);

            return ResponseEntity.ok(usuariorepository.save(response.get())) ;
        }

    }


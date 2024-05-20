package com.example.Fastboss.SERVICE;

import com.example.Fastboss.MODEL.Usuario;
import com.example.Fastboss.REPOSITORY.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
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


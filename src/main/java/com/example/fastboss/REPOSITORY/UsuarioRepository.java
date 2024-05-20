package com.example.fastboss.REPOSITORY;

import com.example.fastboss.MODEL.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<com.example.fastboss.MODEL.Usuario> findByNomeAndAtivo(String nome, Boolean status);
}


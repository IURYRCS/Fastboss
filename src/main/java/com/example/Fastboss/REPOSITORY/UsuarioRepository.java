package com.example.Fastboss.REPOSITORY;

import com.example.Fastboss.MODEL.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNomeAndAtivo(String nome, Boolean status);
}


package com.example.fastboss.MODEL;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Long cpf;

    private String login;

    private String senha;

    private Boolean ativo;

    public static Long getId() {
        return null;
    }

    public void setAtivo(boolean b) {
    }

    public List<Usuario> findByNomeAndAtivo(String nome, boolean b) {
        return List.of();
    }

    public boolean getAtivo() {
        return false;
    }
}

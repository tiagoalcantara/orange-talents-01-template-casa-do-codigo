package br.com.zup.casadocodigo.categoria.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false, unique = true)
    private String nome;

    @Deprecated
    public Categoria(){};

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

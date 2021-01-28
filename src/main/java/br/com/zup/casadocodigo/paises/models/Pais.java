package br.com.zup.casadocodigo.paises.models;

import br.com.zup.casadocodigo.estados.models.Estado;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Pais {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estados;

    @Deprecated
    public Pais(){}
    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Estado> getEstados() {
        return estados;
    }
}

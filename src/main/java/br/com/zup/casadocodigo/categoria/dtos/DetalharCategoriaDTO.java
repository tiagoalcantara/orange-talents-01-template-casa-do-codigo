package br.com.zup.casadocodigo.categoria.dtos;

import br.com.zup.casadocodigo.categoria.models.Categoria;

public class DetalharCategoriaDTO {
    private final Long id;
    private final String nome;

    public DetalharCategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

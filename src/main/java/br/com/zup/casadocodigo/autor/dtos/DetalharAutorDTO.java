package br.com.zup.casadocodigo.autor.dtos;

import br.com.zup.casadocodigo.autor.models.Autor;

public class DetalharAutorDTO {
    private final String nome;
    private final String descricao;

    public DetalharAutorDTO(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}

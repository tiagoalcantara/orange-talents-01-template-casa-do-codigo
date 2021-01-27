package br.com.zup.casadocodigo.paises.dtos;

import br.com.zup.casadocodigo.paises.models.Pais;

public class DetalharPaisDTO {
    private Long id;
    private String nome;

    public DetalharPaisDTO(Pais pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

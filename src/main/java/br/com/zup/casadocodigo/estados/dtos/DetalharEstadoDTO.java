package br.com.zup.casadocodigo.estados.dtos;

import br.com.zup.casadocodigo.estados.models.Estado;
import br.com.zup.casadocodigo.paises.dtos.DetalharPaisDTO;

public class DetalharEstadoDTO {
    private Long id;
    private String nome;
    private DetalharPaisDTO pais;

    public DetalharEstadoDTO(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.pais = new DetalharPaisDTO(estado.getPais());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public DetalharPaisDTO getPais() {
        return pais;
    }
}

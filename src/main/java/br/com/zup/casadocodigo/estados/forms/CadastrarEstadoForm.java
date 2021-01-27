package br.com.zup.casadocodigo.estados.forms;

import br.com.zup.casadocodigo.compartilhado.validators.ExistingId;
import br.com.zup.casadocodigo.compartilhado.validators.UniqueValue;
import br.com.zup.casadocodigo.estados.models.Estado;
import br.com.zup.casadocodigo.paises.models.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CadastrarEstadoForm {
    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;
    @NotNull
    @ExistingId(domainClass = Pais.class)
    private Long paisId;

    public CadastrarEstadoForm(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Estado toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, paisId);
        return new Estado(nome, pais);
    }
}

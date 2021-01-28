package br.com.zup.casadocodigo.paises.forms;

import br.com.zup.casadocodigo.compartilhado.validators.UniqueValue;
import br.com.zup.casadocodigo.paises.models.Pais;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class CadastrarPaisForm {
    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CadastrarPaisForm(@NotBlank String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }
}

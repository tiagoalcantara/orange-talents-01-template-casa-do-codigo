package br.com.zup.casadocodigo.categoria.forms;

import br.com.zup.casadocodigo.categoria.models.Categoria;
import br.com.zup.casadocodigo.compartilhado.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class CadastrarCategoriaForm {
    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CadastrarCategoriaForm(@NotBlank String nome) {
        this.nome = nome;
    }

    public Categoria toModel(){
        return new Categoria(this.nome);
    }
}

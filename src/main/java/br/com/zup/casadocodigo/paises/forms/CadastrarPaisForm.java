package br.com.zup.casadocodigo.paises.forms;

import br.com.zup.casadocodigo.compartilhado.validators.UniqueValue;
import br.com.zup.casadocodigo.paises.models.Pais;

import javax.validation.constraints.NotBlank;

public class CadastrarPaisForm {
    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }
}

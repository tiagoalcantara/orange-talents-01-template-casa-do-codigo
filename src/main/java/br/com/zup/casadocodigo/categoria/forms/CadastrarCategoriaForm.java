package br.com.zup.casadocodigo.categoria.forms;

import br.com.zup.casadocodigo.categoria.models.Categoria;
import br.com.zup.casadocodigo.compartilhado.validators.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CadastrarCategoriaForm {
    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel(){
        return new Categoria(this.nome);
    }
}

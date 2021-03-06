package br.com.zup.casadocodigo.autor.forms;

import br.com.zup.casadocodigo.autor.models.Autor;
import br.com.zup.casadocodigo.compartilhado.validators.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CadastrarAutorForm {
    @NotBlank
    private final String nome;
    @NotEmpty
    @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private final String email;
    @NotBlank
    @Size(max = 400)
    private final String descricao;

    public CadastrarAutorForm(@NotBlank String nome, @NotEmpty @Email String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }
}

package br.com.zup.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CadastrarAutorForm {
    @NotBlank
    private final String nome;
    @NotEmpty
    @Email
    private final String email;
    @NotBlank
    @Size(max = 400)
    private final String descricao;

    public CadastrarAutorForm(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor map() {
        return new Autor(nome, email, descricao);
    }
}

package br.com.zup.casadocodigo.autor.models;

import br.com.zup.casadocodigo.livros.models.Livro;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Autor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String nome;
    @NotEmpty
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @NotBlank
    @Size(max = 400)
    @Column(nullable = false)
    private String descricao;

    private final LocalDateTime dataCriacao = LocalDateTime.now();

    @Deprecated
    public Autor(){}

    public Autor(@NotBlank String nome, @NotEmpty @Email String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}

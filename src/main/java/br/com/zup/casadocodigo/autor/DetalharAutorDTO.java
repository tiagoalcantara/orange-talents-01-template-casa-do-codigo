package br.com.zup.casadocodigo.autor;

import java.time.LocalDateTime;

public class DetalharAutorDTO {
    private final Long id;
    private final String nome;
    private final String email;
    private final String descricao;
    private final LocalDateTime dataCriacao;

    public DetalharAutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataCriacao = autor.getDataCriacao();
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

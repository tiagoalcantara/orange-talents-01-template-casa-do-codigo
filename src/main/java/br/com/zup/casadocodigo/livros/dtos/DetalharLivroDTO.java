package br.com.zup.casadocodigo.livros.dtos;

import br.com.zup.casadocodigo.autor.dtos.DetalharAutorDTO;
import br.com.zup.casadocodigo.categoria.dtos.DetalharCategoriaDTO;
import br.com.zup.casadocodigo.livros.models.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DetalharLivroDTO {
    private final Long id;
    private final String titulo;
    private final String resumo;
    private final String sumario;
    private final BigDecimal preco;
    private final Integer qtdPaginas;
    private final String isbn;
    private final String dataPublicacao;
    private final DetalharAutorDTO autor;

    public DetalharLivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.qtdPaginas = livro.getQtdPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.autor = new DetalharAutorDTO(livro.getAutor());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public DetalharAutorDTO getAutor() {
        return autor;
    }
}


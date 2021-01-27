package br.com.zup.casadocodigo.livros.models;

import br.com.zup.casadocodigo.autor.models.Autor;
import br.com.zup.casadocodigo.categoria.models.Categoria;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    @Column(nullable = false)
    private String resumo;

    @NotBlank
    @Size(max=1000)
    @Column(nullable = false)
    private String sumario;

    @NotNull
    @Min(20)
    @Column(nullable = false)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    @Column(nullable = false)
    private Integer qtdPaginas;

    @NotNull
    @Pattern(regexp = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$")
    private String isbn;

    @NotNull
    @Future
    private LocalDate dataPublicacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @Deprecated
    public Livro() {}

    public Livro(
            @NotBlank String titulo,
            @NotBlank @Size(max = 500) String resumo,
            @NotBlank String sumario,
            @NotBlank @Min(20) BigDecimal preco,
            @NotBlank @Min(100) Integer qtdPaginas,
            @NotBlank @Pattern(regexp = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$") String isbn,
            @Future LocalDate dataPublicacao,
            @NotNull @Valid Autor autor,
            @NotNull @Valid Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.qtdPaginas = qtdPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }
}

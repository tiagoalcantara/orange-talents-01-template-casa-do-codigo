package br.com.zup.casadocodigo.livros.forms;

import br.com.zup.casadocodigo.autor.models.Autor;
import br.com.zup.casadocodigo.categoria.models.Categoria;
import br.com.zup.casadocodigo.compartilhado.validators.ExistingId;
import br.com.zup.casadocodigo.compartilhado.validators.UniqueValue;
import br.com.zup.casadocodigo.livros.models.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CadastrarLivroForm {
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    @Size(max = 1000)
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private Integer qtdPaginas;

    @NotNull
    @Pattern(regexp = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$")
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ExistingId(domainClass = Autor.class)
    private Long autorId;

    @NotNull
    @ExistingId(domainClass = Categoria.class)
    private Long categoriaId;

    public CadastrarLivroForm(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer qtdPaginas, @Pattern(regexp = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$") String isbn, @NotNull Long autorId, @NotNull Long categoriaId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.qtdPaginas = qtdPaginas;
        this.isbn = isbn;
        this.autorId = autorId;
        this.categoriaId = categoriaId;
    }

    // JsonFormat não funciona sem o set
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro toEntity(EntityManager manager) {
        @NotNull Categoria categoria = manager.find(Categoria.class, categoriaId);
        @NotNull Autor autor = manager.find(Autor.class, autorId);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.qtdPaginas,
                this.isbn, this.dataPublicacao, autor, categoria);
    }
}

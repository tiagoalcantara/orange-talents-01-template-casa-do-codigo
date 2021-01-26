package br.com.zup.casadocodigo.livros.dtos;

import br.com.zup.casadocodigo.livros.models.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class ListarLivrosDTO {
    private final Long id;
    private final String titulo;

    public ListarLivrosDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<ListarLivrosDTO> converterEmDTO(List<Livro> lista) {
        return lista.stream().map(ListarLivrosDTO::new).collect(Collectors.toList());
    }
}

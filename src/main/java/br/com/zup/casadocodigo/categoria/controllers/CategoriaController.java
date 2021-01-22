package br.com.zup.casadocodigo.categoria.controllers;

import br.com.zup.casadocodigo.categoria.dtos.DetalharCategoriaDTO;
import br.com.zup.casadocodigo.categoria.forms.CadastrarCategoriaForm;
import br.com.zup.casadocodigo.categoria.models.Categoria;
import br.com.zup.casadocodigo.categoria.repositories.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalharCategoriaDTO> cadastrar(@RequestBody @Valid CadastrarCategoriaForm form){
        Categoria novaCategoria = form.toModel();
        categoriaRepository.save(novaCategoria);
        return ResponseEntity.ok(new DetalharCategoriaDTO(novaCategoria));
    }
}

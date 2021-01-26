package br.com.zup.casadocodigo.livros.controllers;

import br.com.zup.casadocodigo.livros.dtos.DetalharLivroDTO;
import br.com.zup.casadocodigo.livros.forms.CadastrarLivroForm;
import br.com.zup.casadocodigo.livros.models.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalharLivroDTO> cadastrar(@RequestBody @Valid CadastrarLivroForm form) throws Exception {
        Livro novoLivro = form.toEntity(manager);
        manager.persist(novoLivro);
        return ResponseEntity.ok(new DetalharLivroDTO(novoLivro));
    }
}

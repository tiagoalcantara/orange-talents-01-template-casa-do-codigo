package br.com.zup.casadocodigo.livros.controllers;

import br.com.zup.casadocodigo.livros.dtos.DetalharLivroDTO;
import br.com.zup.casadocodigo.livros.dtos.ListarLivrosDTO;
import br.com.zup.casadocodigo.livros.forms.CadastrarLivroForm;
import br.com.zup.casadocodigo.livros.models.Livro;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping
    public ResponseEntity<List<ListarLivrosDTO>> listar() {
        List<Livro> lista =  manager.createQuery("SELECT l FROM Livro l").getResultList();
        return ResponseEntity.ok(ListarLivrosDTO.converterEmDTO(lista));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalharLivroDTO> detalhar(@PathVariable Long id){
        Livro livro = manager.find(Livro.class, id);

        if(livro == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new DetalharLivroDTO(livro));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalharLivroDTO> cadastrar(@RequestBody @Valid CadastrarLivroForm form) throws Exception {
        Livro novoLivro = form.toEntity(manager);
        manager.persist(novoLivro);
        return ResponseEntity.ok(new DetalharLivroDTO(novoLivro));
    }
}

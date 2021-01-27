package br.com.zup.casadocodigo.paises.controllers;

import br.com.zup.casadocodigo.paises.dtos.DetalharPaisDTO;
import br.com.zup.casadocodigo.paises.forms.CadastrarPaisForm;
import br.com.zup.casadocodigo.paises.models.Pais;
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
@RequestMapping("/pais")
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalharPaisDTO> cadastrar(@RequestBody @Valid CadastrarPaisForm form) {
        Pais novoPais = form.toModel();
        manager.persist(novoPais);
        return ResponseEntity.ok(new DetalharPaisDTO(novoPais));
    }
}

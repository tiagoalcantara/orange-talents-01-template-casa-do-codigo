package br.com.zup.casadocodigo.estados.controllers;

import br.com.zup.casadocodigo.estados.dtos.DetalharEstadoDTO;
import br.com.zup.casadocodigo.estados.forms.CadastrarEstadoForm;
import br.com.zup.casadocodigo.estados.models.Estado;
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
@RequestMapping("/estado")
public class EstadoController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalharEstadoDTO> cadastrar(@RequestBody @Valid CadastrarEstadoForm form) {
        Estado novoEstado = form.toModel(manager);
        manager.persist(novoEstado);
        return ResponseEntity.ok(new DetalharEstadoDTO(novoEstado));
    }
}

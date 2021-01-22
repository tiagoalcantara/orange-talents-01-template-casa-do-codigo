package br.com.zup.casadocodigo.autor.controllers;

import br.com.zup.casadocodigo.autor.repositories.AutorRepository;
import br.com.zup.casadocodigo.autor.forms.CadastrarAutorForm;
import br.com.zup.casadocodigo.autor.dtos.DetalharAutorDTO;
import br.com.zup.casadocodigo.autor.models.Autor;
import br.com.zup.casadocodigo.autor.validators.EmailUnicoValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final AutorRepository autorRepository;
    private final EmailUnicoValidator emailUnicoValidator;

    public AutorController(AutorRepository autorRepository, EmailUnicoValidator emailUnicoValidator) {
        this.autorRepository = autorRepository;
        this.emailUnicoValidator = emailUnicoValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(emailUnicoValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalharAutorDTO> cadastrar(@RequestBody @Valid CadastrarAutorForm form) {
        Autor novoAutor = form.toModel();
        autorRepository.save(novoAutor);
        return ResponseEntity.ok(new DetalharAutorDTO(novoAutor));
    }
}

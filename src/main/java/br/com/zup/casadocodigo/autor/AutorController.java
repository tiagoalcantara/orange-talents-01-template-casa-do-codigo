package br.com.zup.casadocodigo.autor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalharAutorDTO> cadastrar(@RequestBody @Valid CadastrarAutorForm form) {
        Autor novoAutor = form.map();
        autorRepository.save(novoAutor);
        return ResponseEntity.ok(new DetalharAutorDTO(novoAutor));
    }
}
